import javax.swing.*;

public class Fail extends JFrame {
    private JLabel jlb = new JLabel("失敗");
    public Fail(){
        init();
    }
    public void init(){
        this.setBounds(0,0,200,200);
        this.add(jlb);
        jlb.setBounds(0,0,50,50);
    }
}
