import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyMoveScript extends JFrame {
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private ImageIcon iconright = new ImageIcon("ship.png");
    private ImageIcon iconleft = new ImageIcon("shipleft.png");
    private ImageIcon iconrocket = new ImageIcon("rocket.png");
    Container cp;
    Timer t1;

    public KeyMoveScript() {
        this.init();
    }

    public void init() {
        this.setBounds(80, 60, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(null);
        cp.add(jlb);

        jlb.setIcon(iconleft);
        jlb.setIcon(iconright);

        Image img = iconright.getImage();
        Image img1 = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        Image img2 = iconleft.getImage();
        Image img3 = img2.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        Image img4 = iconrocket.getImage();
        Image img5 = img4.getScaledInstance(30,60,Image.SCALE_SMOOTH);

        iconright.setImage(img1);
        iconleft.setImage(img3);
        iconrocket.setImage(img5);

        jlb.setBounds(400,400,200,200);

        t1 = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jlb.setLocation(jlb.getX(),jlb.getY()-5);
                if(jlb.getY()<0){
                    t1.stop();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        jlb.setIcon(iconleft);
                        jlb.setLocation(jlb.getX(), jlb.getY()-20);
                        break;
                    case KeyEvent.VK_DOWN:
                        jlb.setIcon(iconleft);
                        jlb.setLocation(jlb.getX(), jlb.getY()+20);
                        break;
                    case 37:
                        jlb.setIcon(iconleft);
                        jlb.setLocation(jlb.getX() - 20, jlb.getY());
                        break;
                    case 39:
                        jlb.setIcon(iconleft);
                        jlb.setLocation(jlb.getX() + 20, jlb.getY());
                        break;
                    case 32:
                        t1.start();
                }
            }
        });
    }
}
