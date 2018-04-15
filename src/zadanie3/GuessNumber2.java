package zadanie3;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber2 {

	//metoda zwraca losową liczbę z danego zakresu (wartości graniczne wchodzą do zakresu)
	public static int getRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public static void guessNumber(int indexMin, int indexMax, int maxBids) {
		int myNumber;
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Podaj liczbę z zakresu " + indexMin + " - " + indexMax);
			try {
				myNumber = scan.nextInt();
				if((myNumber > indexMax) | (myNumber < indexMin)) {
					throw new Exception();
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("To nie jest liczba!");
			} catch (Exception e) {
				System.out.println("Liczba poza zakresem!");
			}

		}
		System.out.println("Maksymalna ilość prób wynosi: " + maxBids);
		int counter = 0;
		while (indexMin <= indexMax) {
			int guess = getRandom(indexMin, indexMax);
			counter++;
			System.out.print("Komputer wybiera liczbę " + guess);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (guess < myNumber) {
				System.out.println("\t-za mało!");
				indexMin = guess + 1;
			}
			if (guess > myNumber) {
				System.out.println("\t-za dużo!");
				indexMax = guess - 1;
			}
			if (guess == myNumber) {
				System.out.println("\t-trafiony!");
				break;
			}
			if (counter == maxBids) {
				System.out.println("Limit prób wyczerpany!");
				break;
			}
		}
		System.out.println("Koniec gry.");

	}

	public static void main(String args[]) {
		guessNumber(1, 1000, 9);
	}

}
