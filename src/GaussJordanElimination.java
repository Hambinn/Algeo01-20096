public class GaussJordanElimination {

    static void rowOperationJordan(float[][] M, int rowN, int colN, int bp){
        float K;
        int barisPengurang = bp;
        K = M[rowN][colN] / M[bp][colN];
        M[rowN][colN] = 0;

        for (int c = colN + 1; c < M[0].length; c++){
            
            M[rowN][c] -=  (float)(K * M[barisPengurang][c]);
        }
    }

    static boolean isNotZero(float[][] M, int row, int col){
        return (M[row][col] != 0);
    }

    static float[][] gaussJordanElimination(float[][] M){
        M = GaussElimination.gaussElimination(M);
        int d = 1; int k = d;

        while((d < M.length) && (d < M[0].length)){
            boolean active = true;
            while ((k < M[0].length) && (active)){
                if ((M[d][k] == 1)){
                    if (M[d-1][k] != 0){
                        for (int r = 0; r < d; r++){
                            if (isNotZero(M, r, k)){
                                rowOperationJordan(M, r, k, d);
                            }
                        }  
                        active = false;
                    }
                    active = false;
                }
                else{
                    k += 1;
                }
            }
            d += 1;
        }
        return M;
    }
}
