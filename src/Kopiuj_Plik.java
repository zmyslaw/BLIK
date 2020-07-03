import java.util.*;
import java.io.*;

public class Kopiuj_Plik
{
    public void metoda()throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("inf/inf.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("inf/kopia.txt"), "UTF-8"));

        Odkodowanie odk = new Odkodowanie();

        FileReader fileReader = new FileReader("inf/kopia.txt");

        String textLine = bufferedReader.readLine();
        PrintWriter zapis = new PrintWriter("inf/inf.txt");
        int licznik=0;
        do {
            licznik++;

            if(lines==licznik){
                zapis.print(textLine);

                textLine = bufferedReader.readLine();
            }else{
                zapis.println(textLine);

                textLine = bufferedReader.readLine();
            }

        } while(textLine != null);

        bufferedReader.close();

        zapis.close();
    }
}
