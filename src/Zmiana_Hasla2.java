import java.io.*;
import java.util.*;

public class Zmiana_Hasla2 {
    int licznik=0;
    String pamiec;

    public void metoda(String haslo, int linia)throws IOException{
        Odkodowanie odk = new Odkodowanie();

        File kopia = new File("inf/kopia.txt");
        if (kopia.exists()) {
            kopia.delete();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("inf/inf.txt"), "UTF-8"));

        FileReader fileReader = new FileReader("inf/inf.txt");

        String textLine = bufferedReader.readLine();
        PrintWriter zapis = new PrintWriter("inf/kopia.txt");

        BufferedReader reader = new BufferedReader(new FileReader("inf/inf.txt"));
        int lines = 0;
        while (reader.readLine() != null) {lines++;}
        reader.close();

        do {
            licznik++;
            if(licznik<linia){
                zapis.println(textLine);

                textLine = bufferedReader.readLine();
            }else if(licznik==linia){
                zapis.println(haslo);

                textLine = bufferedReader.readLine();
            }else if(licznik>linia){
                if(licznik==lines){
                    zapis.print(textLine);

                    textLine = bufferedReader.readLine();
                }else{
                    zapis.println(textLine);

                    textLine = bufferedReader.readLine();
                }
            }
        } while(textLine != null);
        bufferedReader.close();
        zapis.close();

        File usun = new File("inf/inf.txt");
        if (usun.exists()) {
            usun.delete();
        }

        Kopiuj_Plik Kop_Pli = new Kopiuj_Plik();
        Kop_Pli.metoda();
    }
}