import javax.swing.*;
import java.awt.*;

public class Encrypt extends JFrame {
    private JTextArea jtL = new JTextArea();
    private JTextArea jtR = new JTextArea();
    private JScrollPane jsL = new JScrollPane(jtL);
    private JScrollPane jsR = new JScrollPane(jtR);
    private JRadioButton jrdbE = new JRadioButton("Encrypt");
    private JRadioButton jrdbD = new JRadioButton("Decrypt");
    private String [] methodst ={"Caesar","XOR"};
    private JButton jbtnRun = new JButton("Run");
    private JButton jbtnClose = new JButton("Close");
    private JPanel jpnC = new JPanel(new GridLayout(4,4,4,4));
    private JPanel jpnW = new JPanel();
    private JPanel jpnN = new JPanel();
    private Container cp;
    public Encrypt(){
        init();
    }
    public void init(){
        this.setBounds(100,100,600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnW,BorderLayout.WEST);
        cp.add(jpnN);
        cp.add(jpnW);
        jpnC.add(jrdbE);
        jpnC.add(jrdbD);
        jpnC.add(jbtnRun);
        jpnC.add(jbtnClose);
        jpnW.add(jsL);
    }
}
