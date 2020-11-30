import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLTest extends Thread{

	public static void main(String[] args) {
		try {
			URL url =new URL("https://lagonika.gr");
			URLConnection myURL = url.openConnection();
			URLConnection myURL2 = url.openConnection();
			String line;
			File file1 = new File("lagonika.txt");
			File file2 = new File("lagonika_2.txt");
			FileWriter output = new FileWriter(file1,false);
			FileWriter output2 = new FileWriter(file2,false);
			BufferedReader input;
			BufferedReader input2;
			input = new BufferedReader(new InputStreamReader(myURL.getInputStream()));
			input2 = new BufferedReader(new InputStreamReader(myURL2.getInputStream()));
			
			while (true) {
			while ((line=input.readLine()) !=null) {
				output.write(line);
			}
			output.close();
			
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			line="";
			
			while ((line=input2.readLine()) !=null) {
				output2.write(line);
			}
			output2.close();

			if (file1.getTotalSpace()==file2.getTotalSpace())
				System.out.println("IDIA");
			else
				System.out.println("OXI IDIA");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
