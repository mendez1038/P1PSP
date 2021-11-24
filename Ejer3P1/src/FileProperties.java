

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProperties {

	/*
	 * Crea un BufferedReader y lo devuelve
	 */
	
	public static BufferedReader getBufferedReader(String fileName) {
		System.out.println(fileName);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return br;
	}

	/*
	 * Crea un PrintWriter y lo devuelve
	 */
	public static PrintWriter getPrintWriter(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
}
