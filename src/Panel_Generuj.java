import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Panel_Generuj extends JFrame implements ActionListener
{
    JButton token;
    JButton wroc;
    JLabel wyswietl;

    String nazwa;
    public Panel_Generuj(String nazwa) {
        super("Generuj token");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nazwa=nazwa;

        setSize(333, 252);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(new JLabel("Konto: "+this.nazwa));
        add(new JLabel("______________________________________________"));
        wyswietl =  new JLabel(" ");
        add(wyswietl);
        add(new JLabel("______________________________________________"));

        token = new JButton("Token");
        token.addActionListener(this);

        wroc = new JButton("Wroc");
        wroc.addActionListener(this);

        add(wroc);
        add(token);

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
        if(zrodlo == token  ){
            Random generator = new Random();
            int liczba = generator.nextInt(99999 - 1 +1) + 1;

            wyswietl.setText(liczba+"");

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
