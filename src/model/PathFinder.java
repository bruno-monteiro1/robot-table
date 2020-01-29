package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.Matrix;
import entities.Node;

public final class PathFinder {
	
	private PathFinder() {
		
	}
	
	public static Node checkPath(char[][] matrix) {
		
		char [][] matrixClone = new char[matrix.length][];
		for(int i = 0; i < matrix.length; i++)
		{
		  char[] aMatrix = matrix[i];
		  int aLength = aMatrix.length;
		  matrixClone[i] = new char[aLength];
		  System.arraycopy(aMatrix, 0, matrixClone[i], 0, aLength);
		}
		
		int[] position = Matrix.findPosition(matrixClone);
		
		Node source = new Node(position[0], position[1], 0);
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(source);
		
		
		while(!queue.isEmpty()) {
			Node popped = queue.poll();
			
			if(matrixClone[popped.getX()][popped.getY()] == 'D' ) {
				return popped;
			}
			else {
				matrixClone[popped.getX()][popped.getY()]='0';
				
				List<Node> neighbours = adjacents(popped, matrixClone);
								
				queue.addAll(neighbours);
			}	
			
		}
		return null;
	}

	private static List<Node> adjacents(Node popped, char[][] matrixClone) {
		
		List<Node> list = new LinkedList<Node>();
		
		int x = popped.getX();
		int y = popped.getY();
		
		if((x-1 >= 0 && x-1 < matrixClone.length) && matrixClone[x-1][y] != '0') {
			list.add(new Node(x-1, y, popped.getOriginDistance()+1, popped));
		}
		if((x+1 >= 0 && x+1 < matrixClone.length) && matrixClone[x+1][y] != '0') {
			list.add(new Node(x+1, y, popped.getOriginDistance()+1, popped));
		}
		if((y-1 >= 0 && y-1 < matrixClone[x].length) && matrixClone[x][y-1] != '0') {
			list.add(new Node(x, y-1, popped.getOriginDistance()+1, popped));
		}
		if((y+1 >= 0 && y+1 < matrixClone[x].length) && matrixClone[x][y+1] != '0') {
			list.add(new Node(x, y+1, popped.getOriginDistance()+1, popped));
		}		
		return list;
	}
	
}
