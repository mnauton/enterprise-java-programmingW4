package InputOutputDemo;

import java.io.*;
import java.util.Scanner;

public class ScanFile {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("/home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//dummy.txt")));
            s.useDelimiter("a+");
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
