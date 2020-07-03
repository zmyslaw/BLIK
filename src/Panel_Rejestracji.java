import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Panel_Rejestracji extends JFrame implements ActionListener
{
    JTextField login_JF;
    JTextField haslo_JF;
    JTextField haslo2_JF;

    JButton wprowadz;
    JButton wroc;

    public Panel_Rejestracji() {
        super("Rejestracja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 300);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        login_JF = new JTextField(15);
        haslo_JF = new JPasswordField(15);
        haslo2_JF = new JPasswordField(15);

        wprowadz = new JButton("Wprowadz");
        wprowadz.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.addActionListener(this);

        add(new JLabel("Login:"));
        add(login_JF);
        add(new JLabel("__________________________________________________________________________"));
        add(new JLabel("Haslo:"));
        add(haslo_JF);
        add(new JLabel("__________________________________________________________________________"));
        add(new JLabel("Potwierdz:"));
        add(haslo2_JF);
        add(new JLabel("__________________________________________________________________________"));
        add(wprowadz);
        add(wroc);

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

        Object zrodlo = e.getSource();

        Dlugosc Dlu = new Dlugosc();
        Szukaj_Powtorzen Szu_Pow = new Szukaj_Powtorzen();

        Kodowanie kod = new Kodowanie();

        if(zrodlo == wprowadz  &&
                login_JF.getText() != null && !login_JF.getText().isEmpty() &&
                haslo_JF.getText() != null && !haslo_JF.getText().isEmpty() &&
                Dlu.metoda(haslo_JF.getText()) >=3 &&
                Dlu.metoda(login_JF.getText()) >=3 &&
                Szu_Pow.metoda(login_JF.getText(),haslo_JF.getText())==0
        ){
            try {
                if(haslo_JF.getText().equals(haslo2_JF.getText())){
                    try{
                        Writer output = new BufferedWriter(new FileWriter("inf/inf.txt", true));

                        output.append("\r\n"+kod.metoda(login_JF.getText()));
                        output.append("\r\n"+kod.metoda(haslo_JF.getText()));
                        output.close();
                    }
                    catch(IOException ee){}
                    JOptionPane.showMessageDialog(null,"Zaakceptowano.");

                    Panel_Glowny Pan_Glo =new Panel_Glowny();
                    Pan_Glo.setVisible(true);

                    setVisible(false);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Hasla nie sa takie same.",
                            "Blad", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException ee) {}
        }else if(zrodlo == wroc){
            try {
                Panel_Glowny Pan_Glo =new Panel_Glowny();
                Pan_Glo.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }else if(zrodlo == wprowadz  &&
                login_JF.getText() == null || !login_JF.getText().isEmpty() ||
                haslo_JF.getText() == null || !haslo_JF.getText().isEmpty() ||
                Dlu.metoda(haslo_JF.getText()) <3 ||
                Dlu.metoda(login_JF.getText()) <3 ||
                Szu_Pow.metoda(login_JF.getText(),haslo_JF.getText())!=0){
            JOptionPane.showMessageDialog(null,
                    "Wprowadz poprawne dane. Unikalny login oraz haslo min 3 znaki.",
                    "Blad", JOptionPane.ERROR_MESSAGE);
        }
    }
}
