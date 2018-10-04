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
        jmb.add(jmF);
        jmb.add(jmT);
        jmb.add(jmG);
        jmb.add(jmH);
        jmG.add(jmiOOXX);
        jmF.add(jmiOpen);
        jmF.add(jmiClose);
        jmF.add(jmiExit);
        jmiExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
    }
}
