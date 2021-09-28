public class GaussElimination {

    static void mainCoefTo1(float[][] M, int i, int j){
        float pengali;

        if (M[i][j] == 0){
            pengali = 0;
        }
        else{
            pengali = (float)1 / M[i][j];
            M[i][j] = M[i][j] * pengali;
        }

        if (i != M[0].length - 1){
            for (int iR = j + 1; iR < M[0].length; iR++){
                M[i][iR] = M[i][iR] * pengali;
            }
        }
    }

    static void rowOperation(float[][] M, int rowN, int colN, int bp){
        float K;
        int barisPengurang = bp;
        K = M[rowN][colN] / M[bp][colN];
        M[rowN][bp] = 0;
        for (int c = bp + 1; c < M[0].length; c++){
            M[rowN][c] -=  (float)(K * M[barisPengurang][c]);
        }
    }

    static void switchRow(float[][] M, int dtarget){
        int i = dtarget + 1;
        boolean switched = false;
        while ((switched == false) && (i < M.length)){
            if (M[i][dtarget] != 0){
                float temp;
                for (int j = dtarget; j < M[0].length; j++){
                    temp = M[i][j];
                    M[i][j] = M[dtarget][j];
                    M[dtarget][j] = temp;
                }
                switched = true;
            }
            i += 1;
        }
    }

    static boolean lastRow(float[][] M, int i){
        return (i == M.length - 1);
    }

    static boolean lastColumn(float[][] M, int j){
        return (j == M[0].length - 1);
    }

    static void mainOperation(float[][] M, int d, int k, int kcount){
        int bp;
        if (M[d][k] != 1){
            mainCoefTo1(M, d, k);
        }
        bp = k - kcount;
        for (int r = 1 + d; r < M.length; r++){
            rowOperation(M, r, k, bp);
        }
    }

    static void zeroSituation(float[][] M, int d, int k){
        boolean active = true;
        while ((!lastRow(M, d)) && (!lastColumn(M, k)) && (active)){
            int kcount = 0;
            if ((M[d+1][k] != 0)){
                switchRow(M, d);
                mainOperation(M, d, k, 0);
                active = false;
            }
            else if(M[d+1][k] == 0){
                if(M[d][k+1] == 0){
                    k += 1;
                }
                else{
                    k += 1;
                    kcount += 1;
                    mainOperation(M, d, k, kcount);
                    active = false;
                }
            }
        }
        while (lastRow(M, d) && active){
            if (!lastColumn(M, k)){
                if (M[d][k+1] != 0){
                    if (!(M[d][k+1] == 1)){
                        mainCoefTo1(M, d, k+1);
                        active = false;
                    }
                }
                else if (M[d][k+1] == 0){
                    k += 1;
                }
            }
            else{
                active = false;
            }
        }
    }

    static float[][] gaussElimination(float[][] M){
        int k = 0;

        for (int d = 0; d < M.length; d++){
            k = d;
            if (lastRow(M, d)){
                if ((M[d][k] != 1) && (M[d][k] != 0)){
                    mainCoefTo1(M, d, k);
                }
                else if (M[d][k] == 0){
                    zeroSituation(M, d, k);
                }
                break;
            }
            if (M[d][k] != 0){
                mainOperation(M, d, k, 0);
            }
            else{ //M[d][k] == 0
                zeroSituation(M, d, k);
            }
        }
        return M;
    }
}
