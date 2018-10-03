import javax.swing.*;

public class Success extends JFrame {
    private JLabel jlb = new JLabel("成功");
    public Success(){
        init();
    }
    public void init(){
        this.setBounds(0,0,200,200);
        this.add(jlb);
        jlb.setBounds(0,0,50,50);
    }
}
