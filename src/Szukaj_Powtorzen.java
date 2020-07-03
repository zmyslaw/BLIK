import java.io.*;
import java.util.*;

public class Szukaj_Powtorzen{
    public int metoda(String login2,String haslo2){
        int liczba =0;

        Odkodowanie odk = new Odkodowanie();

        ArrayList<Osoba> lista = new ArrayList<Osoba>();

        try {
            DataInputStream czytaj = new DataInputStream(new FileInputStream("inf/inf.txt"));
            while(czytaj.available()>0) {
                String login = odk.metoda(czytaj.readLine());
                String haslo = odk.metoda(czytaj.readLine());

                Osoba u1 = new Osoba(login,haslo);
                lista.add(u1);
            }
        }
        catch (Exception ee) {}

        Osoba tab[] = new Osoba[lista.size()];
        tab = lista.toArray(tab);

        for(int i=0;i<tab.length;i++){
            if(tab[i].Dajlogin().equals(login2)
                    || tab[i].Dajhaslo().equals(haslo2)
            ){
                liczba++;
            }
        }

        return liczba;
    }

    public int metoda2(String haslo2){
        int liczba =0;

        Odkodowanie odk = new Odkodowanie();

        ArrayList<Osoba> lista = new ArrayList<Osoba>();

        Scanner scanner = new Scanner("inf/inf.txt");
        try {
            DataInputStream czytaj = new DataInputStream(new FileInputStream("inf/inf.txt"));
            while(czytaj.available()>0) {
                String login = odk.metoda(czytaj.readLine());
                String haslo = odk.metoda(czytaj.readLine());

                Osoba u1 = new Osoba(login,haslo);
                lista.add(u1);
            }
        }
        catch (Exception ee) {}

        Osoba tab[] = new Osoba[lista.size()];
        tab = lista.toArray(tab);

        for(int i=0;i<tab.length;i++){
            if(tab[i].Dajhaslo().equals(haslo2)){
                liczba++;
            }
        }

        return liczba;
    }
}
