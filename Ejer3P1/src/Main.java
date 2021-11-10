import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// rutaArchivoLeer = args[0];
		// rutaCarpetaClases = args[1];
		String[] vocales = {"a", "e", "i", "o", "u"};
		String rutaArchivoEscribir = "";
		String argumentos;
		BufferedReader br = null;
		String linea;
		String[] valores = null;
		int resultado = 0;
		
		
		if (args.length > 2) {
			JOptionPane.showMessageDialog(null, "Demasiados parámetros");
		} else if(args.length < 2) {
			JOptionPane.showMessageDialog(null, "Faltan parámetros");
		} else {
			try {
				
				/*
				 * 	Creamos el archivo donde escribiremos los resultados de los contadores
				 */
				File archivoEscribir = new File("\\Ficheros\\resultado.txt");
				archivoEscribir.createNewFile();
				rutaArchivoEscribir = archivoEscribir.getAbsolutePath();
				
				/*
				 * Creamos los subprocesos que contarán cada vocal
				 */
				argumentos = args[0]+" "+vocales[0]+" "+rutaArchivoEscribir;
				//Concatenar a args[1] el nombre de la clase que se tiene que ejecutar
				//Como?????
				Process pbA = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[1]+" "+rutaArchivoEscribir;
				Process pbE = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[2]+" "+rutaArchivoEscribir;
				Process pbI = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[3]+" "+rutaArchivoEscribir;
				Process pbO = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[4]+" "+rutaArchivoEscribir;
				Process pbU = new ProcessBuilder(args[1], argumentos).start();
				
				
				/*
				 * Leer el archivo de escritura y mostrar resultado por pantalla
				 */
				br = Utils.FileProperties.getBufferedReader(rutaArchivoEscribir);
				while ((linea = br.readLine())!=null) {
					valores = linea.split(";");
				}
				for (String string : valores) {
					resultado += Integer.parseInt(string);
				}
				JOptionPane.showMessageDialog(null, "La suma de las vocales del fichero es "+resultado);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
