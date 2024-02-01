package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class DailyAdviceClient {
	
	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		try {
			client.go();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void go() throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1", 4242);

		PrintWriter writer = new PrintWriter(s.getOutputStream());
		writer.println("GET-B");
		writer.flush();

		InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
		BufferedReader reader = new BufferedReader(streamReader);
		
		String advice = reader.readLine();
		System.out.println("Today, you should " + advice);
		
		// close stream and socket
		reader.close();
		s.close();
	}
}
