import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Encrypt extends JFrame {
    private JLabel jlbM = new JLabel("Method");
    private JLabel jlbK = new JLabel("Key");
    private JTextArea jaL = new JTextArea("",30,15);
    private JTextArea jaR = new JTextArea("",30,15);
    private JScrollPane jsL = new JScrollPane(jaL);
    private JScrollPane jsR = new JScrollPane(jaR);
    private JPasswordField jpf = new JPasswordField();
    private String [] methodstr = {"Caesar","Xor"};
    private JComboBox jcb = new JComboBox(methodstr);
    private JRadioButton jbtnE = new JRadioButton("Encrypt");
    private JRadioButton jbtnD = new JRadioButton("Decrypt");
    private JButton jbtnR = new JButton("Run");
    private JButton jbtnC = new JButton("Close");
    private JPanel jpnC = new JPanel(new GridLayout(8,1,2,2));
    private JPanel jpnL = new JPanel();
    private JPanel jpnR = new JPanel();
    Container cp;
    ButtonGroup BG = new ButtonGroup();
    public Encrypt(){
        init();
    }
    public void init(){
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnL,BorderLayout.WEST);
        cp.add(jpnR,BorderLayout.EAST);
        jpnC.add(jlbM);
        jpnC.add(jcb);
        jpnC.add(jlbK);
        jpnC.add(jpf);
        jpnC.add(jbtnE);
        jpnC.add(jbtnD);
        jpnC.add(jbtnR);
        jpnC.add(jbtnC);
        jpnL.add(jsL);
        jpnR.add(jsR);
        BG.add(jbtnE);
        BG.add(jbtnD);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Success sc = new Success();
                sc.setVisible(true);
            }
        });
    }
    }
