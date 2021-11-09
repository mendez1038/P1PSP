import java.io.IOException;

import javax.swing.JOptionPane;

import Utils.FileManagedment;

public class Main {

	public static void main(String[] args) {
		//String rutaArchivoLeer = args[0];
		//String rutaCarpetaClases = args[1];
		String[] vocales = {"a", "e", "i", "o", "u"};
		String rutaArchivoEscribir = "";
		String argumentos;
		if (args.length > 2) {
			JOptionPane.showMessageDialog(null, "Demasiados parámetros");
		} else if(args.length == 0) {
			JOptionPane.showMessageDialog(null, "No hay parámetros");
		} else {
			try {
				//Crear archivo de escritura
				argumentos = args[0]+" "+vocales[0]+" "+rutaArchivoEscribir;
				//Concatenar a args[1] el nombre de la clase que se tiene que ejecutar
				Process pbA = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[1]+" "+rutaArchivoEscribir;
				Process pbE = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[2]+" "+rutaArchivoEscribir;
				Process pbI = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[3]+" "+rutaArchivoEscribir;
				Process pbO = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[4]+" "+rutaArchivoEscribir;
				Process pbU = new ProcessBuilder(args[1], argumentos).start();
				//Leer el archivo de escritura y mostrar resultado por pantalla
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
