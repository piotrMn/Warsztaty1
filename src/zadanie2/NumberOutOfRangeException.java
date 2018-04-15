package zadanie2;

public class NumberOutOfRangeException extends Exception {
	private String message;

	NumberOutOfRangeException() {
		message = "Liczba poza zakresem.";
	}

	public String toString() {
		return message;
	}
}
