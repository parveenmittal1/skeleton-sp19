package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean [][] grid;
    private int numberOpen;
    public Percolation(int n) {
        if(n<0)
            throw new java.lang.IllegalArgumentException();
        grid=new boolean[n][];
        for(int i=0;i<n;i++){
            grid[i]=new boolean[n];
        }
        numberOpen=0;
    }

    public void open(int row,int col){
        if(row<0||row>=grid.length||col<0||col>=grid.length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        grid[row][col]=true;
        numberOpen++;
    }


    public boolean isOpen(int row,int col){
        if(row<0||row>grid.length||col<0||col>grid.length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return grid[row][col]==true;
    }

    public boolean isFull(int row,int col){
        if(row<0||row>grid.length||col<0||col>grid.length){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return false;
    }

    public int numberOpenSites(){
        return numberOpen;
    }

    public boolean perpcolates(){
        return false;
    }

    public static void main(String [] args){
        System.out.println("hello");
    }


}
