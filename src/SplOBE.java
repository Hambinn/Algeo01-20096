public class SplOBE {

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
}