import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManagedment {

	public static boolean counter(String fileName, char vowel, char vowelCapital, String fileResultName) {
		boolean b = false;
		String linea = null;
		@SuppressWarnings("unused")
		String linea2 = null;
		int contador = 0;
		BufferedReader br = FileProperties.getBufferedReader(fileName);
		BufferedReader br2 = FileProperties.getBufferedReader(fileResultName);
		PrintWriter pw = FileProperties.getPrintWriter(fileResultName);

		try {
			while ((linea = br.readLine()) != null) {
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) == vowel || linea.charAt(i) == vowelCapital) {
						contador++;
					}
				}
			}
			pw.write(contador);
			if ((linea2 = br2.readLine()) != null) {
				b = true;
			}

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

	public static void main(String[] args) {
		char vowel = args[1].charAt(0);
		char vowelCapital = args[1].toUpperCase().charAt(0);
		counter(args[0], vowel, vowelCapital, args[2]);
	}

}
