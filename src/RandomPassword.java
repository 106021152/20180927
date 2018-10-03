//鍵盤
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RandomPassword extends JFrame {
    private JButton[] jbtn = new JButton[12];
    private JPanel jpn = new JPanel(new GridLayout(4, 3, 3, 3));
    private JPanel jpnt = new JPanel(new GridLayout(1, 1, 2, 2));
    private JLabel jlb = new JLabel(" ");
    private String[] btnLabel = new String[10];
    private Container cp;
    private Font fon = new Font(null, Font.BOLD, 32);
    private MainFrame frme;
    public RandomPassword() {

        init();
    }
    public void init() {
        cp = this.getContentPane();
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpnt, BorderLayout.NORTH);
        jpnt.add(jlb);
        this.setBounds(600, 300, 500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i < 10; i++) {
            jbtn[i] = new JButton(Integer.toString(i));
            jbtn[i].setFont(fon);
            jpn.add(jbtn[i]);
            jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton jbtn = (JButton) actionEvent.getSource();
                    jlb.setText(jlb.getText() + jbtn.getText());
                }
            });
        }
        jbtn[10] = new JButton("跳");
        jbtn[11] = new JButton("Submit");
        jpn.add(jbtn[10]);
        jpn.add(jbtn[11]);
        jbtn[10].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                genjbtnLabel(btnLabel);
                for(int i = 0 ; i < 10 ; i ++){
                    jbtn[i].setText(btnLabel[i]);
                }
            }
        });
        jbtn[11].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frme.setPassWord(jlb.getText());
                RandomPassword.this.setVisible(false);
            }
        });
    }

    public void genjbtnLabel(String str[]) {
        int i = 0;
        Random rad = new Random(System.currentTimeMillis());
        while (i < 10) {
            btnLabel[i] = Integer.toString(rad.nextInt(10));
            int j = 0;
            boolean boo = false;
            while (j < i) {
                if (btnLabel[i].equals(btnLabel[j])) {
                    boo= true;
                    j=i;
                }
                j++;
            }
            if(!boo){
                i++;
            }
        }
    }
}