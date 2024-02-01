package InputOutputDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("//home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//dummy.txt");
            out = new FileOutputStream("//home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//writeDummy.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}