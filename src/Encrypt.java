import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.WindowAdapter;
        import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Encrypt extends JFrame {
    private JLabel jlbM = new JLabel("Method");
    private JLabel jlbK = new JLabel("Key");
    private JTextArea jaL = new JTextArea("",30,15);
    private JTextArea jaR = new JTextArea("",30,15);
    private JScrollPane jsL = new JScrollPane(jaL);
    private JScrollPane jsR = new JScrollPane(jaR);
    private JTextField jtf = new JTextField();
    private String [] methodstr = {"DES","AES","Caesar","XOR"};
    private JComboBox jcb = new JComboBox(methodstr);
    private JRadioButton jbtnE = new JRadioButton("Encrypt");
    private JRadioButton jbtnD = new JRadioButton("Decrypt");
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmA = new JMenu("About");
    private JMenuItem jmiOpen = new JMenuItem("Open");
    private JMenuItem jmiClose = new JMenuItem("Close");
    private JFileChooser jfc = new JFileChooser();
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
        this.setJMenuBar(jmb);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnL,BorderLayout.WEST);
        cp.add(jpnR,BorderLayout.EAST);
        jmb.add(jmF);
        jmb.add(jmA);
        jmF.add(jmiOpen);
        jmF.add(jmiClose);
        jpnC.add(jlbM);
        jpnC.add(jcb);
        jpnC.add(jlbK);
        jpnC.add(jtf);
        jpnC.add(jbtnE);
        jpnC.add(jbtnD);
        jpnC.add(jbtnR);
        jpnC.add(jbtnC);
        jpnL.add(jsL);
        jpnR.add(jsR);
        BG.add(jbtnE);
        BG.add(jbtnD);
        jbtnR.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jbtnE.isSelected()) {
                    int dataLength = jaL.getText().length();
                    if(dataLength > 0){
                        switch (jcb.getSelectedIndex()){
                            case 0:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtf.getText());
                                    char data [] = jaL.getText().toCharArray();
                                    for(int i = 0 ; i < dataLength; i++){
                                        data[i] = (char) (data[i]+ key);
                                    }
                                    jaR.setText(new String(data));
                                }catch (NumberFormatException exp){
                                    JOptionPane.showMessageDialog(Encrypt.this,"key is not a Number");
                                }catch (Exception exp1){
                                    JOptionPane.showMessageDialog(Encrypt.this,"Error:"+exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                    }
                }
                else if(jbtnD.isSelected()) {
                    int dataLength = jaR.getText().length();
                    if(dataLength > 0){
                        switch (jcb.getSelectedIndex()){
                            case 0:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtf.getText());
                                    char data [] = jaR.getText().toCharArray();
                                    for(int i = 0 ; i < dataLength; i++){
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jaL.setText(new String(data));
                                }catch (NumberFormatException exp){
                                    JOptionPane.showMessageDialog(Encrypt.this,"key is not a Number");
                                }catch (Exception exp1){
                                    JOptionPane.showMessageDialog(Encrypt.this,"Error:"+exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                                break;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(Encrypt.this,"sorry,"+jcb.getSelectedItem()+"not implement yet!");
                    }
                }
            }
        });

        jmiOpen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (jfc.showOpenDialog(Encrypt.this) == JFileChooser.APPROVE_OPTION){
                        jaL.setText("");
                        String str = "";
                        File selectFile = jfc.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        while ((str = bfr.readLine()) != null){
                            jaL.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ioe){
                    JOptionPane.showMessageDialog(Encrypt.this, "Open file error: "
                            +ioe.toString());
                }
            }
        });

        jbtnC.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}

