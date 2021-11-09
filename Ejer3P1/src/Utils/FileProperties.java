package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProperties {

	public static BufferedReader getBufferedReader(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return br;
	}

	public static PrintWriter getPrintWriter(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fileName), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
}
