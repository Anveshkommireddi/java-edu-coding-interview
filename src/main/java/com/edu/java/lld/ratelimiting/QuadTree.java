package com.edu.java.lld.ratelimiting;

class QuadTreeNode {
	boolean isLeaf;
	int value;
	QuadTreeNode topLeft, topRight, bottomLeft, bottomRight;

	// Constructor for a leaf node
	public QuadTreeNode(int value) {
		this.isLeaf = true;
		this.value = value;
		this.topLeft = this.topRight = this.bottomLeft = this.bottomRight = null;
	}

	// Constructor for an internal node
	public QuadTreeNode(QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft,
			QuadTreeNode bottomRight) {
		this.isLeaf = false;
		this.value = -1; // Internal nodes don't hold a specific value
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
}

public class QuadTree {

	// Function to build the quadtree from the matrix
	public QuadTreeNode buildQuadTree(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
		// Check if all values in the current region are the same
		if (isHomogeneous(matrix, rowStart, rowEnd, colStart, colEnd)) {
			return new QuadTreeNode(matrix[rowStart][colStart]);
		}

		// If not homogeneous, divide the matrix into 4 quadrants
		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;

		QuadTreeNode topLeft = buildQuadTree(matrix, rowStart, rowMid, colStart, colMid);
		QuadTreeNode topRight = buildQuadTree(matrix, rowStart, rowMid, colMid + 1, colEnd);
		QuadTreeNode bottomLeft = buildQuadTree(matrix, rowMid + 1, rowEnd, colStart, colMid);
		QuadTreeNode bottomRight = buildQuadTree(matrix, rowMid + 1, rowEnd, colMid + 1, colEnd);

		// Create an internal node
		return new QuadTreeNode(topLeft, topRight, bottomLeft, bottomRight);
	}

	// Helper function to check if a region in the matrix is homogeneous
	private boolean isHomogeneous(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
		int value = matrix[rowStart][colStart];
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				if (matrix[i][j] != value) {
					return false;
				}
			}
		}
		return true;
	}

	// Function to print the Quadtree (for testing)
	public void printQuadTree(QuadTreeNode node) {
		if (node == null)
			return;

		if (node.isLeaf) {
			System.out.println("Leaf node with value: " + node.value);
		} else {
			System.out.println("Internal node");
			System.out.println("Top left:");
			printQuadTree(node.topLeft);
			System.out.println("Top right:");
			printQuadTree(node.topRight);
			System.out.println("Bottom left:");
			printQuadTree(node.bottomLeft);
			System.out.println("Bottom right:");
			printQuadTree(node.bottomRight);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } };

		QuadTree quadTree = new QuadTree();
		QuadTreeNode root = quadTree.buildQuadTree(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);

		// Print the Quadtree
		quadTree.printQuadTree(root);
	}
}
