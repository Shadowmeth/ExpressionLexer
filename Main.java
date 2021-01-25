import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter expression: ");
		String code = input.nextLine();
		
		Lexer lexer = new Lexer(code);
		
		lexer.getNextToken();
		while (lexer.token.tokenType != 256) {
			if (lexer.token.tokenType == 257) {
				System.out.println("Number		: " + lexer.token.numberValue);
			} else {
				System.out.println("Character	: " + lexer.token.repr);
			}
			
			lexer.getNextToken();
		}
		
	}

}
