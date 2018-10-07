
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Klawiatura {
    public static void main(String[] args) {
        Okno okno=new Okno();
    }
}

class Okno extends JFrame {
    public Okno(){
        setTitle("Edytor tekstu");
        setSize(800,200);
        Panel panel=new Panel();
        getContentPane().add(panel);
        setDefaultCloseOperation(3);
        setVisible(true);
    }
}


class Panel extends JPanel implements KeyListener {
    String tekst="";
    public Panel() {
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){
        g.clearRect(0,0,800,200);
        Font czcionka=new Font("Monospaced",Font.BOLD,30);
        g.setFont(czcionka);
        g.setColor(Color.red);
        g.drawString(tekst,10,50);
    }

    public void keyPressed(KeyEvent e){

        int kod=e.getKeyCode();
        char znak=e.getKeyChar();
        if (kod==KeyEvent.VK_BACK_SPACE) {
            tekst=tekst.substring(0,tekst.length()-1);
        }
        else tekst=tekst+znak;
        this.repaint();
    }
    public void keyTyped(KeyEvent e){ }
    public void keyReleased(KeyEvent e){ }
}
