import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class FileManagedment {

	
	/*
	 * Lee el fichero que se le pasa en el primer parámetro, cuenta el número de vocales que hay en él
	 * y escribe este conteo en el fichero que se pasa por el último parámetro. Devuelve true si la 
	 * escrituro ha sido exitosa.
	 */
	public static boolean counter(String fileName, char vowel, char vowelCapital, String fileResultName) {
		boolean b = false;
		String linea = null;
		int contador = 0;
		BufferedReader br = FileProperties.getBufferedReader(fileName);
		PrintWriter pw = FileProperties.getPrintWriter(fileResultName);

		try {
			while ((linea = br.readLine()) != null) {
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) == vowel || linea.charAt(i) == vowelCapital) {
						contador++;
					}
				}
			}
			pw.write(""+contador+"");
			b = true;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return b;

	}

	/*
	 * Llama al método counter
	 */
	public static void main(String[] args) {
		char vowel = args[1].charAt(0);
		char vowelCapital = args[1].toUpperCase().charAt(0);
		if(counter(args[0], vowel, vowelCapital, args[2])) {
			JOptionPane.showMessageDialog(null, "Se ha escrito en el archivo");
		} else {
			JOptionPane.showMessageDialog(null, "Error al contar las vocales");
		}
	}

}
