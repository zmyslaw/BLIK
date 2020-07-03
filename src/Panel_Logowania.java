import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Panel_Logowania extends JFrame implements ActionListener
{
    JTextField login_JF;
    JTextField haslo_JF;
    JTextField znak;

    JButton CAPTCHA;
    JButton zaloguj;
    JButton wroc;

    JLabel N_O_T; //NIEZIDENTYFIKOWANY OBIEKT TEKSTOWY
    JLabel kod_wys;

    int liczba;
    int licznik;
    public Panel_Logowania() {
        super("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(555, 450);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        login_JF = new JTextField(15);
        haslo_JF = new JPasswordField(15);
        znak = new JTextField(15);
        N_O_T =  new JLabel(" ");

        zaloguj = new JButton("Zaloguj");
        zaloguj.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.addActionListener(this);

        CAPTCHA = new JButton("CAPTCHA ");
        CAPTCHA.addActionListener(this);

        add(new JLabel("Login:"));
        add(login_JF);
        add(new JLabel("__________________________________________________________________________"));
        add(new JLabel("Haslo:"));
        add(haslo_JF);
        add(new JLabel("__________________________________________________________________________"));
        add(new JLabel("Wprowadz:"));
        add(znak);
        add(CAPTCHA);
        add(new JLabel("__________________________________________________________________________"));
        add(zaloguj);
        add(wroc);
        add(new JLabel("__________________________________________________________________________"));
        add(N_O_T);

        JMenuBar menubar = new JMenuBar();

        JMenu menuPomoc = new JMenu("Wiecej");
        JMenuItem menuOProgramie = new JMenuItem("Autor");
        menuOProgramie.addActionListener(this);
        menuPomoc.add(menuOProgramie);
        menubar.add(menuPomoc);

        setJMenuBar(menubar);

        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        String label = e.getActionCommand();
        if(label.equals("Autor"))
        {
            JOptionPane.showMessageDialog(null,"Adrian Zmyslowski");
        }

        Czytaj_Pliku Czy_Pli = new Czytaj_Pliku();
        Osoba[] tab =Czy_Pli.metoda().clone();

        Object zrodlo = e.getSource();
        String znaki = znak.getText() ;

        String jeden = "BTKJ94";
        String dwa =  "PIWD40";
        String trzy =   "ZMAK47";
        String cztery =  "ABCD34";
        String piec =   "HJKB19";
        String szesc =   "ZASY56";

        if(zrodlo == CAPTCHA)
        {
            if(licznik ==0){
                try {
                    licznik++;

                    Random generator = new Random();
                    this.liczba = generator.nextInt(6 - 1 +1) + 1;
                    String sciezka= "cap/"+liczba+".jpg";

                    BufferedImage myPicture = ImageIO.read(new File(sciezka));
                    JLabel kod_utw = new JLabel(new ImageIcon(myPicture));

                    this.kod_wys=kod_utw;

                    add(kod_wys);

                    N_O_T.setText(" "+" ");
                }catch(IOException ee) {}
            }else if(licznik>0){
                try {
                    N_O_T.setVisible(false);
                    remove(kod_wys);

                    Random generator = new Random();
                    this.liczba = generator.nextInt(6 - 1 +1) + 1;
                    String sciezka= "cap/"+liczba+".jpg";

                    BufferedImage myPicture = ImageIO.read(new File(sciezka));
                    JLabel kod_utw = new JLabel(new ImageIcon(myPicture));

                    this.kod_wys=kod_utw;

                    add(kod_wys);

                    N_O_T.setVisible(true);
                }catch(IOException ee) {}
            }
        }

        int zero=0;
        if(zrodlo == zaloguj)
        {
            try {
                for(int i=0;i<tab.length;i++){
                    if( login_JF.getText().equals(tab[i].Dajlogin()) &&
                            haslo_JF.getText().equals(tab[i].Dajhaslo())
                    ){
                        try {
                            if(liczba==1){
                                if(znaki.equals(jeden)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }else if(liczba==2){
                                if(znaki.equals(dwa)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }else if(liczba==3){
                                if(znaki.equals(trzy)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }else if(liczba==4){
                                if(znaki.equals(cztery)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }else if(liczba==5){
                                if(znaki.equals(piec)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }else if(liczba==6){
                                if(znaki.equals(szesc)){
                                    JOptionPane.showMessageDialog(null,"Zalogowano.");

                                    Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(login_JF.getText());
                                    Pan_Uzy.setVisible(true);

                                    setVisible(false);
                                    dispose();

                                    zero++;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null,
                                            "Zly kod.",
                                            "Blad", JOptionPane.ERROR_MESSAGE);

                                    zero++;
                                    break;
                                }
                            }
                        }catch (NumberFormatException ee) {}
                    }
                }
                if(zero==0){
                    JOptionPane.showMessageDialog(null,
                            "Zle wartosci.",
                            "Blad", JOptionPane.ERROR_MESSAGE);

                    zero=0;
                }
            }catch (NumberFormatException ee) {}
        }else if(zrodlo == wroc){
            try {
                Panel_Glowny Pan_Glo =new Panel_Glowny();
                Pan_Glo.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }
    }
}
