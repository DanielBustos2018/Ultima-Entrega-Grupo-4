
package Logica;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
 

public class ImagenFondo implements Border{
    public BufferedImage back;
 
    public ImagenFondo(){
        try {
            URL url_imagen = new URL(getClass().getResource("../Archivos/fondo3a.jpg").toString());
            back = ImageIO.read(url_imagen);
        } catch (Exception ex) {            
        }
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);
    }
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }
 
}
