package application;
import java.util.Scanner;

import entities.Matrix;
import entities.Node;
import model.PathFinder;

public class Program {
	
	 public static void main(String args[])
	    {
	        
	        Scanner sc = new Scanner(System.in);
	        
	        char[][] matrix = Matrix.createMatrix(sc);
	        boolean alive = true;
	        
	        System.out.println("\nThis is your Matrix: ");
	        Matrix.showMatrix(matrix);
	        
	        while(alive) {
		        System.out.println("\n\nWhat do you want to do?");
		        System.out.println("1 - Check shortest path between 0x0 and D\n2 - Move up\n3 - Move right\n4 - Move down\n5 - Move left");
		        char choice = sc.next().charAt(0);
		        
		        switch(choice) {
		        case '1':
		        	Node d = PathFinder.checkPath(matrix);
		        	if(d == null) {
		        		System.out.println("\nNo path found.");
		        	} else {
		        		System.out.println("\nShortest path steps: " + d.getOriginDistance());
		        		System.out.println("\nPath (inverted): \n");
		        		System.out.println(d.myParents());
		        	}
		        	break;
		        case '2':
		        	matrix = Matrix.moveAround('U', matrix);
		        	if (matrix != null) {
		        		Matrix.showMatrix(matrix);
		        	} else {
		        		alive = false;
		        	}
		        	break;
		        	
		        case '3':
		        	matrix = Matrix.moveAround('R', matrix);
		        	if (matrix != null) {
		        		Matrix.showMatrix(matrix);
		        	} else {
		        		alive = false;
		        	}
		        	break;
		        	
		        case '4':
		        	matrix = Matrix.moveAround('D', matrix);
		        	if (matrix != null) {
		        		Matrix.showMatrix(matrix);
		        	} else {
		        		alive = false;
		        	}
		        	break;
		        	
		        case '5':
		        	matrix = Matrix.moveAround('L', matrix);
		        	if (matrix != null) {
		        		Matrix.showMatrix(matrix);
		        	} else {
		        		alive = false;
		        	}
		        	break;
		        default:
		        	System.out.println("Invalid input.");
		        	break;
		        }
	        }
	        
	        sc.close();
	    }
}