package com.edu.java.misc;

import java.util.LinkedList;
import java.util.Queue;

public class NeetCode {
	
	public void solve(char[][] board) {
	       int rows = board.length;
	       int cols = board[0].length;
	       char[][] grid = copyGraph(board, rows, cols);
	       boolean[][] vis = new boolean[rows][cols];
	       Queue<int[]> queue = collectBorderO(grid, vis, rows, cols);
	       bfs(queue, grid, vis, rows, cols);
	       updateGrid(grid, vis, rows, cols);
	       System.out.println(grid);
	    }

	    private char[][] updateGrid(char[][] graph, boolean[][] vis, int rows, int cols) {
	        for(int rowIdx = 0; rowIdx < rows; rowIdx++) {
	            for(int colIdx = 0; colIdx < cols; colIdx++) {
	                if(graph[rowIdx][colIdx] == 'O' && vis[rowIdx][colIdx] == false) {
	                    graph[rowIdx][colIdx] = 'X';
	                }
	            }
	        }
	        return graph;
	    }

	    private void bfs(Queue<int[]> queue, char[][] graph, boolean[][] vis, int rows, int cols) {
	        
	        while(!queue.isEmpty()) {
	            int[] currNodeInfo = queue.poll();
	            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	            for(int[] direction : directions) {
	                int newX = direction[0] + currNodeInfo[0];
	                int newY = direction[1] + currNodeInfo[1];
	                if(newX >= 0 && newY >= 0 && newX < rows && newY < cols
	                   && vis[newX][newY] == false && graph[newX][newY] == 'O') {
	                        vis[newX][newY] = true;
	                        queue.add(new int[] {newX, newY});
	                   }
	            }
	        }
	    }

	    private Queue<int[]> collectBorderO(char[][] grid, boolean[][] vis, int rows, int cols) {

	        Queue<int[]> queue = new LinkedList<>();
	        int rs = 0; int re = rows-1;
	        int cs = 0; int ce = cols-1;

	        for(int colIdx = cs; colIdx <= ce; colIdx++) {
	            if(grid[rs][colIdx] == 'O') {
	                vis[rs][colIdx] = true;
	                queue.add(new int[] {rs, colIdx});
	            }
	        }
	        rs++;

	        for(int rowIdx = rs; rowIdx <= re; rowIdx++) {
	            if(grid[rowIdx][ce] == 'O') {
	                vis[rowIdx][ce] = true;
	                queue.add(new int[] {rowIdx, ce});
	            }
	        }
	        ce--;

	        for(int colIdx = ce; colIdx >= 0; colIdx--) {
	            if(grid[re][colIdx] == 'O') {
	                vis[re][colIdx] = true;
	                queue.add(new int[] {re, colIdx});
	            }
	        }
	        re--;

	        for(int rowIdx = re; rowIdx >= 0; rowIdx--) {
	            if(grid[rowIdx][cs] == 'O') {
	                vis[rowIdx][cs] = true;
	                queue.add(new int[] {rowIdx, cs});
	            }
	        }
	        cs++;
	        return queue;
	    }

	    private char[][] copyGraph(char[][] board, int rows, int cols) {
	        char[][] graph = new char[rows][cols];
	        for(int rowIdx = 0; rowIdx < rows; rowIdx++) {
	            for(int colIdx = 0; colIdx < cols; colIdx++) {
	                graph[rowIdx][colIdx] = board[rowIdx][colIdx];
	            }
	        }
	        return graph;
	    }

}
