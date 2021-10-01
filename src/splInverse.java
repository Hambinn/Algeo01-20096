public class splInverse {
    public static float[][] splInverse(float matriks[][]) {
        if(matriks.length-1!=matriks.length+1){
            return matriks;
        }else{
            float matrixVar[][] = new float[matriks.length-1][matriks.length-1-1];
            float matrixRes[][] = new float[matriks.length-1][1];
            float matrixKali[][] = new float[matriks.length-1][1];
            for(int i = 0;i<matriks.length;i++){
                for(int j = 0;j<matriks.length-1;j++){
                    matrixVar[i][j] = matriks[i][j];
                }
            }
            
            for(int i = 0;i<matriks.length;i++){
                matrixRes[i][0] = matriks[i][matriks.length-1-1];
            }

            for(int i = 0;i<matriks.length;i++){
                for(int j = 0;j<1;j++){
                    float elm = 0;
                    for(int k = 0;k<matriks.length-1;k++){
                        elm +=  matrixRes[k][j] * inverse(matrixVar, matriks.length-1, matriks.length-1)[i][k];
                    }
                    matrixKali[i][j] = elm;
                }
            }
            return matrixKali;
            
        }
    }

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
    
}
