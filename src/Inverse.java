public class Inverse {
    public static float[][] inverse(float matrix[][],int row, int col) {
        float matrixCadang[][] = new float[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                matrixCadang[i][j] = matrix[i][j];
            }
        }
        if(isSquare(row, col) && determinant(matrix, row) != 0){
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

    public static float determinant(float matrix[][], int row) {
        float det=0;
        if(row == 1){
            return matrix[0][0];
        }
        float tmp[][] = new float[row][row];
        int mult = 1;
        for(int f = 0;f<row;f++){
            kofaktor(matrix, tmp, 0, f, row);
            det += mult * matrix[0][f] * determinant(tmp,row-1);
            mult = -mult;
        }

        return det;
    }

    public static void kofaktor(float matrix[][], float tmp[][],int p, int q,int row) {
        int a=0;
        int b=0;

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                if(i != p && j!= q){
                    tmp[a][b++] = matrix[i][j];
                    if (b == matrix.length-1){
                        b = 0;
                        a++;
                    }
                }
            }
        }
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
    
    public static void inverseOBE(float[][] matrix){
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
        for(int i = 0;i < matrixProcess.length; i++){
            for(int j = 0; j < matrixProcess[0].length;j++){
                System.out.print(String.format("%5.2f", matrixProcess[i][j]));
            }
            System.out.println();
        }
    }    

    public static void invMatrix(float[][] mPar, float[][] mRes){
        for (int i = 0; i < mPar.length; i++){
            for (int j = 0; j < mPar.length; j++){
                mRes[i][j] = mPar[i][j];
            }
        }
    }

    public static void main(String[] args){
        float m[][] = { {1, 2, 3}, 
                        {5, 6, 7},
                        {3, 7, 2} };
        inverseOBE(m);
    }
}
