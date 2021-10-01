import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


// https://stackoverflow.com/questions/49562415/read-a-matrix-from-a-txt-and-store-it-in-a-2d-array-in-java/49562620
// https://stackoverflow.com/questions/14512251/convert-string-into-2d-int-array
// https://www.geeksforgeeks.org/split-string-java-examples/
// ini UDAH jalan ya
public class FileProcess {
    public static float[][] fileProcessing() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama file : ");
        String matFile = input.nextLine();
        
        return strToFloat(fileInput(matFile));
    }
    public static String fileInput(String strFile)
    {
        String strConv = "";
        String namaFile = "../test/" + strFile;
        try {
            FileReader fRead = new FileReader(namaFile);

            int ch;
            while ((ch = fRead.read()) != -1) {
                strConv += (char)ch;
            }
            System.out.println("||>> Pembacaan file selesai\n");
            fRead.close();
        }
        catch (IOException e) {
            System.out.println("!!>>File tidak terdeteksi atau error dalam pembacaan  file.");
        }
        return strConv;
    }


    public static float[][] strToFloat(String mat){
        String[] hasilSplit = mat.split("\n");

        float[][] matrix = new float[hasilSplit.length][];
        for (int i = 0; i < matrix.length; i++) {

            String[] arr2 = hasilSplit[i].split(" ");
            matrix[i] = new float[arr2.length];

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Float.parseFloat(arr2[j]);
            }
        }

        return matrix;
    }


    
}

