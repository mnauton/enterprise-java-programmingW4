package InputOutputDemo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessDemo {

	public static void main(String[] args) {
		try {
			RandomAccessFile rfile = new RandomAccessFile("/test.txt", "rw");

			// write data to position 500
			String data = "Hello random access file, message from CT5168";
			rfile.seek(500);
			rfile.writeUTF(data);

			// read data from position 500
			rfile.seek(500);
			System.out.println(rfile.readUTF());

			// write to the last known position
			data = "This is the end pointer for this file";
			long index = rfile.getFilePointer();
			rfile.seek(index);
			System.out.println("Pointer to write: " + index);
			rfile.writeUTF(data);
			System.out.println("Pointer to write: " + rfile.getFilePointer());

			// close your file
			rfile.close();

		} catch (IOException ex) { ex.printStackTrace(); };
	}

}
