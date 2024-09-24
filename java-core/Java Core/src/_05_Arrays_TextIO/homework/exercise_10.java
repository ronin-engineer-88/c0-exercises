package _05_Arrays_TextIO.homework;

import java.util.Scanner;

public class exercise_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so lan test: "); int t = scanner.nextInt();

        for(int i = 0; i < t; i++){
            System.out.print("Nhap bac cua ma tran: ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] a = new int[n][m];
            for(int j = 0; j < n; j++){
                System.out.print("Nhap cac phan tu cho hang " + (i+1) + " cua ma tran: ");
                for(int k = 0; k < m; k++){
                    a[j][k] = scanner.nextInt();
                }
            }

            System.out.println("Test " + (i+1) + ": ");
            int[][] result = productWithItTranspose(a);
            for(int j = 0; j < result.length; j++){
                for(int k = 0; k < result[0].length; k++){
                    System.out.print(result[j][k] + " ");
                }
                System.out.println();
            }

        }
    }

    private static int[][] productWithItTranspose(int[][] a) {
        int[][] aT = transposeMatrix(a);
        int order = a.length;
        int[][] result = new int[order][order];

        for(int i = 0; i < order; i++){
            for(int j = 0; j < order; j++){
                result[i][j] = 0;
            }
        }

        for(int i = 0; i < order; i++){
            for(int j = 0; j < order; j++){
                for(int k = 0; k < aT[0].length; k++){
                    result[i][j] += a[i][k] * aT[k][j];
                }
            }
        }

        return result;
    }

    private static int[][] transposeMatrix(int[][] a) {
        int row = a[0].length;
        int column = a.length;
        int[][] aT = new int[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                aT[i][j] = a[j][i];
            }
        }

        return aT;
    }
}
