import java.io.*;
import java.util.*;
public class Czytaj_Pliku
{
    public Osoba[] metoda(){
        Odkodowanie odk = new Odkodowanie();

        ArrayList<Osoba> lista = new ArrayList<Osoba>();

        try {
            DataInputStream czytaj = new DataInputStream(new FileInputStream("inf/inf.txt"));
            while(czytaj.available()>0) {
                String login = odk.metoda(czytaj.readLine());
                String haslo = odk.metoda(czytaj.readLine());

                Osoba o1 = new Osoba(login,haslo);
                lista.add(o1);
            }
        }
        catch (Exception ee) {}

        Osoba tab[] = new Osoba[lista.size()];
        tab = lista.toArray(tab);

        return tab;
    }
}
