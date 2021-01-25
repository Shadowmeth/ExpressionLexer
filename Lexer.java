
public class Lexer {
	private String code;
	private int dot, startDot;
	private int codeLength;
	public Token token;
	
	public Lexer(String code) {
		this.code = code;
		dot = startDot = 0;
		codeLength = code.length();
		token = new Token();
	}
	
	private void saveCurrentPosition() {
		startDot = dot;
	}
	
	private char nextChar() {
		if (dot >= codeLength) {
			return '#'; // indicates EOF for now
		} else {
			return code.charAt(dot);
		}
	}
	
	private void skipLayoutChars() {
		char c;
		do {
			c = nextChar();
			if (c == ' ' || c == '\t') {
				dot++;
			}
			
		} while(c == ' ' || c == '\t');
		
	}
	
	private void number() {
		char c;
		do {
			c = nextChar();
			if (c >= '0' && c <= '9') {
				dot++;
			}
			
		} while(c >= '0' && c <= '9');
	}
	
	// this function modifies the token and returns it
	public void getNextToken() {
		skipLayoutChars();
		
		saveCurrentPosition();
		
		if (dot >= codeLength) {
			token.tokenType = 256;
			token.repr = '#';
			// EOF Found, no need to increment dot
			return;
		}
		
		switch (code.charAt(dot)) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			number();
			token.tokenType = 257;
			token.numberValue = Integer.parseInt(code.substring(startDot, dot));
			break;
		}
		case '+':
		case '*':
		case '(':
		case ')': {
			token.tokenType = 258;
			token.repr = code.charAt(dot);
			dot++;
			break;
		}
		default: {
			// accept no other char
			System.out.println("Error: Invalid character '" + code.charAt(dot) + "' found");
			System.out.println("In expression: " + code);
			
			System.out.print("               ");
			for (int i = 0; i < dot; i++) {
				System.out.print(" ");
				
			}
			System.out.println("^");
			
			System.exit(1);
		}
		
		}
	}
	
}
