package ballbounce;

import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BallPanel extends JPanel {

    private ArrayList<Ball> ballArray = new ArrayList<>(); //ArrayList allows manipulation; adds balls to array
    private BufferedImage background; //stores the background image
    private int delay = 10; //delay of 10 is what I found to look nicest
    protected Timer timer = new Timer(delay, new TimerListener()); //uses TimerListener, basically repaints the screen

    public BallPanel() {
        timer.start();
    }

    public class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            repaint(); //repaints the screen continuously when timer is going
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            background = ImageIO.read(getClass().getResource("images/Background.png"));
        } catch (Exception e) {
            System.out.println("Problem with the Ball Panel background! Check BallPanel class.");
            System.out.println(e);
        }
        g.drawImage(background, 0, 0, null); //draws the background
        
        for (Ball ball : ballArray) { //for each ball in ballArray, do this:
            BufferedImage image = ball.ballImage;

            //changes ball direction if it goes beyond the bounds:
            if (ball.x < 0 || ball.x > getWidth() - 42) { //42 because most sprites are 42px wide
                ball.dx = -ball.dx;
            }

            if (ball.y < 0 || ball.y > getHeight() - 40) { //40 because most sprites are around 40px tall
                ball.dy = -ball.dy;
            }

            ball.x += ball.dx;
            ball.y += ball.dy;
            g.drawImage(image, ball.x, ball.y, null); //draw the actual ball
        }//end for loop
    }

    //button functionality: 
    public void add() {
        ballArray.add(new Ball()); //adds a new ball to the array
    }

    public void subtract() {
        if (ballArray.size() > 0) {
            ballArray.remove(ballArray.size() - 1); //subtract one ball from array
         System.out.println(ballArray.get(ballArray.size() - 1));
        }
    }

    public void start() { //start the timer
        timer.start();
    }

    public void pause() { //stop the timer
        timer.stop();
    }

    
    public void clear() {
        if (ballArray.size() > 0) { 
            ballArray.clear(); //clear the array
        }
    }
}
