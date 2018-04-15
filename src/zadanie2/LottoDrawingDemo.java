package zadanie2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import zadanie2.NumberDuplicateException;
import zadanie2.NumberOutOfRangeException;

public class LottoDrawingDemo {
	public static int getRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public static int numberInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg);
		return scan.nextInt();
	}

	public static boolean checkForDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] != 0 && arr[j] == arr[i]) {
					return true;
				}
			}
		}
		return false;
	}

	public static int arrayCompare(int[] arr1, int[] arr2) {
		int counter = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[j] == arr2[i]) {
					counter++;
				}
			}
		}
		return counter;
	}

	public static int[] numberPicking(int number) {
		int[] myNumbers = new int[number];
		System.out.println("Rozpoczynamy losowanie Lotto!");
		for (int i = 1; i <= number; i++) {
			while (true) {
				try {
					myNumbers[i - 1] = numberInput(i + ". Podaj liczbę z zakresu 1 - 49");
					if (myNumbers[i - 1] < 1 | myNumbers[i - 1] > 49) {
						throw new NumberOutOfRangeException();
					} else if (checkForDuplicates(myNumbers)) {
						throw new NumberDuplicateException();
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("To nie jest liczba!");
				} catch (NumberDuplicateException e) {
					System.out.println(e.toString());
				} catch (NumberOutOfRangeException e) {
					System.out.println(e.toString());
				}
			}
		}
		Arrays.sort(myNumbers);
		return myNumbers;
	}

	public static void printLottoArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " - ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(arr[arr.length - 1]);
	}

	public static int[] newLottoDrawing(int howMany) {
		int[] arr = new int[howMany];
		for (int i = 0; i < arr.length; i++) {
			while (true) {
				arr[i] = getRandom(1, 49);
				if (!checkForDuplicates(arr)) {
					break;
				}
			}
		}
		Arrays.sort(arr);
		return arr;
	}

	public static void showResults(int[] myNumbers, int[] lottoNumbers) {
		int numbersGuessed = arrayCompare(myNumbers, lottoNumbers);
		switch (numbersGuessed) {
		case 0:
			System.out.println("Niestety nie trafiłeś ani jednej liczby.");
		case 1:
			System.out.println("Trafiłeś jedną liczbę.");
			break;
		case 2:
			System.out.println("Trafiłeś dwie liczby!");
			break;
		case 3:
			System.out.println("Gratulacje! Trafiłeś trzy liczby.");
			break;
		case 4:
			System.out.println("Gratulacje! Trafiłeś cztery liczby.");
			break;
		case 5:
			System.out.println("Na prawdę masz szczęście! Trafiłeś pięć liczb!");
			break;
		case 6:
			System.out.println("Niewiarygodne! Trafiłeś szóstkę! Wygrałeś milion złotych!!!");
			break;
		}
	}

	public static void main(String[] args) {
		int[] myNumbers = numberPicking(6);
		System.out.println("Twoje typy to: ");
		printLottoArray(myNumbers);
		System.out.println("Maszyna wylosowała następujące liczby: ");
		int[] lottoNumbers = newLottoDrawing(6);
		printLottoArray(lottoNumbers);
		showResults(myNumbers, lottoNumbers);
	}
}
