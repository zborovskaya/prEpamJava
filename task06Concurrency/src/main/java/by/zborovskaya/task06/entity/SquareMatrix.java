package by.zborovskaya.task06.entity;

public class SquareMatrix extends Matrix{
    public SquareMatrix(int[][] a){
        super(a);
    }

    public SquareMatrix(int n){
        super(n,n);
    }

    public int getSize(){ return super.getHorizontalSize();}

}
