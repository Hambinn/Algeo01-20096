//import jdk.internal.jimage.decompressor.ZipDecompressorFactory;

public class Inverse {
    public static float[][] inverseAdj(float matrix[][],int row, int col) {
        //Invers Adjoin
        float matrixCadang[][] = new float[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                matrixCadang[i][j] = matrix[i][j];
            }
        }
        if(isSquare(row, col) && KofaktorDeterminan.determinant(matrix, row) != 0){
            float matrixID[][] = new float[row][col];
            for(int a =0;a<row;a++){
                for(int b = 0; b<col;b++){
                    if(a==b){
                        matrixID[a][b] = 1.0F;
                    }
                    else{
                        matrixID[a][b] = 0.0F;
                    }
                }
            }
            
            for(int i = row-1;i>0;i--){
                if(matrix[i-1][0] < matrix[i][0]){
                    for(int j = 0;j<row;j++){
                        float tempUtama = matrix[i][j];
                        float tempID = matrixID[i][j];
                        matrix[i][j] = matrix[i-1][j];
                        matrix[i-1][j] = tempUtama;
                        matrixID[i][j] = matrixID[i-1][j];
                        matrixID[i-1][j] = tempID;
                    }
                }
                
            }

            for(int i = 0;i<row;i++){
                for(int j = 0; j<row;j++){
                    if(j!=i){
                        float tempUtama = matrix[j][i] / matrix[i][i];
                        float tempID = matrixID[j][i] / matrix[i][i];
                        for(int k = 0;k<row;k++){
                            matrix[j][k] -= matrix[i][k] * tempUtama;
                            matrixID[j][k] -= matrixID[i][k] * tempUtama;
                            
                        }
                    }
                }
            }

            for(int i = 0;i<row;i++){
                float tempUtama = matrix[i][i];
                for(int j = 0; j<row;j++){
                    matrix[i][j] = matrix[i][j]/tempUtama;
                    matrixID[i][j] = matrixID[i][j]/tempUtama;
                }
            }
            for(int i = 0;i<row;i++){
                for(int j = 0;j<col;j++){
                    matrix[i][j] = matrixCadang[i][j];
                }
            }
            return(matrixID);
            
        }else{
            return(matrix);
        }
    }
    
    public static boolean isSquare(int a, int b) {

        return(a == b);
    }

    

    public static boolean isDetermminant(float matrix[][], int row) {
        int i = matrix.length - row;
        int j = matrix.length - row;
        while (matrix[i][j] == 0 && i < row-1 ){
            i++;
        }

        if(matrix[i][j] == 0 && i == row-1){
            return false;
        }else if(row == 1){
            if (matrix[matrix.length-row][matrix.length-row] == 0){
                return false;
            }else{
                return true;
            }
        }
        else{
            Float temp;
            Float tmp = matrix[matrix.length-row][matrix.length-row];
            for(int c = matrix.length-row;c<matrix.length;c++){
                temp = matrix[matrix.length-row][c];
                matrix[matrix.length-row][c] = matrix[i][c];
                matrix[i][c] = temp;
                matrix[matrix.length-row][c] = matrix[matrix.length-row][c] / tmp;

            }

            for(int a = matrix.length-row+1; a<matrix.length;a++){
                float tempp = matrix[a][matrix.length-row];
                for(int b = matrix.length-row; b<matrix.length;b++){
                    matrix[a][b] = matrix[a][b] - (tempp * matrix[matrix.length-row][b]);
                }
            }
            
            return (isDetermminant(matrix, row-1));
        }
    }
    
    public static float[][] inverseOBE(float[][] matrix){
        // Invers OBE
        float matrixProcess[][] = new float[matrix.length][2 * matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = matrix.length; j < 2 * matrix.length; j++){
                if (j - i == matrix.length){
                    matrixProcess[i][j] = 1;
                }
                else{
                    matrixProcess[i][j] = 0;
                }
            }
        }

        invMatrix(matrix, matrixProcess);

        if(hasInverse(matrixProcess)){
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix.length; j++){
                    matrix[i][j] = matrixProcess[i][j + matrixProcess.length];
                }
            }
            return matrix;
        }
        else{
            /* Mengembalikan matriks yang sama dengan input.
            Apabila di luar terdeteksi matriks input sama dengan output,
            maka akan mengeluarkan pesan tidak memiliki invers*/
            return matrix;
        }
    }    

    public static void invMatrix(float[][] mPar, float[][] mRes){
        for (int i = 0; i < mPar.length; i++){
            for (int j = 0; j < mPar.length; j++){
                mRes[i][j] = mPar[i][j];
            }
        }

        mRes = GaussJordanElimination.gaussJordanElimination(mRes);
    }

    public static boolean hasInverse(float[][] matrix){
        // Memiliki invers jika tidak ada baris di 3 baris dan kolom pertama yang semua valuenya 0
        boolean flag = true;
        int zeroCount = 0;
        for (int i = 0; i < matrix.length; i++){
            zeroCount = 0;
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == 0){
                    zeroCount += 1;
                }
            }
        }
        if (zeroCount == matrix.length){
            flag = false;
        }
        return flag;
    }
}
