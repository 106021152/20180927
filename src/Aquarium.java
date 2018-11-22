import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Aquarium extends JFrame {
    private Timer t1;
    Random rnd = new Random(System.currentTimeMillis());
    ImageIcon icon = new ImageIcon();
    private int x, y, dirflag = 0;
    Container cp;
    ArrayList <Boat> boatArrayList = new ArrayList<Boat>();
    ArrayList <Thread> threads = new ArrayList<Thread>();
    public Aquarium() {
        init();
    }

    public void init() {
        cp = this.getContentPane();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(0,0,800,600);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 32:
                        boatArrayList.add(new Boat());
                        cp.add(boatArrayList.get(boatArrayList.size() - 1));
                        System.out.println(boatArrayList.get(boatArrayList.size() - 1));
                        threads.add(new Thread());
                        threads.get(threads.size() - 1).start();
                }
                System.out.println(boatArrayList.size());
                }
        });
    }
    public class Boat extends JLabel implements Runnable {
        @Override
        public void run() {
            x = rnd.nextInt(800);
            y = rnd.nextInt(600);
            dirflag = rnd.nextInt(4);
            t1 = new Timer((rnd.nextInt(10) + 1) * 100, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("dirflag=" + dirflag);
                    switch (dirflag) {
                        case 0:
                            if (y - 5 > 0) {
                                y -= 5;
                            }else {
                                dirflag = 1;
                            }
                            break;
                        case 1:
                            if (y + 5 < 600) {
                                y += 5;
                            }else {
                                dirflag = 0;
                            }
                            break;
                        case 2:
                            if (x - 5 > 0) {
                                x -= 5;
                            }else {
                                dirflag = 3;
                            }
                            break;
                        case 3:
                            if (x + 5 < 800) {
                                x += 5;
                            }else {
                                dirflag = 2;
                            }
                            break;
                    }
                }
            });
        }
    }
}


