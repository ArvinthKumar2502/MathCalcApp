package com.example.mathcalculator;

public class multiply {
    int[][] matrixMultiply(int row1,int col1,int[][] mat,int row2,int col2,int[][] mat2)
    {
        int c[][] = new int[100][100];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col2; j++){
                c[i][j]=0;
                for(int k = 0; k < row2; k++){
                    c[i][j] += mat[i][k]*mat2[k][j];
                    System.out.println(c[i][j] +"  == "+mat[i][k]+" * "+mat2[k][j]);
                }
            }
        }
        return c;
    }
}
