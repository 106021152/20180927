import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JPanel jpn = new JPanel(new GridLayout(2,2,1,1));
    private JPanel jpns = new JPanel(new GridLayout(1,3,2,2));
    private JLabel jlbID = new JLabel("ID");
    private JLabel jlbPW = new JLabel("PW");
    private JButton jbtnkey = new JButton("KeyBoard");
    private JButton jbtnlogin = new JButton("Login");
    private JButton jbtnexit = new JButton("Exit");
    private JTextField jtf = new JTextField();
    private JPasswordField jpf = new JPasswordField();
    private Container cp;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 400,frmh = 150;
    public MainFrame(){
        init();
    }
    public void init(){
        cp = this.getContentPane();
        cp.add(jpn,BorderLayout.CENTER);
        cp.add(jpns,BorderLayout.SOUTH);
        jpn.add(jlbID);
        jpn.add(jtf);
        jpn.add(jlbPW);
        jpn.add(jpf);
        jpns.add(jbtnkey);
        jpns.add(jbtnlogin);
        jpns.add(jbtnexit);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(screew/2 - frmw/2 , screeh/2 - frmh/2 , frmw,frmh);
        jbtnkey.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RandomPassword rpd = new RandomPassword();
                rpd.setVisible(true);
            }
        });
        jbtnlogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(new String(jtf.getText()).equals("8712")&& new String(jpf.getPassword()).equals("1212")){
                    Success suc = new Success();
                    suc.setVisible(true);
                    MainFrame.this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null,"帳號或密碼錯誤");
                }
            }
        });
        jbtnexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
    public void setPassWord(String lg){
        jpf.setText(lg);
    }
}



