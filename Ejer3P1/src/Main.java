import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		/*
		 * Inicializamos las variables
		 */
		String[] vocales = {"a", "e", "i", "o", "u"};
		String[] rutaArchivoEscribir = new String[5];
		BufferedReader br = null;
		PrintWriter pw = null;
		String linea = "";
		String[] valores = new String[5];
		String comando1 = "java";
		String comando2 = "-cp";
		String comando3 = ".";
		String rutaResultado = ""; 
		String cadena;
		int resultado = 0;
		
		/*
		 * Control de la cantidad de parámetros que entran
		 */
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
				 * 	Creamos los archivo donde escribiremos los resultados de los contadores y almacenamos sus rutas en el array 
				 */
				for (int i = 0; i < vocales.length; i++) {	
					rutaArchivoEscribir[i] = createArchivoTemp(vocales[i]);
				}
				rutaResultado = createArchivoTemp("restultado");
				
				/*
				 * Creamos los subprocesos que contarán cada vocal
				 */
				ProcessBuilder pbA = new ProcessBuilder();
				pbA.command(comando1,comando2,comando3, "FileManagedment", args[0], vocales[0], rutaArchivoEscribir[0]);
				pbA.directory(new File(args[1]));
				pbA.inheritIO();				
				Process processA = pbA.start();
				processA.waitFor();
				
				ProcessBuilder pbE = new ProcessBuilder();
				pbE.command(comando1,comando2,comando3, "FileManagedment", args[0], vocales[1], rutaArchivoEscribir[1]);
				pbE.directory(new File(args[1]));
				pbE.inheritIO();				
				Process processE = pbE.start();
				processE.waitFor();

				ProcessBuilder pbI = new ProcessBuilder();
				pbI.command(comando1,comando2,comando3, "FileManagedment", args[0], vocales[2], rutaArchivoEscribir[2]);
				pbI.directory(new File(args[1]));
				pbI.inheritIO();				
				Process processI = pbI.start();
				processI.waitFor();

				ProcessBuilder pbO = new ProcessBuilder();
				pbO.command(comando1,comando2,comando3, "FileManagedment", args[0], vocales[3], rutaArchivoEscribir[3]);
				pbO.directory(new File(args[1]));
				pbO.inheritIO();				
				Process processO = pbO.start();
				processO.waitFor();

				ProcessBuilder pbU = new ProcessBuilder();
				pbU.command(comando1,comando2,comando3, "FileManagedment", args[0], vocales[4], rutaArchivoEscribir[4]);
				pbU.directory(new File(args[1]));
				pbU.inheritIO();				
				Process processU = pbU.start();
				processU.waitFor();

				/*
				 * Comprobar que los procesos terminador
				 */
				if(!processA.isAlive() &&!processE.isAlive() &&!processI.isAlive() &&!processO.isAlive() &&!processU.isAlive()) {
					
					/*
					 * Leer el archivo de escritura 
					 */
					br = FileProperties.getBufferedReader(rutaArchivoEscribir[0]);
					while ((linea = br.readLine())!=null) {
						valores[0] = linea;
					}
					br = FileProperties.getBufferedReader(rutaArchivoEscribir[1]);
					while ((linea = br.readLine())!=null) {
						valores[1] = linea;
					}
					br = FileProperties.getBufferedReader(rutaArchivoEscribir[2]);
					while ((linea = br.readLine())!=null) {
						valores[2] = linea;
					}
					br = FileProperties.getBufferedReader(rutaArchivoEscribir[3]);
					while ((linea = br.readLine())!=null) {
						valores[3] = linea;
					}
					br = FileProperties.getBufferedReader(rutaArchivoEscribir[4]);
					while ((linea = br.readLine())!=null) {
						valores[4] = linea;
					}
					
					/*
					 * Calcular la suma de los contadores
					 */
					for (String string : valores) {
						resultado += Integer.parseInt(string);
					}
					
					/*
					 * Escribimos en el fichero resultado las cifras obtenidas
					 */
					pw = FileProperties.getPrintWriter(rutaResultado);
					cadena = "El resultado del contador de la letra A es: "+valores[0]
							+ "\n El resultado del contador de la letra E es: "+valores[1]
							+ "\n El resultado del contador de la letra I es: "+valores[2]
							+ "\n El resultado del contador de la letra O es: "+valores[3]
							+ "\n El resultado del contador de la letra U es: "+valores[4]
							+ "\n La suma de las vocales del fichero es "+resultado;
					pw.write(cadena);
					
					/*
					 * Leemos el fichero resultado mostramos por pantalla el contenido
					 */
					br = FileProperties.getBufferedReader(rutaResultado);
					while ((linea = br.readLine())!=null) {
						cadena += linea+"\n";
					}
					JOptionPane.showMessageDialog(null, cadena);
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Archivo no encontrado o Clases Java no encontradas",
						"PSP Práctica 1", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				System.exit(-1);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
