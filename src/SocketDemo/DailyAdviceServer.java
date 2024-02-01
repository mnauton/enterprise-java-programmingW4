package SocketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = { "take smaller bites", 
			"go for the tight jeans, No, they do NOT make you look fat",
			"be honest - tell your boss what you really think",
			"rethink that haircut" };

	String[] movieLine = {"I'll be back", "May the force be with you", "Just keep swimming", "If you build it, he will come"};
	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		try {
			server.go();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void go() throws IOException {
		try (ServerSocket serverSock = new ServerSocket(4242)) {
			while(true) {
				Socket s = serverSock.accept();

				BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter writer = new PrintWriter(s.getOutputStream());
				String advice = getAdvice(input.readLine());
				writer.println(advice);
				writer.close();
			}
		}
	}

	private String getAdvice(String input) {
		System.out.println(input);
		int random;
		if (input.equals("GET-A")) {
			random = (int) (Math.random() * adviceList.length);
			return adviceList[random];
		}
		random = (int) (Math.random() * movieLine.length);
		return movieLine[random];
	}
}
