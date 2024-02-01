package SocketDemo;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("universityofgalway.ie", 80);
		InputStream instream = socket.getInputStream();
		OutputStream outstream = socket.getOutputStream();
		
		Scanner in = new Scanner(instream);
		PrintWriter out = new PrintWriter(outstream);
		String command = "GET / HTTP/1.0\n";  // request message to the server
		                                      
		out.println(command);
		out.flush();

		FileWriter foutput = new FileWriter("/home/margaux/java-workspace/EnterpriseJavaProgrammingW4/src/SocketDemo/test.txt");
		//BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while (in.hasNextLine()) { // receive response from server
			String input = in.nextLine();
			System.out.println(input);
			foutput.write(input + "\n");
		}

/*
		String l;
		while ((l = bufIn.readLine()) != null)
			foutput.write(l + "\n");
*/

		// always close sockets and streams after use!
		foutput.close();
		in.close(); 
		out.close();
		socket.close(); 
	}

}
