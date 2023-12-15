package org.tshak.solutions.leetcode;

public class SpiralMatrix885 {
    public static void main(String[] args) {
        SpiralMatrix885 m= new SpiralMatrix885();
        m.spiralMatrixIII(1, 4, 0, 0);
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int rowStart = rStart, rowEnd = rowStart + 1, colStart = cStart - 1, colEnd = cStart + 1;
        int[][] result = new int[rows * cols][2];
        int resultIndex = 0;
        int count = 1;
        while(count < rows * cols) {
            //current row
            for(int col = colStart + 1; col >= 0 && col < cols && col<=colEnd; col++) {
                int[] coordinates = new int[2];
                coordinates[0]=rowStart;
                coordinates[1] = col;
                result[resultIndex++] = coordinates;
                count++;
            }
            //right col
            for(int row = rowStart + 1; row >= 0 && row < rows && row<=rowEnd; row++) {
                int[] coordinates = new int[2];
                coordinates[0]=row;
                coordinates[1] = colEnd;
                result[resultIndex++] = coordinates;
                count++;
            }
            int prevRightCol = colEnd;
            colEnd++;
            //bottom row
            colStart--;
            for(int col = prevRightCol - 1; col >=0 && col < cols && col>=colStart; col--) {
                int[] coordinates = new int[2];
                coordinates[0]=rowEnd;
                coordinates[1] = col;
                result[resultIndex++] = coordinates;
                count++;
            }
            int prevRowEnd = rowEnd;
            rowEnd++;
            //right col
            rowStart--;
            for(int row = prevRowEnd - 1; row >=0 && row < rows && row>=rowStart; row--) {
                int[] coordinates = new int[2];
                coordinates[0]=row;
                coordinates[1] = colStart;
                result[resultIndex++] = coordinates;
                count++;
                count++;
            }

        }
        return result;
    }
}
