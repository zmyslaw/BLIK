import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Panel_Uzytkownika  extends JFrame implements ActionListener
{
    JButton zmien;
    JButton wyloguj;
    JButton generuj;

    String nazwa;

    public Panel_Uzytkownika(String nazwa) {
        super("Uzytkownik");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nazwa=nazwa;

        setSize(333, 200);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(new JLabel("Konto: "+this.nazwa));
        add(new JLabel("______________________________________________"));

        zmien = new JButton("Zmien haslo");
        zmien.addActionListener(this);

        wyloguj = new JButton("Wyloguj");
        wyloguj.addActionListener(this);

        generuj = new JButton("Generuj token");
        generuj.addActionListener(this);

        add(wyloguj);
        add(zmien);
        add(generuj);

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
        if(zrodlo == zmien){
            try {
                Panel_Zmiany Pan_Zmi =new Panel_Zmiany(this.nazwa);
                Pan_Zmi.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) { }
        }else if(zrodlo == wyloguj){
            try {
                JOptionPane.showMessageDialog(null,"Wylogowano.");

                Panel_Glowny Pan_Glo =new Panel_Glowny();
                Pan_Glo.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }else if(zrodlo == generuj){
            try {
                Panel_Generuj Pan_Gen =new Panel_Generuj( this.nazwa);
                Pan_Gen.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }
    }
}
