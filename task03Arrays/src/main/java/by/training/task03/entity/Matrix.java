package by.training.task03.entity;

import by.training.task03.service.exception.MatrixException;

public class Matrix {

    private int[][] a;
    public Matrix(int[][] a) {
        this.a = a;
    }
    public Matrix(int m, int n)  {  a = new int[m][n];}
    public int getVerticalSize() {
        return a.length;
    }
    public int getHorizontalSize() {
        return a[0].length;
    }
    public int getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // check i & j
            return a[i][j];
        } else {
            throw new MatrixException();
        }
    }
    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            a[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for(int j=0; j<h; j++)
            {
                try {
                    if (matrix.getElement(i,j) != a[i][j]) {
                        return false;
                    }
                }
                catch (MatrixException e){

                }
            }

        }
        return true;
    }
    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x"
                + a[0].length + "\n");
        for (int [ ] row : a) {
            for (int value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
    private boolean checkRange(int i, int j) {// check matrix range
        return (i >= 0 && i < a.length && j >= 0 && j < a[0].length);
    }
}

