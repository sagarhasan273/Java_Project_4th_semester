import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game {
    JFrame f, f1;
    JButton button1, button2, button3;
    JLabel jLabel, titlepanel; JPanel p;
    Board1 board1=new Board1();
    Board2 board2=new Board2();
    Board3 board3=new Board3();

    Game(){
        f = new JFrame();
        f.setSize(700,700);
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GREEN);
        p.setSize(700,700);
        f.add(p);

        Icon labelIcon = new ImageIcon("Snake_Game_Project\\Select Your Mode.png");
        jLabel = new JLabel(labelIcon);
        jLabel.setBounds(140,400,421,72);
        p.add(jLabel);

        Icon mainTitle = new ImageIcon("Snake_Game_Project\\maintitle1.png");
        titlepanel = new JLabel(mainTitle);
        titlepanel.setBounds(-1,0,700,366);
        p.add(titlepanel);

        Icon easyIcon = new ImageIcon("Snake_Game_Project\\easy2.png");
        button1 = new JButton(easyIcon);
        button1.setForeground(Color.black);
        button1.setBounds(50+28,500,128,70);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGamePanel1();
            }
        });


        Icon mediumIcon = new ImageIcon("Snake_Game_Project\\medium2.png");
        button2 = new JButton(mediumIcon);
        button2.setBounds(200+28,500,205,70);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGamePanel2();
            }
        });
        button2.setBackground(Color.black);


        Icon hardIcon = new ImageIcon("Snake_Game_Project\\hard2.png");
        button3 = new JButton(hardIcon);
        button3.setBounds(430+28,500,160,70);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGamePanel3();
            }
        });
        button3.setBackground(Color.black);


        p.add(button1);p.add(button2);p.add(button3);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);

        ImageIcon icon= new ImageIcon("Snake_Game_Project\\Snake icon 1.png");
        Image Iicon = icon.getImage();
        f.setIconImage(Iicon);
        f.setTitle("Snake Beta");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1 = new JFrame("Snake Beta");
    }

    public void startGamePanel3() {
        f.setVisible(false);
        f1 = new JFrame();
        f1.setTitle("Snake Game");
        f1.setResizable(false);
        f1.add(board3);
        f1.setSize(1000,850);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGamePanel2() {
        f.setVisible(false);
        f1 = new JFrame();
        f1.setTitle("Snake Game");
        f1.setResizable(false);
        f1.add(board2);
        f1.setSize(1000,850);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGamePanel1() {
        f.setVisible(false);
        f1 = new JFrame();
        f1.setTitle("Snake Game");
        f1.setResizable(false);
        f1.add(board1);
        f1.setSize(1000,850);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Game();

    }
}