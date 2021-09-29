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
        // 1 , x, x**2, y
        // 1 , x, x**2, y
        // 1 , x, x**2, y
        // 1 , x, x**2, y
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
