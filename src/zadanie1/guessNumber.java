package zadanie1;

import java.util.Random;
import java.util.Scanner;

public class guessNumber {

	public static void guessNumber(int min, int max, int bids) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int numberToGuess = rand.nextInt(max - min + 1) + min;
		int counter = 0;
		System.out.println(
				"Podaj liczbę z zakresu " + min + " - " + max + ".\nMasz " + bids + " prób, aby zgadnąć liczbę.");
		while (true) {
			int g = scan.nextInt();
			if (g < numberToGuess) {
				System.out.println("Twoja liczba jest za mała");
			}
			if (g > numberToGuess) {
				System.out.println("Twoja liczna jest za duża");
			}
			if (g == numberToGuess) {
				System.out.println("Trafiłeś!");
				break;
			}
			counter++;
			if (counter == bids) {
				System.out.println("Limit prób wyczerpany.");
				System.out.println("Koniec gry");
				break;
			}
		}
	}

	public static void main(String args[]) {
		guessNumber(1, 100, 10);
	}

}
