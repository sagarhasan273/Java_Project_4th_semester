import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Board1 extends JPanel implements ActionListener{
    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 850;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = (B_HEIGHT*B_WIDTH)/(20*20);
    private final int RANDOM_POS = 30;
    private final int DELAY = 100;

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
    Image waterMelon;
    int count = 0;
    int water_x;
    int water_y;

    Image gameOver, gameOver1;
    JLabel label;
    JButton restart, exit;



    Game obj1;







    public Board1() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new Adapter());
        setBackground(Color.CYAN);
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
                obj1 = new Game();
                obj1.startGamePanel1();
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
        water_x = random*DOT_SIZE;
        random = (int) ((Math.random()) * RANDOM_POS);
        apple_y = random*DOT_SIZE;
        random = (int) ((Math.random()) * RANDOM_POS);
        water_y = random*DOT_SIZE;
    }
    public void loadImages(){

        ImageIcon bigWaterMelon = new ImageIcon("Snake_Game_Project\\water 2.png");
        waterMelon = bigWaterMelon.getImage();

        ImageIcon iib= new ImageIcon("Snake_Game_Project\\body_dot 3.png");
        body = iib.getImage();

        ImageIcon iia= new ImageIcon("Snake_Game_Project\\apple 2.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("Snake_Game_Project\\head_dot 3.png");
        head = iih.getImage();

        ImageIcon iig = new ImageIcon("Snake_Game_Project\\head-bandage_3.png");
        gameOver = iig.getImage();

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
            g.drawImage(apple,apple_x,apple_y,this);
            for(int z =0; z<dots;z++){
                if(z==0){
                    g.drawImage(head,x[0],y[0],this);
                }else{
                    g.drawImage(body,x[z],y[z],this);
                }
            }
            if(count >= 5){
                g.drawImage(waterMelon,water_x,water_y,this);

                if ((y[0] >= water_y && y[0] <= water_y+60) && (x[0] >= water_x && x[0] <= water_x+60)){
                    count = 0;
                    score += 50;
                    label.setText("Score: "+score);
                }
            }

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
            setBackground(Color.white);
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


        // I just change this start




        //end





        if (!inGame) {
            timer.stop();
        }
    }

    private void checkApple() {
        if((x[0]==apple_x) && y[0]==apple_y){
            dots++;
            score+=10;
            count +=1;
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