import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        boolean active = true;
        while (active){
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi linier berganda");
            System.out.println("6. Keluar");

            System.out.print("\nMasukkan nomor pilihan : ");
            Scanner input = new Scanner(System.in);
            int menu = input.nextInt();                 
            
            if(menu == 1){
                System.out.println("");
                System.out.println("=====Sistem Persamaan Linier=====");
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss-Jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Metode Cramer");
                System.out.print("Masukkan metode yang dipilih : ");
                int subMenuSatu = input.nextInt();
                if(subMenuSatu == 1){
                    SPL1();
                }
                
                else if(subMenuSatu == 2){
                    SPL2();
                }

                else if(subMenuSatu == 3){
                    SPL3();
                }

                else if(subMenuSatu == 4){
                    SPL4();
                }
            }

            else if(menu == 2){
                System.out.println("");
                System.out.println("=====Determinan=====");
                System.out.println("1. Determinan Menggunakan Reduksi Baris");
                System.out.println("2. Determinan Menggunakan Kofaktor");
                System.out.print("Masukkan metode yang dipilih : ");
                int subMenuDua = input.nextInt();
                if(subMenuDua == 1){
                    det1();
                }

                else if(subMenuDua == 2){
                    det2();
                }
            }
            

            else if(menu == 3){
                inv();
            }


            else if(menu == 4){
                Interpolasi.interpolasi();
            }
            
            else if(menu == 5){

            }

            else if(menu == 6){
                active = false;
            }
        }
    }

    // semangat!!! //
    public static void SPL1(){
        boolean isSquare = false;
        float matrix[][] = bacaUkuranMatriks(isSquare);
        matrix = GaussElimination.gaussElimination(BacaMatrix(matrix));
        printMatrix(matrix);
        // Pemrosesan Gauss Elimination tanpa interpretasi solusi
    }
    public static void SPL2(){
        boolean isSquare = false;
        float matrix[][] = bacaUkuranMatriks(isSquare);
        matrix = GaussJordanElimination.gaussJordanElimination(BacaMatrix(matrix));
        printMatrix(matrix);
        // Pemrosesan Gauss-Jordan Elimination tanpa interpretasi solusi
    }
    public static void SPL3(){
        boolean isSquare = true;
        float matrix[][] = bacaUkuranMatriks(isSquare);
        matrix = splInverse.splInverse(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                System.out.print("x"+i+" = " + matrix[i][j]);
            }
        }
    }
    public static void SPL4() {
        boolean isSquare = false;
        float matrix[][] = bacaUkuranMatriks(isSquare);
        
        float arraySPL[] = Cramer.cramer(matrix.length, matrix[0].length, BacaMatrix(matrix));
        for (int i = 0; i < arraySPL.length; i++){
            System.out.println("x"+ i + " = " + arraySPL[i]);
        }
    }
    // >>>>>>DETERMINAN
    public static void det1() {
        displayPilihanInput();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if(num == 1) {
            boolean isSquare = true;
            float matrix[][] = bacaUkuranMatriks(isSquare);
            System.out.println("Masukkan koefisien a[i][j] untuk matriks : ");
            matrix = BacaMatrix(matrix);
            float det = ObeDeterminant.determinant(matrix);
            System.out.printf("Determinan = %f\n", det);

        }else if(num == 2){
            float matrix[][] = FileProcess.fileProcessing();
            float det = ObeDeterminant.determinant(matrix);
            System.out.printf("Determinan = %\n", det);
        }
    }
    public static void det2() {
        displayPilihanInput();
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if(num == 1) {
            boolean isSquare = true;
            float matrix[][] = bacaUkuranMatriks(isSquare);
            System.out.println("Masukkan koefisien a[i][j] untuk matriks : ");
            matrix = BacaMatrix(matrix);
            float det = KofaktorDeterminan.determinant(matrix, matrix.length);
            System.out.printf("Determinan = %f", det);
        }else if(num == 2){
            float matrix[][] = FileProcess.fileProcessing();
            float det = KofaktorDeterminan.determinant(matrix,matrix.length);
            System.out.printf("Determinan = %f", det);
        }

        

        
    }
    // >>>>>>INVERS
    public static void inv() {
        System.out.println("");
        System.out.println("1. Invers menggunakan reduksi baris");
        System.out.println("2. Invers menggunakan ekspansi kofaktor");
        System.out.print("Pilih metode yang ingin digunakan : ");

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if (num == 1){
            float matrix[][] = bacaUkuranMatriks(true);
            float matrixAsal[][] = new float[matrix.length][matrix.length];

            displayPilihanInput();
            int inputMethod = input.nextInt();

            if (inputMethod == 1){
                System.out.println("Masukkan koefisien a[i][j] untuk matriks : ");
                matrix = BacaMatrix(matrix);
                matrixAsal = matrix;
                matrix = Inverse.inverseOBE(matrix);
            }

            else if (inputMethod == 2){
                FileProcess.fileProcessing();
            }

            if (matrix == matrixAsal){ // Invers tidak ada
                System.out.println("Matriks ini tidak memiliki balikan");
            }
            else{ // Invers ada
                printMatrix(matrix);
            }
        }
        else if (num == 2){
            displayPilihanInput();
            int inputMethod = input.nextInt();

            if (inputMethod == 1){
                float matrix[][] = bacaUkuranMatriks(true);
                float matrixAsal[][] = matrix;
                System.out.println("Masukkan koefisien a[i][j] untuk matriks : ");
                matrix = BacaMatrix(matrix);
                matrixAsal = matrix;
                matrix = Inverse.inverseAdj(matrix, matrix.length, matrix.length);

                if (matrix == matrixAsal){ // Invers tidak ada
                System.out.println("Matriks ini tidak memiliki balikan");
                }
                else{ // Invers ada
                    printMatrix(matrix);
                }
            }
            else if (inputMethod == 2){
                float matrix[][] = FileProcess.fileProcessing();
                float matrixAsal[][] = matrix;

                matrixAsal = matrix;
                matrix = Inverse.inverseAdj(matrix, matrix.length, matrix.length);

                if (matrix == matrixAsal){ // Invers tidak ada
                System.out.println("Matriks ini tidak memiliki balikan");
                }
                else{ // Invers ada
                    printMatrix(matrix);
                }
            }
        }
    }

    // >>>>>>SUPPORTING METHOD
    public static void displayPilihanInput(){
        System.out.println("\nMetode Input");
        System.out.println("1. Input melalui keyboard");
        System.out.println("2. Input melalui file");
        System.out.print("Pilih metode input yang diinginkan : ");
    }
    public static float[][]  BacaMatrix(float matrix[][]){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = in.nextFloat();
            }
        }
        return matrix;
    }
    public static void printMatrix(float matrix[][]) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(String.format("%7.2f", matrix[i][j]));
            }
            System.out.println();
        }
    }
    public static float[][] bacaUkuranMatriks(boolean isSquare){
        if (isSquare){
            System.out.println("\nMasukkan Ukuran Matrix n x n");
            System.out.print("n : ");
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            float matrix[][] = new float[n][n];
            return matrix;
        }
        else{
            Scanner input = new Scanner(System.in);
            System.out.println("\nMasukkan Ukuran Matrix m x n");
            System.out.print("m : ");
            int m = input.nextInt();
            System.out.print("n : ");
            int n = input.nextInt();
            
            float matrix[][] = new float[m][n];
            return matrix;
        }
    }
}
