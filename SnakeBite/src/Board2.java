import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Board2 extends JPanel implements ActionListener{
    final int B_WIDTH = 1000;
    final int B_HEIGHT = 850;
    final int DOT_SIZE = 20;
    final int ALL_DOTS = (B_HEIGHT*B_WIDTH)/(20*20);
    final int RANDOM_POS = 30;
    final int DELAY = 85;

    final int x[] = new int[ALL_DOTS];
    final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;
    int score=0;

    boolean leftDirection = false;
    boolean rightDirection = true;
    boolean upDirection = false;
    boolean downDirection = false;
    boolean inGame = true;

    Timer timer;
    Image body;
    Image apple;
    Image head;
    Image wall;
    Image gameOver, gameOver1;
    JLabel label;
    JButton restart, exit;

    Game obj2;



    public Board2() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new Adapter());
        setBackground(Color.lightGray);
        setFocusable(true);
        setLayout(null);

        label=new JLabel();
        label.setBounds(10,10,100,20);
        add(label);


        //End Panel Button is Here!



        ImageIcon iig = new ImageIcon("Snake_Game_Project\\G.png");
        gameOver1 = iig.getImage();


        Icon restartIcon = new ImageIcon("Snake_Game_Project\\replay.png");
        restart = new JButton(restartIcon);
        restart.setBounds(650,710,260,50);
        restart.setVisible(false);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                obj2 = new Game();
                obj2.startGamePanel2();
            }
        });
        add(restart);



        Icon exitIcon = new ImageIcon("Snake_Game_Project\\exit.png");
        exit = new JButton(exitIcon);
        exit.setBounds(100,710,128,50);
        exit.setVisible(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        add(exit);



        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }
    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 100 + z * 20;
            y[z] = 400;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void locateApple(){
        int random = (int) ((Math.random()) * RANDOM_POS);
        apple_x = random*DOT_SIZE;
        random = (int) ((Math.random()) * RANDOM_POS);
        apple_y = random*DOT_SIZE;
    }
    public void loadImages(){
        ImageIcon iib= new ImageIcon("Snake_Game_Project\\head_dot 1.png");
        body = iib.getImage();

        ImageIcon iia= new ImageIcon("Snake_Game_Project\\apple 2.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("Snake_Game_Project\\head_dot 2.png");
        head = iih.getImage();

        ImageIcon iig = new ImageIcon("Snake_Game_Project\\head-bandage_3.png");
        gameOver = iig.getImage();

        ImageIcon iiw = new ImageIcon("Snake_Game_Project\\wall 4.png");
        wall = iiw.getImage();
    }
    public class Adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if((key == KeyEvent.VK_LEFT) && (!rightDirection)){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if((key == KeyEvent.VK_RIGHT) && (!leftDirection)){
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if((key == KeyEvent.VK_UP) && (!downDirection)){
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
            if((key == KeyEvent.VK_DOWN) && (!upDirection)){
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(inGame){

            // apple locate code
            if ((apple_y >= 40 && apple_y <= 50) && (apple_x >= 300 && apple_x <= 460)){
                locateApple();
            }// done 1
            if ((apple_y >= 20 && apple_y <= 30) && (apple_x >= 520 && apple_x <= 580)){
                locateApple();
            }// done 2
            if ((apple_y >= 40 && apple_y <= 50) && (apple_x >= 680 && apple_x <= 820)){
                locateApple();
            }//done 3
            if ((apple_y >= 620 && apple_y <= 630) && (apple_x >= 140 && apple_x <= 240)){
                locateApple();
            }//done 4
            if ((apple_y >= 620 && apple_y <= 630) && (apple_x >= 360 && apple_x <= 460)){
                locateApple();
            }//done 5
            if ((apple_y >= 80 && apple_y <= 180) && (apple_x >= 60 && apple_x <= 70)){
                locateApple();
            }//done 6
            if ((apple_y >= 240 && apple_y <= 300) && (apple_x >= 60 && apple_x <= 70)){
                locateApple();
            }//done 7
            if ((apple_y >= 200 && apple_y <= 280) && (apple_x >= 440 && apple_x <= 450)){
                locateApple();
            }//done 8
            if ((apple_y >= 200 && apple_y <= 280) && (apple_x >= 400 && apple_x <= 410)){
                locateApple();
            }//done 9
            if ((apple_y >= 580 && apple_y <= 660) && (apple_x >= 800 && apple_x <= 820)){
                locateApple();
            }//done 10
            if ((apple_y >= 220 && apple_y <= 260) && (apple_x >= 800 && apple_x <= 810)){
                locateApple();
            }//done 11
            if ((apple_y >= 300 && apple_y <= 340) && (apple_x >= 800 && apple_x <= 810)){
                locateApple();
            }// done 12
            else{
                g.drawImage(apple,apple_x,apple_y,this);
            }





            // above code locate apple code


            for(int z =0; z<dots;z++){
                if(z==0){
                    g.drawImage(head,x[0],y[0],this);
                }else{
                    g.drawImage(body,x[z],y[z],this);
                }
            }


            // Wall block here.....
            g.drawImage(wall,300,40,this);
            g.drawImage(wall,320,40,this);
            g.drawImage(wall,340,40,this);
            g.drawImage(wall,360,40,this);
            g.drawImage(wall,380,40,this);
            g.drawImage(wall,400,40,this);
            g.drawImage(wall,420,40,this);
            g.drawImage(wall,440,40,this);
            g.drawImage(wall,460,40,this);
            //done 1


            g.drawImage(wall,520,20,this);
            g.drawImage(wall,540,20,this);
            g.drawImage(wall,560,20,this);
            g.drawImage(wall,580,20,this);
            //done 2


            g.drawImage(wall,680,40,this);
            g.drawImage(wall,700,40,this);
            g.drawImage(wall,720,40,this);
            g.drawImage(wall,740,40,this);
            g.drawImage(wall,760,40,this);
            g.drawImage(wall,780,40,this);
            g.drawImage(wall,800,40,this);
            g.drawImage(wall,820,40,this);


            g.drawImage(wall,60,80,this);
            g.drawImage(wall,60,100,this);
            g.drawImage(wall,60,120,this);
            g.drawImage(wall,60,140,this);
            g.drawImage(wall,60,160,this);
            g.drawImage(wall,60,180,this);


            g.drawImage(wall,60,240,this);
            g.drawImage(wall,60,260,this);
            g.drawImage(wall,60,280,this);
            g.drawImage(wall,60,300,this);


            g.drawImage(wall,400,200,this);
            g.drawImage(wall,400,220,this);
            g.drawImage(wall,400,240,this);
            g.drawImage(wall,400,260,this);
            g.drawImage(wall,400,280,this);


            g.drawImage(wall,440,200,this);
            g.drawImage(wall,440,220,this);
            g.drawImage(wall,440,240,this);
            g.drawImage(wall,440,260,this);
            g.drawImage(wall,440,280,this);


            g.drawImage(wall,800,580,this);
            g.drawImage(wall,820,600,this);
            g.drawImage(wall,800,620,this);
            g.drawImage(wall,820,640,this);
            g.drawImage(wall,800,660,this);




            g.drawImage(wall,140,620,this);
            g.drawImage(wall,160,620,this);
            g.drawImage(wall,180,620,this);
            g.drawImage(wall,200,620,this);
            g.drawImage(wall,220,620,this);
            g.drawImage(wall,240,620,this);


            g.drawImage(wall,360,620,this);
            g.drawImage(wall,380,620,this);
            g.drawImage(wall,400,620,this);
            g.drawImage(wall,420,620,this);
            g.drawImage(wall,440,620,this);
            g.drawImage(wall,460,620,this);



            g.drawImage(wall,800,220,this);
            g.drawImage(wall,800,240,this);
            g.drawImage(wall,800,260,this);

            g.drawImage(wall,800,300,this);
            g.drawImage(wall,800,320,this);
            g.drawImage(wall,800,340,this);







            // end here.....



        }
        else{
            label.setVisible(false);
            restart.setVisible(true);
            exit.setVisible(true);
            String s= "Score: ";
            s = s+String.valueOf(score);
            Font small = new Font("Helvetica",Font.BOLD,90);



            g.drawImage(gameOver,(B_WIDTH/7 +100),(B_HEIGHT/2)-290,this);
            g.setColor(Color.RED);


            g.drawImage(gameOver1,120,20,this);
            g.setColor(Color.BLUE);
            g.setFont(small);
            g.drawString(s,(B_WIDTH/2) - 200,(B_HEIGHT/2)+250);
            setBackground(Color.WHITE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkApple();
            move();
            checkCollision();
        }
        repaint();
    }

    private void checkCollision() {
        for(int z=dots;z>0;z--){
            if((z>3) && (x[0] == x[z]) && (y[0] == y[z])){
                inGame = false;
            }
        }
        if(x[0] >= B_WIDTH){
            inGame = false;
        }
        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }





        //collision code
        if ((y[0] >= 40 && y[0] <= 50) && (x[0] >= 300 && x[0] <= 460)){
            inGame = false;
        }// done 1
        if ((y[0] >= 20 && y[0] <= 30) && (x[0] >= 520 && x[0] <= 580)){
            inGame = false;
        }// done 2
        if ((y[0] >= 40 && y[0] <= 50) && (x[0] >= 680 && x[0] <= 820)){
            inGame = false;
        }//done 3
        if ((y[0] >= 620 && y[0] <= 630) && (x[0] >= 140 && x[0] <= 240)){
            inGame = false;
        }//done 4
        if ((y[0] >= 620 && y[0] <= 630) && (x[0] >= 360 && x[0] <= 460)){
            inGame = false;
        }//done 5
        if ((y[0] >= 80 && y[0] <= 180) && (x[0] >= 60 && x[0] <= 70)){
            inGame = false;
        }//done 6
        if ((y[0] >= 240 && y[0] <= 300) && (x[0] >= 60 && x[0] <= 70)){
            inGame = false;
        }//done 7
        if ((y[0] >= 200 && y[0] <= 280) && (x[0] >= 440 && x[0] <= 450)){
            inGame = false;
        }//done 8
        if ((y[0] >= 200 && y[0] <= 280) && (x[0] >= 400 && x[0] <= 410)){
            inGame = false;
        }//done 9
        if ((y[0] >= 580 && y[0] <= 660) && (x[0] >= 800 && x[0] <= 820)){
            inGame = false;
        }//done 10
        if ((y[0] >= 220 && y[0] <= 260) && (x[0] >= 800 && x[0] <= 810)){
            inGame = false;
        }//done 11
        if ((y[0] >= 300 && y[0] <= 340) && (x[0] >= 800 && x[0] <= 810)){
            inGame = false;
        }// done 12

        if (!inGame) {
            timer.stop();
        }
    }

    private void checkApple() {
        if((x[0]==apple_x) && y[0]==apple_y){
            dots++;
            score+=15;
            label.setText("Score: "+score);
            locateApple();
        }
    }
    private void move(){
        for(int z = dots; z>0;z--){
            x[z]= x[z-1];
            y[z] =y[z-1];
        }
        if(leftDirection){
            x[0] -= DOT_SIZE;
        }
        if(rightDirection) {
            x[0] += DOT_SIZE;
        }
        if(upDirection){
            y[0]-= DOT_SIZE;
        }
        if(downDirection){
            y[0]+= DOT_SIZE;
        }
    }
}