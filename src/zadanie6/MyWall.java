package zadanie6;

public class MyWall {
	public static boolean myWall(int small, int big, int length) {
		int lengthBig = 0, lengthSmall = 0;
		for (int i = 1; i <= big; i++) {
			lengthBig += 5;
			if(lengthBig == length) {
				return true;
			}
			if (lengthBig > length) {
				lengthBig = 5 * (i - 1);
				break;
			}
		} 
		for (int i = 1; i <= small; i++) {
			lengthSmall++;
			if (lengthSmall == length - lengthBig) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(myWall(1, 5, 21));
	}
}
