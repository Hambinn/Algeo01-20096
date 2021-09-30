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
                System.out.print("\nMasukkan metode yang dipilih : ");
                int subMenuSatu = input.nextInt();
                if(subMenuSatu == 1){
                    SPL1();
                }
                
                else if(subMenuSatu == 2){
                    // jordan
                }

                else if(subMenuSatu == 3){
                    SPL3();
                }

                else if(subMenuSatu == 4){
                    //cramer
                }
            }

            else if(menu == 2){
                int subMenuDua = input.nextInt();
                if(subMenuDua == 2){
                    det1();
                }

                else if(subMenuDua == 2){
                //Kofaktor
                }
            }
            

            else if(menu == 3){
                SPL3();
            }


            else if(menu == 4){

            }
            
            else if(menu == 5){

            }

            else if(menu == 6){
                active = false;
            }
        }
    }


    public static void  BacaMatrix(float matrix[][],int row, int col){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                matrix[i][j] = in.nextFloat();
            }
        }
    }

    public static void printMatrix(float matrix[][],int row, int col) {
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                System.out.print(String.format("%5.2f", matrix[i][j]));
            }
            System.out.println();
        }
    }

    // semangat!!! //
    public static void SPL1(){
        
    }
    public static void SPL2(){
        
    }
    
    public static void SPL3() {
        System.out.println("");
        System.out.println("1. Invers menggunakan reduksi baris");
        System.out.println("2. Invers menggunakan ekspansi kofaktor");
        System.out.print("Pilih metode yang ingin digunakan : ");

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if (num == 1){
            System.out.println("\nMasukkan Ukuran Matriks");
            System.out.println("(ukuran matrix harus n x n)");
            int n = input.nextInt();
            float matrix[][] = new float[n][n];
            float matrixRes[][] = new float[n][n];

            BacaMatrix(matrix, n, n);
            matrixRes = matrix;
            matrix = Inverse.inverseOBE(matrix);

            if (matrix == matrixRes){ // Invers tidak ada
                System.out.println("Matriks ini tidak memiliki balikan");
            }
            else{ // Invers ada
                printMatrix(matrix, n, n);
            }
        }
        else if (num == 2){
            System.out.println("\nMasukkan Ukuran Matriks");
            System.out.println("(ukuran matrix harus n x n)");
            int n = input.nextInt();
            float matrix[][] = new float[n][n];
            BacaMatrix(matrix, n, n);
            Inverse.inverseAdj(matrix, n, n);
        }
            
    }
    
    public static void SPL4() {
        System.out.println("\nMasukkan Ukuran Matrix");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        float matrix[][] = new float[m][n];
        BacaMatrix(matrix, m, n);
        Cramer.cramer(m, n, matrix);
        printMatrix(matrix, m, n);
    }

    public static void det1() {
        System.out.println("\nMasukkan Ukuran Matrix");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        float matrix[][] = new float[n][n];
        BacaMatrix(matrix, n, n);

        float det = ObeDeterminant.determinant(matrix);
        System.out.printf("Determinan = %f", det);
    }
    
}
