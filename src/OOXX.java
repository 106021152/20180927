import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OOXX extends JFrame {
    public JButton jbtnStart = new JButton("Start");
    public JButton jbtnReset = new JButton("Reset");
    public JButton jbtnExit = new JButton("Exit");
    public JPanel jpnc = new JPanel(new GridLayout(3, 3, 1, 3));
    public JPanel jpnp = new JPanel(new GridLayout(3, 3, 1, 3));
    public JButton jbtns[][] = new JButton[3][3];
    private Container cp;
    boolean boo = true;

    public OOXX() {
        this.init();
    }

    public void init() {
        this.setBounds(80, 60, 800, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnp, BorderLayout.EAST);
        jpnp.add(jbtnStart);
        jpnp.add(jbtnReset);
        jpnp.add(jbtnExit);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jbtns[i][j] = new JButton();
                jpnc.add(jbtns[i][j]);
                jbtns[i][j].setEnabled(false);
                jbtns[i][j].setFont(new Font(null, Font.BOLD, 60));
                jbtns[i][j].setBackground(new Color(65, 99, 255));
                jbtns[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JButton tmeBtn = (JButton) actionEvent.getSource();
                        if (boo) {
                            tmeBtn.setText("O");
                        } else {
                            tmeBtn.setText("X");
                        }
                        boo = !boo;
                        CheckStat();
                        tmeBtn.setBackground(new Color(255,0,0));
                    }
                });
            }
        }
        jbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = 0 ; i < 3 ; i++){
                    for(int j = 0 ; j < 3 ; j++){
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });
        jbtnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = 0 ; i < 3 ; i++){
                    for(int j = 0 ; j < 3 ; j++){
                        jbtns[i][j].setText("");
                        jbtns[i][j].setEnabled(false);
                        jbtns[i][j].setBackground(new Color(65, 99, 255));
                    }
                }
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Success sc = new Success();
                sc.setVisible(true);
            }
        });
    }
    private void CheckStat() {
        if (jbtns[0][0].getText().equals(jbtns[0][1].getText()) && jbtns[0][0].getText().equals(jbtns[0][2].getText())&& !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText()+"Win");
        }
        else if (jbtns[1][0].getText().equals(jbtns[1][1].getText()) && jbtns[1][0].getText().equals(jbtns[1][2].getText())&& !jbtns[1][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[1][0].getText()+"Win");
        }
        else if (jbtns[2][0].getText().equals(jbtns[2][1].getText()) && jbtns[2][0].getText().equals(jbtns[2][2].getText())&& !jbtns[2][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[2][0].getText()+"Win");
        }
        else if (jbtns[0][0].getText().equals(jbtns[1][0].getText()) && jbtns[0][0].getText().equals(jbtns[2][0].getText())&& !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText()+"Win");
        }
        else if (jbtns[0][1].getText().equals(jbtns[1][1].getText()) && jbtns[0][1].getText().equals(jbtns[2][1].getText())&& !jbtns[0][1].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][1].getText()+"Win");
        }
        else if (jbtns[0][2].getText().equals(jbtns[1][2].getText()) && jbtns[0][2].getText().equals(jbtns[2][2].getText())&& !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][2].getText()+"Win");
        }
        else if (jbtns[0][0].getText().equals(jbtns[1][1].getText()) && jbtns[0][0].getText().equals(jbtns[2][2].getText())&& !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[1][1].getText()+"Win");
        }
        else if (jbtns[0][2].getText().equals(jbtns[1][1].getText()) && jbtns[0][2].getText().equals(jbtns[2][0].getText())&& !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[2][2].getText()+"Win");
        }
    }
}
