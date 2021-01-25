
public class Token {
	public int tokenType; // 256 is end of source, 257 is number, 258 is operator or parenthesis
	public int numberValue; // access this only if tokenType == 257
	public char repr; // access this only if tokenType == 258
	
}
