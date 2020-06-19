package properties.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReaderMain {
	
	BufferedReader br; 
	String path = "C:\\Users\\Fidel\\Desktop\\test.txt";
	
	public PropReaderMain() {
		System.out.println("===Started===");
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//readPlain();
		String[] keys = {"Name", "Email", "Password"};
		readProperties(keys);
	}
	
	private void readProperties(String[] keys) {
		try (InputStream input = new FileInputStream(path)) {

			Properties prop = new Properties();
			prop.load(input);

			for (int i = 0; i < keys.length; i++) {
				System.out.println(keys[i] + " = " + prop.getProperty(keys[i]));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void readPlain() {
		try {
			String st; 
			while ((st = br.readLine()) != null) {
				System.out.println(st); 
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new PropReaderMain();
		System.out.println("===Ended===");
	}
	
}
