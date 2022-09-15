package Algorithm.Trying;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 행렬_곱셈_순서 {
    static class Matrix{ int row; int col; Matrix(int row,int col) {this.col = col; this.row = row;} }
    static int memo[][][];
    static int multi(Matrix a,Matrix b) {return a.row * a.col * b.col;}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[501][501][501];
    }
}
