import java.util.Scanner;
public class Interpolasi {
    public static void main(String[] args) {
        interpolasi();
    }
    public static void interpolasi() {
        //minta n
        System.out.print("Masukkan Jumlah titik : ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        float matrixInput[][] = new float[n][2];
        // x, y
        // x, y
        // x, y
        BacaMatrix(matrixInput, n, 2);
    
        float matrixHasil[][] = new float[n][n+1];
        for(int i = 0;i < matrixHasil.length; i++){
            for(int j = 0; j < matrixHasil[0].length; j++){
                if(j == 0){
                    matrixHasil[i][j] = 1;
                }
                if(j == 1){
                    matrixHasil[i][j] = matrixInput[i][0];
                }
                if(j == matrixHasil[0].length-1){
                    matrixHasil[i][j] = matrixInput[i][1];
                }
                else{
                    matrixHasil[i][j] = power(matrixInput[i][0], j);
                }
            }
        }
        matrixHasil = GaussElimination.gaussElimination(matrixHasil);
        printMatrix(matrixHasil, matrixHasil.length, matrixHasil[0].length);

        //idx0 1  3/2  -1/2  5/2    
        //idx1 0   1    1/2  7/2
        //idx2 0   0     1    3
        matrixHasil[matrixHasil.length-1][matrixHasil[0].length - 2] *= matrixHasil[matrixHasil.length-1][matrixHasil[0].length - 1];
         //idx0 1  3/2  -1/2  5/2    
        //idx1 0   1    1/2  7/2
        //idx2 0   0     3    3
        for(int i = matrixHasil.length - 1; i > 0; i--){
            rowMultiple(matrixHasil, i, i, i);
            //idx0 1  3/2  -3/2  5/2    
            //idx1 0   1    3/2  7/2
            //idx2 0   0     3    3
            int j = matrixHasil[0].length - 1;
            matrixHasil[i-1][i-1] = minusRecursive(matrixHasil, i - 1, j);
            System.out.printf("NILAI DIAGONAL UTAMA : \n" + matrixHasil[i-1][i-1]);
            //idx0 1   3   -3/2  5/2    
            //idx1 0   2    3/2  7/2
            //idx2 0   0     3    3

            //idx0 4   3   -3/2  5/2    
            //idx1 0   2    3/2  7/2
            //idx2 0   0     3    3
        }
        System.out.print("========================================\n");
        printMatrix(matrixHasil, matrixHasil.length, matrixHasil[0].length);
    }

    public static float[][] rowMultiple (float[][] matrix, int row, int col, int batas){
        for(int i = matrix.length - batas; i > 0; i--){
            matrix[i-1][col] *= matrix[row][col];
        }
        return matrix;
    }

    public static float minusRecursive (float[][] matrix, int row, int col){
        System.out.print("========================================\n");
        printMatrix(matrix, matrix.length, matrix[0].length);
        
        System.out.print("========================================\n");
        
        if ((row == col) && (matrix[row][col] == 1)){
            return 0;
        }
        else{
            return matrix[row][col] - minusRecursive(matrix, row, col - 1);
        }
    }

    public static float power(float elMat, int ex){
        float result = 1;
        while (ex != 0){
            result *= elMat;
            ex -= 1;
        }
        return result;
    }

    public static void  BacaMatrix(float matrix[][],int row, int col){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                matrix[i][j] = in.nextFloat();
            }
        }
    }

    public static void printMatrix(float matrix[][],int row, int col) {
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                System.out.print(String.format("%10.2f", matrix[i][j]));
            }
            System.out.println();
        }
    }
}