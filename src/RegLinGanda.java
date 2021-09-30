public class RegLinGanda {
    public static void regresi() {
        
    }

    public static void  BacaMatrix(float matrix[][],int row, int col){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                matrix[i][j] = in.nextFloat();
            }
        }
    }



}