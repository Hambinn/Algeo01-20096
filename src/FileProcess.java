import java.io.FileReader;
import java.io.IOException;

public class FileProcess {
    public static void fileInput(String strFile)
    {
        String strConv = "";
        try {
            FileReader fRead = new FileReader(strFile);
            
            
            int ch;
            while ((ch = fRead.read()) != -1) {
                strConv += (char)ch;
            }
            System.out.println("||>> Pembacaan file selesai\n");
            System.out.println(strConv);
            fRead.close();
            
        }

        catch (IOException e) {
            System.out.println("!!>>File tidak terdeteksi atau error dalam pembacaan  file.");
        }
    }
}

