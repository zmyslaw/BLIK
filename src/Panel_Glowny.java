import java.awt.FlowLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Panel_Glowny extends JFrame implements ActionListener
{
    JButton rejestruj;
    JButton loguj;

    public Panel_Glowny() {
        super("Strona glowna");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(333, 111);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        rejestruj = new JButton("Rejestracja");
        rejestruj.addActionListener(this);

        loguj = new JButton("Logowanie");
        loguj.addActionListener(this);

        add(loguj);
        add(rejestruj);

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
        if(zrodlo == loguj){
            try {
                Panel_Logowania Pan_Log =new Panel_Logowania();
                Pan_Log.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) { }
        }else if(zrodlo == rejestruj){
            try {
                Panel_Rejestracji Pan_Rej =new Panel_Rejestracji();
                Pan_Rej.setVisible(true);

                setVisible(false);
                dispose();
            }catch (NumberFormatException ee) {}
        }
    }
}
