public class KofaktorDeterminan {
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
