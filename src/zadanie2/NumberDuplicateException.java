package zadanie2;

public class NumberDuplicateException extends Exception {

	private String message;

	NumberDuplicateException() {
		message = "Ju� poda�e� t� liczb�.";
	}

	public String toString() {
		return message;
	}
}
