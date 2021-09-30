import java.util.Scanner;
public class regGanda {
    public static void regganda(){
        System.out.print("Masukkan banyak variabel : ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.print("Masukkan banyak data : ");
        int m = input.nextInt();
        
        float matrixInput[][] = new float[m][n+1];

        BacaMatrix(matrixInput, m, n);

        float A[][] = new float[n+1][n+1];
        float b[] = new float[n+1];
        float H[] = new float[n+1];

    }



    public static void  BacaMatrix(float matrix[][],int row, int col){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                matrix[i][j] = in.nextFloat();
            }
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

}