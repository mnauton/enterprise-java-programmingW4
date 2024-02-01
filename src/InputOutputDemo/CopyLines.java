package InputOutputDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {

    		/* This is a copy line example for a string characters with a line terminator at the end (\r or \n or \r\n)
         * we are using a line-oriented I/O operation using BufferedReader.readLine(),
         *  and FileWriter object wrapped inside an outputStream
         */ 
	
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//dummy.txt"));
            outputStream = new PrintWriter(new FileWriter("/home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//characterLineDummy.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}

