import java.util.Scanner;


public class Arrow {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int arrowWidth = Integer.parseInt(input.nextLine());
		int wholeWidth = (2 * arrowWidth) - 1;
		int arrowHeight = wholeWidth;
		
		//Version 1.0
		
//		int numberOfDots = arrowWidth / 2;
//		String dots = new String(new char[numberOfDots]).replace("\0", ".");
//		String arrowTop = new String(new char[arrowWidth]).replace("\0", "#");
//		
//		System.out.print(dots);
//		System.out.print(arrowTop);
//		System.out.println(dots);
//		
//		for (int row = 0; row < arrowWidth - 2; row++) {
//			System.out.print(dots);
//			System.out.print("#");
//			System.out.print(new String(new char[arrowWidth - 2])
//						.replace("\0", "."));
//			System.out.print("#");
//			System.out.println(dots);
//		}
//		
//		System.out.print(new String(new char[arrowWidth / 2 + 1])
//					.replace("\0", "#"));
//		System.out.print(new String(new char[arrowWidth - 2])
//					.replace("\0", "."));
//		System.out.println(new String(new char[arrowWidth / 2 + 1])
//					.replace("\0", "#"));
//		
//		int outterDots = 1;
//		int innerDots = wholeWidth - 4;
//		
//		for (int i = 0; i < arrowWidth - 2; i++) {
//			System.out.print(new String(new char[outterDots])
//					.replace("\0", "."));
//			System.out.print("#");
//			System.out.print(new String(new char[innerDots])
//					.replace("\0", "."));
//			System.out.print("#");
//			System.out.println(new String(new char[outterDots])
//			.replace("\0", "."));
//			
//			outterDots++;
//			innerDots -= 2;
//		}
//		
//		System.out.print(new String(new char[outterDots])
//		.replace("\0", "."));
//		System.out.print("#");
//		System.out.println(new String(new char[outterDots])
//		.replace("\0", "."));
		
		
		//Version 2.0
		int[][] arrow = new int[arrowHeight][wholeWidth];
		int currentRow = 0;
		int currentCol = wholeWidth / 2;
		
		while (currentRow < arrowHeight) {
			if (currentRow == 0) {
				for (int col = 0; col < arrowWidth / 2 + 1; col++) {
					arrow[currentRow][currentCol + col] = 1;
					arrow[currentRow][currentCol - col] = 1;
				}

				currentCol = arrowWidth / 2;
			}
			
			if (currentRow > 0 && currentRow < arrowWidth - 1) {
				arrow[currentRow][currentCol] = 1;
				arrow[currentRow][wholeWidth - currentCol - 1] = 1;
			}
			
			if (currentRow == arrowWidth - 1) {
				for (int col = 0; col < arrowWidth / 2 + 1; col++) {
					arrow[currentRow][currentCol - col] = 1;
					arrow[currentRow][wholeWidth - currentCol - 1 + col] = 1;
				}

				currentCol = 0;
			}
						
			if (currentRow >= arrowWidth - 1) {
				arrow[currentRow][currentCol] = 1;
				arrow[currentRow][wholeWidth - 1 - currentCol] = 1;
				
				currentCol++;
			}
			
			currentRow++;
		}
		
		for (int row = 0; row < arrowHeight; row++) {
			for (int col = 0; col < wholeWidth; col++) {
				if (arrow[row][col] == 0) {
					System.out.print(".");
				} else if(arrow[row][col] == 1) {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}

}
