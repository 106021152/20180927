import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CodeTable extends JFrame {
    private JLabel jlbs[] = new JLabel[8];
    private String jlbImageName[]={"0.png","1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png"};
    private ImageIcon icon[] = new ImageIcon[10];
    private JPanel jpnc = new JPanel(new GridLayout(1,8,3,3));
    private JPanel jpns = new JPanel(new GridLayout(1,2,3,3));
    private Timer tim;
    private int h,m,s;
    Container cp;
    private JButton jbtnStart = new JButton("Start");
    private JButton jbtnReset = new JButton("Reset");
    private JButton jbtnExit = new JButton("Exit");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 450,frmh = 200;
    public CodeTable(){
        init();
    }
    public void init(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setBounds(screew / 2 - frmw / 2, screeh / 2 - frmh / 2, frmw, frmh);
        for(int i = 0 ; i < 10 ; i++) {
            icon[i] = new ImageIcon(jlbImageName[i]);
            Image img = icon[i].getImage();
            Image newimg = img.getScaledInstance(30, 60, Image.SCALE_SMOOTH);
            icon[i] = new ImageIcon(newimg);
        }
        jlbs[6] = new JLabel(":");
        jlbs[6].setFont(new Font(null,Font.BOLD,24));
        jlbs[7] = new JLabel(":");
        jlbs[7].setFont(new Font(null,Font.BOLD,24));
        for(int i = 0 ; i < 6 ; i++){
            jlbs[i] = new JLabel(icon[0]);
            if(i == 2){
                jpnc.add(jlbs[6]);
                jpnc.add(jlbs[i]);
            }else if(i == 4){
                jpnc.add(jlbs[7]);
                jpnc.add(jlbs[i]);
            }else {
                jpnc.add(jlbs[i]);
            }
        }
        tim = new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s++;
                if(s == 60){
                    s = 0;
                    m++;
                    if(m == 60){
                        m = 0;
                        h++;
                    }
                }
                if(s % 2 ==0){
                    jlbs[6].setForeground(Color.GREEN);
                    jlbs[7].setForeground(Color.GREEN);
                }else {
                    jlbs[6].setForeground(Color.BLACK);
                    jlbs[7].setForeground(Color.BLACK);
                }
                jlbs[5].setIcon(icon[s%10]);
                jlbs[4].setIcon(icon[s/10]);
                jlbs[3].setIcon(icon[m%10]);
                jlbs[2].setIcon(icon[m/10]);
                jlbs[1].setIcon(icon[h%10]);
                jlbs[0].setIcon(icon[h/10]);
            }
        });
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpns, BorderLayout.SOUTH);
        jpns.add(jbtnStart);
        jpns.add(jbtnExit);
        jbtnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpbtn =(JButton)e.getSource();
                if(tmpbtn.getText().equals("Start")){
                    tim.start();
                    jbtnStart.setText("Pause");
                }else {
                    tim.stop();
                    jbtnStart.setText("Start");
                }
            }
        });
        jbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
