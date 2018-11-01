
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class MoveScript extends JFrame {
    private JButton jbtRun = new JButton("Run");
    private JButton jbtUp = new JButton("Up");
    private JButton jbtDown = new JButton("Down");
    private JButton jbtLeft = new JButton("Left");
    private JButton jbtRight = new JButton("Right");
    private JButton jbtExit = new JButton("Exit");
    private Container cp;
    private JLabel jlb = new JLabel();
    private JPanel jpnC = new JPanel();
    private JPanel jpnS = new JPanel(new GridLayout(1,6,2,2));
    private ImageIcon icon = new ImageIcon("駱駝.png");
    private Timer tim ;
    private int dirflag = 1;
    int ObjX =0 , ObjY = 0;
    int ObjW =128 , ObjH = 128;
    public MoveScript(){
        this.init();
    }
    public void init() {
        cp = this.getContentPane();
        this.setBounds(100, 100, 1000, 800);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnS, BorderLayout.SOUTH);
        jpnC.setLayout(null);
        jpnC.add(jlb);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jlb.setBounds(ObjX, ObjY, ObjW, ObjH);
        jlb.setIcon(icon);
        jpnS.add(jbtRun);
        jpnS.add(jbtUp);
        jpnS.add(jbtDown);
        jpnS.add(jbtLeft);
        jpnS.add(jbtRight);
        jpnS.add(jbtExit);

        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        tim = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                switch (dirflag) {
                    case 1:
                        if (ObjY > 0) {
                            ObjY -= 10;
                        }
                        break;
                    case 2:
                        if (ObjY < 800 - ObjH) {
                            ObjY += 10;
                        }
                        break;
                    case 3:
                        if(ObjX -10 >0){
                            ObjX -= 10;

                        }
                        break;
                    case 4:
                        if(ObjX < 1000 -ObjW){
                            ObjX += 10;

                        }
                        break;
                }
                jlb.setLocation(ObjX, ObjY);
            }
        });

        jbtRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tim.start();
            }
        });
        jbtUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirflag =1;
            }
        });
        jbtDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirflag =2;
            }
        });
        jbtLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirflag =3;
            }
        });
        jbtRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirflag =4;
            }
        });
    }
}
