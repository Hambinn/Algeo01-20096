import java.util.Scanner;
public class Interpolasi {
    public static void interpolasi() {
        Main.displayPilihanInput();
        Scanner input = new Scanner(System.in);
        int inputMethod = input.nextInt();
        if (inputMethod == 1){
            float matrixInput[][] = Main.bacaUkuranMatriks(false);
            System.out.println("Masukkan koefisien a[i][j] untuk matriks : ");
            readMatrix(matrixInput, matrixInput.length, 2);

            float matrixResult[][] = prosesInterpolasi(matrixInput, matrixInput.length);
            System.out.println("\nSolusi dari sistem persamaan yang dimasukkan:");
            
            for (int i = 0; i < matrixResult.length; i++){
                for (int j = 0; j < matrixResult.length; j++){
                    if(i == j){
                        System.out.println("x" + i + " = " + matrixResult[i][i]);

                    }
                }
            }
        }
        else if (inputMethod == 2){
            float matrixInput[][] = FileProcess.fileProcessing();
            float matrixResult[][] = prosesInterpolasi(matrixInput, matrixInput.length);
            
            System.out.println("\nSolusi dari sistem persamaan yang dimasukkan:");
            for (int i = 0; i < matrixResult.length; i++){
                for (int j = 0; j < matrixResult.length; j++){
                    System.out.println("x" + i + " = " + matrixResult[i][i]);
                }
            }
        }
    }

    public static float[][] rowMultiple (float[][] matrix, int row, int col, int batas){
        for(int i = matrix.length - 1 - batas; i > 0; i--){
            matrix[i-1][col] *= matrix[row][col];
        }
        return matrix;
    }

    public static float minusRecursive (float[][] matrix, int row, int col){
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

    public static void  readMatrix(float matrix[][],int row, int col){
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

    public static float[][] prosesInterpolasi(float matrixInput[][],int n) {
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
        matrixHasil[matrixHasil.length-1][matrixHasil[0].length - 2] *= matrixHasil[matrixHasil.length-1][matrixHasil[0].length - 1];

        int batas = 0;
        for(int i = matrixHasil.length - 1; i > 0; i--){
            rowMultiple(matrixHasil, i, i, batas);
            int j = matrixHasil[0].length - 1;
            matrixHasil[i-1][i-1] = minusRecursive(matrixHasil, i - 1, j);
            batas += 1;
        }
        printMatrix(matrixHasil, matrixHasil.length, matrixHasil[0].length);
        return matrixHasil;
    }

}