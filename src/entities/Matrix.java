package entities;

import java.util.Scanner;

public final class Matrix {
		
	private Matrix() {
		
	}

	public static char[][] createMatrix(Scanner sc) {

		System.out.println("Enter the number of rows in your matrix");
		int row = sc.nextInt();

		System.out.println("Enter the number of columns in your matrix");
		int col = sc.nextInt();

		char[][] matrix = new char[row][col];

		if (row == 1 && col == 1) {
			System.out.println("\nYour robot cannot go nowhere!");
		} else {
			System.out.println("\nThe first position of your matrix (0x0) is where your robot is going to be."
					+ "\nEnter Matrix Data, one by one (0 for holes, 1 for paths and D for destination)\n");

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.println(i + "x" + j + ":");
					matrix[i][j] = sc.next().charAt(0);
				}
			}
		}

		matrix[0][0] = 'R';

		return matrix;

	}

	public static void showMatrix(char[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	public static char[][] moveAround(char direction, char[][] matrix) {
		int[] position = findPosition(matrix);
		
		int row = position[0];
		int col = position[1];


		switch(direction) {
		case 'R':
			if (col + 1 >= matrix[row].length) {
				System.out.println("You cannot get out of the board.");
				break;
			} else if (matrix[row][col + 1] == 'D'){
				System.out.println("Found your destination!");
				return null;
			} else if ((col + 1 < matrix[row].length) && matrix[row][col + 1] != '0') {
				matrix[row][col + 1] = 'R';
				matrix[row][col] = '1';
				break;
			} else {
				System.out.println("Whoops, your robot has fallen in a hole!");
				return null;
			}
			
		case 'L':
			if (col - 1 < 0) {
				System.out.println("You cannot get out of the board.");
				break;
			} else if (matrix[row][col - 1] == 'D'){
				System.out.println("Found your destination!");
				return null;
			} else if ((col - 1 >= 0) && matrix[row][col - 1] != '0') {
				matrix[row][col - 1] = 'R';
				matrix[row][col] = '1';
				break;
			} else {
				System.out.println("Whoops, your robot has fallen from the board!");
				return null;
			}
		case 'U':
			if (row - 1 < 0) {
				System.out.println("You cannot get out of the board.");
				break;
			} else if (matrix[row - 1][col] == 'D'){
				System.out.println("Found your destination!");
				return null;
			} else if ((row - 1 >= 0) && matrix[row - 1][col] != '0') {
				matrix[row - 1][col] = 'R';
				matrix[row][col] = '1';
				break;
			} else {
				System.out.println("Whoops, your robot has fallen from the board!");
				return null;
			}
			
		case 'D':
			if (row + 1 >= matrix.length) {
				System.out.println("You cannot get out of the board.");
				break;
			} else if (matrix[row + 1][col] == 'D'){
				System.out.println("Found your destination!");
				return null;
			} if ((row + 1 < matrix.length) && matrix[row + 1][col] != '0') {
				matrix[row + 1][col] = 'R';
				matrix[row][col] = '1';
				break;
			} else {
				System.out.println("Whoops, your robot has fallen from the board!");
				return null;
			}
		
		}
		return matrix;
	}

	public static int[] findPosition(char[][] matrix) {
		int[] position = new int[2];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'R') {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		System.out.println("Position not found");
		return null;
	}

}
