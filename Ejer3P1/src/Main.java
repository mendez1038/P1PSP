

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// rutaArchivoLeer = args[0];
		// rutaCarpetaClases = args[1];
		String[] vocales = {"a", "e", "i", "o", "u"};
		String[] rutaArchivoEscribir = new String[5];
		String argumentos;
		BufferedReader br = null;
		String linea;
		String[] valores = null;
		String comando = "java";
		int resultado = 0;
		
		
		if (args.length > 2) {
			JOptionPane.showMessageDialog(null, "ERROR: Demasiados parámetros\n Uso correcto: java Main <file> <PathToJavaClass>",
					"PSP Práctica 1", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		} else if(args.length < 2) {
			JOptionPane.showMessageDialog(null, "ERROR: Faltan parámetros\n Uso correcto: java Main <file> <PathToJavaClass>",
					"PSP Práctica 1", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		} else {
			try {
				
				/*
				 * 	Creamos los archivo donde escribiremos los resultados de los contadores
				 */
				for (int i = 0; i < vocales.length; i++) {	
					rutaArchivoEscribir[i] = createArchivoTemp(vocales[i]);
				}
				
				/*
				 * Creamos los subprocesos que contarán cada vocal
				 */
				//argumentos = args[0]+" "+vocales[0]+" "+rutaArchivoEscribir[0];
				ProcessBuilder pbA = new ProcessBuilder();
				pbA.command(comando,"FileManagedment", args[0],vocales[0],rutaArchivoEscribir[0]);
				pbA.directory(new File(args[1]));
				System.out.println("Proceso A");
				System.out.println("Argumento 0: "+args[0]);
				System.out.println("Argumento 1: "+vocales[0]);
				System.out.println("Argumento 2: "+rutaArchivoEscribir[0]);
				System.out.println("Directorio: "+args[1]);
				Process processA = pbA.start();
				
				/*
				 * Comprobar que los procesos terminador
				 */
				if(!processA.isAlive()) {
					System.out.println("Proceso terminado");

				}
				/*
				 * Leer el archivo de escritura 
				 */
				br = FileProperties.getBufferedReader(rutaArchivoEscribir[0]);
				while ((linea = br.readLine())!=null) {
					valores[0] = linea;
				}
				
				
				/*argumentos = args[0]+" "+vocales[1]+" "+rutaArchivoEscribir;
				Process pbE = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[2]+" "+rutaArchivoEscribir;
				Process pbI = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[3]+" "+rutaArchivoEscribir;
				Process pbO = new ProcessBuilder(args[1], argumentos).start();
				argumentos = args[0]+" "+vocales[4]+" "+rutaArchivoEscribir;
				Process pbU = new ProcessBuilder(args[1], argumentos).start();
				
				*/
				
				for (String string : valores) {
					resultado += Integer.parseInt(string);
				}
				JOptionPane.showMessageDialog(null, "La suma de las vocales del fichero es "+resultado);
				
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Archivo no encontrado o Clases Java no encontradas",
						"PSP Práctica 1", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				System.exit(-1);
			}
		}

	}
	
	 private static String createArchivoTemp(String letra) {
		 
		 File archivoEscribir = new File("C:\\Users\\Usuario\\git\\repositoryPSP\\Ejer3P1\\Ficheros\\"+letra+".txt");
		 if(archivoEscribir.exists()) {	
		 }else {
			 try {
				 archivoEscribir.createNewFile();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 }
		return archivoEscribir.getAbsolutePath();
		
	}


}
