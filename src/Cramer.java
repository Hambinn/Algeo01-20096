public class Cramer {
    public static float[] cramer(int m, int n, float[][] matrix) {
        int i, j; float det, detAij;
        float[] hasil = new float[m];
        float[][] temp = new float[m][m];

        for(i=0; i<m; i++){
            for(j=0; j < n-1; j++){
                temp[i][j] = matrix[i][j];
            }
        }
        det = determinan(temp, m);

        for(j=0; j<n-1; j++){
            for(i=0; i < m; i++){
                temp[i][j] = matrix[i][n-1];
            }

            detAij = determinan(temp, m);
            hasil[j] = (detAij / det);

            for(i=0; i < m; i++){
                temp[i][j] = matrix[i][j];
            }
        }
        return hasil;
    }

    public static float determinan(float[][] matrix, int m) {
        int i, rowM, colM, rowM2, colM2;
        float det;
        det = 0;
        if(m == 1){
            det = matrix[0][0];
        }else if(m == 2){
            det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }else{
            for(i=0; i < m; i++){
                float[][] M2 = new float[m-1][m-1];
                rowM2 = 0;
                colM2 = 0;
                for(rowM = 0; rowM < m; rowM++){
                    if(rowM != i){
                        colM2 = 0;
                        for(colM = 1; colM < m; colM++){
                            M2[rowM2][colM2] = matrix[rowM][colM];
                            colM2++;
                        }
                        rowM2++;
                    }
                }
                if((i+1)%2 == 1){
                    det += matrix[i][0] * determinan(M2, (m-1));
                }else{
                    det -= matrix[i][0] * determinan(M2, (m-1));
                }
            }
        }
        return det;
    }
}