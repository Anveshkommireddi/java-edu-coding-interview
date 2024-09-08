package com.edu.java.custom.datastructures;

public class InsertDeleteGetRandomnTest {
	
	 public static void main (String args[]){
	        char[][] commands = {{'I', 'G', 'I', 'I', 'R', 'G'},
	                {'I', 'I', 'R', 'G', 'R', 'I'}};
	        int[][] values = {{10, -1, 100, 1000, 200, -1}, {30, 60, 10, -1, 30, 90}};

	        for(int i=0;i<commands.length;i++)
	        {
	        	InsertDeleteGetRandomn dataset = new InsertDeleteGetRandomn();
	            System.out.println((i+1)+ ". Starting operations:");
	            for(int j=0;j<commands[i].length;j++){
	                if (commands[i][j] == 'I'){
	                    System.out.println("\tInsert ("+ values[i][j]+ ") returns "+ dataset.insert(values[i][j]));
	                }
	                else if (commands[i][j] == 'R'){
	                    System.out.println("\tDelete ("+ values[i][j]+ ") returns "+ dataset.delete(values[i][j]));
	                }
	                else if (commands[i][j] == 'G'){
	                    System.out.println("\tGenerate Random() returns "+ dataset.getRandomData());
	                }
	                else {
	                    
	                }
	            }

	            System.out.println(new String(new char[100]).replace('\0', '-'));
	        }
	    }

}
