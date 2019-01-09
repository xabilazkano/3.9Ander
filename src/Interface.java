import java.util.Scanner;
import hangman.Game;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Game hang = new Game();
			int flag = 0;

			hang.printGuessed();

			while (flag < 3) {

				System.out.println();
				System.out.println("Enter a letter");

				// Create a string object with the letter's value

				String possibleLetter = sc.next().toLowerCase();
				String[] letterArray = possibleLetter.split(" ");
				if (hang.isLetter(letterArray)) {
					// Check that the player has entered just a character

					hang.checkLetter(letterArray[0].charAt(0));
					flag++;
					hang.printGuessed();
					System.out.println();

				}
				// If the player entered more than one characters, ask him/her to enter just one
				else {
					System.out.println("Don't cheat, please enter a letter.");
				}

			}
			System.out.println("Three letters tried, now is time to guess the surname");
			System.out.println("Enter a surname");
			sc.nextLine();
			String playerWord = sc.nextLine().toLowerCase();
			String[] playerWordArray = playerWord.split(" ");
			if (hang.isWord(playerWordArray)) {
				if (hang.checkWord(playerWord)) {
					System.out.println("Congratulations the surname was " + playerWord);
				} else {
					System.out.println("Sorry, you loose");
				}
			} else {
				System.out.println("Enter just one word");
			}

			System.out.println("Do you want to play again? ");
			boolean incorrectResponse = true;
			while (incorrectResponse) {
				String choose = sc.next();
				if (choose.equals("yes")) {

					incorrectResponse = false;
				} else if (choose.equals("no")) {
					System.out.println("Bye!");
					playAgain = false;
					incorrectResponse = false;
				} else {
					System.out.println("Enter a valid option (yes/no)");
				}
			}
		}

	}

}