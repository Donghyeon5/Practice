package java_study.chapter04;

public class PraticeEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				for (int k = 1; k < 4; k++) {
					System.out.printf("%d%d%d%n", i, j, k);
				}
			}
		}
		System.out.println("---------------------------------------------------");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.printf("(%d,%d)", i, j);

			}
			System.out.println();
		}

		System.out.println("---------------------------------------------------");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (i == j) {
					System.out.printf("(%d,%d)", i, j);
				} else {
					System.out.printf("%5c", ' '); // 공백 %5c , ' '
				}

			}
			System.out.println();
		}
	}

}
