import java.io.*;
import java.util.*;

public class Zmiana_Hasla
{
    public void metoda(String haslo2,String login2){
        Odkodowanie odk = new Odkodowanie();
        int licznik=0;

        try {
            DataInputStream czytaj = new DataInputStream(new FileInputStream("inf/inf.txt"));
            while(czytaj.available()>0) {
                String login = odk.metoda(czytaj.readLine()); licznik++;
                String haslo = odk.metoda(czytaj.readLine()); licznik++;

                if(login.equals(login2)){
                    Zmiana_Hasla2 Zmi_Has2 = new Zmiana_Hasla2();
                    Zmi_Has2.metoda(haslo2, licznik);

                    break;
                }
            }
        }
        catch (Exception ee) {}
    }
}
