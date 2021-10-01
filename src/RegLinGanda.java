public class RegLinGanda {
    public static float[] reglinganda (float[][] matrixInput, int m, int n) {
        //m banyak data, n jumlah variabel bebas
        float A[][] = new float[n+1][n+2];
        float hasil[] = new float[n+1];
        int i, j;
        i = 0; j = 0;
        for(i=1; i < n+1; i++){
            A[i][0] = sumData(matrixInput, i, m);
        }
        for(j=1; j < n+1; j++){
            A[0][j] = sumData(matrixInput, j, m);
        }

        for(i=0; i<(n+1); i++){
            for(j=0; j<(n+2); j++){
                if(i==0 && j==0){
                    A[i][j] = m;
                }else if(i==j && i !=0){
                    A[i][j] = sumPower(matrixInput, j, m);
                }else if(j==n+1){
                    if(i==0){
                        A[0][j] = sumData(matrixInput, 0, m);
                    }else{
                        A[i][j] = sumMultiply(matrixInput, 0, i, m);
                    }
                }else if(i != 0 && j != 0){
                    A[i][j] = sumMultiply(matrixInput, i, j, m);
                }
            }
        }
        hasil = Cramer.cramer(n+1, n+2, A);
        return hasil;
    }

    public static float sumPower(float matrix[][], int colPow, int row){
        int i;
        float sum;
        sum=0; i=0;
        for(i=0; i<row; i++){
            sum = sum + (matrix[i][colPow] * matrix[i][colPow]);
        }
        return sum;
    }

    public static float sumMultiply(float matrix[][], int colMul1, int colMul2, int row){
        int i;
        float sum;
        sum=0; i=0;
        for(i=0; i<row; i++){
            sum = sum + (matrix[i][colMul1] * matrix[i][colMul2]);
        }
        return sum;
    }
    
    public static float sumData(float matrix[][], int colSum, int row){
        int i;
        float sum;
        sum=0; i=0;
        for(i=0; i<row; i++){
            sum = sum + matrix[i][colSum];
        }
        return sum;
    }
}
