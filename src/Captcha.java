import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Captcha extends JPanel {

    public void paint(Graphics g) {
        // Image img = metoda();
        //g.drawImage(img, 20,20,this);
    }

    public void metoda() {
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.drawString("cap/", 20,100);

        // return bufferedImage;
    }
}