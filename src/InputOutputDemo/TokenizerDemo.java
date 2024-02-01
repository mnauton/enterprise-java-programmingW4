package InputOutputDemo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class TokenizerDemo {

	private static final int QUOTE_CHARACTER = '\'';
	private static final int DOUBLE_QUOTE_CHARACTER = '"';

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Reader fReader = new FileReader("/home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//test.txt");
			List<Object> defTokens = streamTokenizerWithDefaultConfiguration(fReader);
			for (Object o : defTokens) {
				System.out.println(o.getClass().getSimpleName() + " = " + o.toString());
			}
		} catch (IOException ex) { ex.printStackTrace(); };

		System.out.println();

		try {
			Reader fReader = new FileReader("//home//margaux//java-workspace//EnterpriseJavaProgrammingW4//src//InputOutputDemo//test.txt");
			List<Object> cusTokens = streamTokenizerWithCustomConfiguration(fReader);
			for (Object o : cusTokens) {
				System.out.println(o.getClass().getSimpleName() + " = " + o.toString());
			}
		} catch (IOException ex) { ex.printStackTrace(); };
	}

	public static List<Object> streamTokenizerWithDefaultConfiguration(Reader reader) throws IOException {
	    StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
	    List<Object> tokens = new ArrayList<Object>();

	    int currentToken = streamTokenizer.nextToken();
	    while (currentToken != StreamTokenizer.TT_EOF) {

	        if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
	            tokens.add(streamTokenizer.nval);
	        } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
	            || streamTokenizer.ttype == QUOTE_CHARACTER
	            || streamTokenizer.ttype == DOUBLE_QUOTE_CHARACTER) {
	            tokens.add(streamTokenizer.sval);
	        } else {
	            tokens.add((char) currentToken);
	        }

	        currentToken = streamTokenizer.nextToken();
	    }

	    return tokens;
	}

	public static List<Object> streamTokenizerWithCustomConfiguration(Reader reader) throws IOException {
	    StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
	    List<Object> tokens = new ArrayList<Object>();

	    streamTokenizer.wordChars('!', '-');
	    streamTokenizer.ordinaryChar('/');
	    streamTokenizer.commentChar('#');
	    streamTokenizer.eolIsSignificant(true);

	    // same as before
	    int currentToken = streamTokenizer.nextToken();
	    while (currentToken != StreamTokenizer.TT_EOF) {

	        if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
	            tokens.add(streamTokenizer.nval);
	        } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
	            || streamTokenizer.ttype == QUOTE_CHARACTER
	            || streamTokenizer.ttype == DOUBLE_QUOTE_CHARACTER) {
	            tokens.add(streamTokenizer.sval);
	        } else {
	            tokens.add((char) currentToken);
	        }

	        currentToken = streamTokenizer.nextToken();
	    }
	    return tokens;
	}
}
