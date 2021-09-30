public class SplOBE {
    /*
    public static float[] SplGauss(float[][] M){
        for (int i = 0; i < M.length; i++){
            int verdict = rowStatus(M, i);
            if (verdict == 0){ // Solusi banyak
                
            }
            else if (verdict == 1){ // Solusi Unik atau tunggal
                
            }
            else if (verdict == -1){ // Tidak ada solusi
                
            }
        }

        float[] arraySPL;
        return arraySPL;
    }
    
    
    public static float[] SplGaussJordan(float[][] M){

    }
    */

    public static int rowStatus(float[][] M, int row){
        int nonZeroAppear = 0; 
        float lastColVal = M[row][M[0].length - 1];

        int j = 0;
        do{
            if (M[row][j] != 0){
                nonZeroAppear = 1;
            }
            j += 1;
        }while((nonZeroAppear == 0) && (j < M[0].length - 1));

        if (nonZeroAppear == 1){ // Muncul angka bukan 0 sebelum kolom terakhir
            return 1;
        }
        else{ // Angka selain 0 tidak muncul sebelum kolom terakhir
            if(lastColVal == 0){ // 0 * x = 0
                return 0;
            }
            else{ // 0 * x = k
                return -1;
            }
        }
    }

    /*
    public static float[] specialSolution(float[][] M){
        float arraySPL[] = new float[M[0].length - 1];
        for (int i = M.length - 1; i >= 0; i--){
            for (int j = 0; j < M[0].length; j++){
                if (M[i][j] == 1){
                    // Belum selesai, bingung
                }
            }
        }
    }
    */

}