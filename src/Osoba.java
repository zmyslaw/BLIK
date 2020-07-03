import java.io.*;

public class Osoba implements Serializable
{
    String login = "";
    String haslo = "";

    public Osoba (String login, String haslo)
    {
        this.login = login;
        this.haslo = haslo;
    }

    public String Dajlogin(){
        return this.login;
    }

    public String Dajhaslo(){
        return this.haslo;
    }

    public void Zmienlogin(String s){
        this.login=s;;
    }

    public void Zmienhaslo(String s){
        this.haslo=s;
    }

    public String toString(){
        return this.login+" "+this.haslo;
    }
}
