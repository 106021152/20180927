import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Success extends JFrame {
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF =new JMenu("File");
    private JMenu jmT = new JMenu("Tool");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmH = new JMenu("Help");
    private JMenuItem jmiOOXX = new JMenuItem("OOXX");
    private JMenuItem jmiEncrypt = new JMenuItem("Encrypt");
    private JMenuItem jmiEncryptF = new JMenuItem("Encrypt File");
    private JMenuItem jmiCodeTable = new JMenuItem("CodeTable");
    private JMenuItem jmiOpen = new JMenuItem("Open");
    private JMenuItem jmiClose = new JMenuItem("Close");
    private JMenuItem jmiExit = new JMenuItem("Exit");
    public Success(){

        init();
    }
    public void init(){
        this.setBounds(100,100,800,600);
        this.setLayout(null);
        this.setJMenuBar(jmb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jmb.add(jmF);
        jmb.add(jmT);
        jmb.add(jmG);
        jmb.add(jmH);
        jmG.add(jmiOOXX);
        jmT.add(jmiEncrypt);
        jmT.add(jmiEncryptF);
        jmT.add(jmiCodeTable);
        jmF.add(jmiOpen);
        jmF.add(jmiClose);
        jmF.add(jmiExit);
        jmiExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiEncrypt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Encrypt ec = new Encrypt();
                ec.setVisible(true);
                Success.this.setVisible(false);
            }
        });
        jmiEncryptF.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptFile ecf = new EncryptFile();
                ecf.setVisible(true);
                Success.this.setVisible(false);
            }
        });
        jmiOOXX.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OOXX ox = new OOXX();
                ox.setVisible(true);
                Success.this.setVisible(false);
            }
        });
        jmiCodeTable.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodeTable ct = new CodeTable();
                ct.setVisible(true);
                Success.this.setVisible(false);
            }
        });
    }
}

