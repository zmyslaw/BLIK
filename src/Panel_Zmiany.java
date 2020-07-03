import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Panel_Zmiany extends JFrame implements ActionListener
{
    JButton zmien;
    JButton wroc;
    JTextField haslo_JF;
    JTextField haslo2_JF;

    String nazwa;
    public Panel_Zmiany(String nazwa) {
        super("Panel_Zmiany");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nazwa=nazwa;

        setSize(333, 252);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        haslo_JF = new JPasswordField(15);
        haslo2_JF = new JPasswordField(15);

        add(new JLabel("Konto: "+this.nazwa));
        add(new JLabel("______________________________________________"));

        add(new JLabel("Nowe:"));
        add(haslo_JF);
        add(new JLabel("______________________________________________"));

        add(new JLabel("Potwierdz:"));
        add(haslo2_JF);

        zmien = new JButton("Zmien haslo");
        zmien.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.addActionListener(this);

        add(wroc);
        add(zmien);

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

        Szukaj_Powtorzen Szu_Pow = new Szukaj_Powtorzen();
        Dlugosc Dlu = new Dlugosc();

        Object zrodlo = e.getSource();
        if(zrodlo == zmien &&
                Szu_Pow.metoda2(haslo_JF.getText())!=0
        ){
            JOptionPane.showMessageDialog(null,"Takie haslo juz istnieje.");
        }else if(zrodlo == zmien &&
                Dlu.metoda(haslo_JF.getText()) <3 ){
            try {
                JOptionPane.showMessageDialog(null,"Haslo musi miec min 3 znaki.");
            }catch (NumberFormatException ee) {}
        }else if( zrodlo == zmien &&
                haslo_JF.getText() != null && !haslo_JF.getText().isEmpty() &&
                haslo_JF.getText().equals(haslo2_JF.getText()) &&
                Szu_Pow.metoda2(haslo_JF.getText())==0 &&
                Dlu.metoda(haslo_JF.getText()) >=3 ){
            try {
                JOptionPane.showMessageDialog(null,"Zmieniono.");

                Zmiana_Hasla Zmi_Has = new Zmiana_Hasla();
                Zmi_Has.metoda(haslo_JF.getText(),this.nazwa);

                Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(this.nazwa);
                Pan_Uzy.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }else if(zrodlo == wroc){
            try {
                Panel_Uzytkownika Pan_Uzy =new Panel_Uzytkownika(this.nazwa);
                Pan_Uzy.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }
    }
}
