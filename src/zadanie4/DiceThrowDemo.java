package zadanie4;

import java.util.Random;
import java.util.StringTokenizer;

public class DiceThrowDemo {
	public static int throwDice(int dice, int faces, int increment) {
		Random rand = new Random();
		int result = 0;
		for (int i = 0; i < dice; i++) {
			result += rand.nextInt(faces) + 1;
		}
		return result + increment;
	}

	public static int diceCodeInterpreter(String str) {
		StringTokenizer st = new StringTokenizer(str.trim().toLowerCase(), "+");
		int dice, faces, increment = 0;
		String firstPart, secondPart;
		firstPart = st.nextToken();
		if (st.hasMoreTokens()) {
			secondPart = st.nextToken();
		} else {
			secondPart = "";
		}
		String[] arr = firstPart.split("d");
		try {
			dice = Integer.parseInt(arr[0]);
			faces = Integer.parseInt(arr[1]);
			if (!secondPart.equals("")) {
				increment = Integer.parseInt(secondPart);
			}
		} catch (NumberFormatException e) {
			System.out.println("Nie można zinterpretować kodu.");
			return 0;
		}
		return throwDice(dice, faces, increment);
	}

	public static void main(String args[]) {
		System.out.println(diceCodeInterpreter("2D10+12"));
		System.out.println(diceCodeInterpreter("3D6"));
	}
}
