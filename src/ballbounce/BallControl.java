package ballbounce;

//adapted from Exercise 18_19.java

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BallControl extends JPanel {

    private BallPanel ballPanel = new BallPanel(); //makes the actual ball bounce pane
    private BufferedImage pauseImage, playImage, minusOneImage, plusOneImage, clearImage; //imgs for buttons

    //buttons for control:
    private JButton pause = new JButton();
    private JButton resume = new JButton();
    private JButton addOne = new JButton();
    private JButton subtractOne = new JButton();
    private JButton clear = new JButton();

    public BallControl() {
        JPanel buttonPanel = new JPanel();
        try { //finds images to put on buttons:
            playImage = ImageIO.read(getClass().getResource("images/play.png"));
            pauseImage = ImageIO.read(getClass().getResource("images/stop.png"));
            minusOneImage = ImageIO.read(getClass().getResource("images/MinusOne.png"));
            plusOneImage = ImageIO.read(getClass().getResource("images/PlusOne.png"));
            clearImage = ImageIO.read(getClass().getResource("images/New.png"));
        } catch (Exception e) {
            System.out.println("Problem with the button images! Check BallControl class.");
            System.out.println(e);
        }

        //adding the images to the buttons:
        pause.setIcon(new ImageIcon(pauseImage));
        resume.setIcon(new ImageIcon(playImage));
        addOne.setIcon(new ImageIcon(plusOneImage));
        subtractOne.setIcon(new ImageIcon(minusOneImage));
        clear.setIcon(new ImageIcon(clearImage));

        //adding the buttons to the buttonPanel:
        buttonPanel.add(resume);
        buttonPanel.add(pause);
        buttonPanel.add(addOne);
        buttonPanel.add(subtractOne);
        buttonPanel.add(clear);

        //add a little flair, color is Pokeball Red:
        ballPanel.setBorder(new javax.swing.border.LineBorder(new Color(178, 7, 0)));
        buttonPanel.setBackground(new Color(178, 7, 0));

        //put the components on the screen
        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add the ActionListeners:
        pause.addActionListener(new Listener());
        resume.addActionListener(new Listener());
        addOne.addActionListener(new Listener());
        subtractOne.addActionListener(new Listener());
        clear.addActionListener(new Listener());

    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) { //methods are in BallPanel class
            if (event.getSource() == pause) {
                ballPanel.pause();
            } else if (event.getSource() == resume) {
                ballPanel.start();
            } else if (event.getSource() == addOne) {
                ballPanel.add();
            } else if (event.getSource() == subtractOne) {
                ballPanel.subtract();
            } else if (event.getSource() == clear) {
                ballPanel.clear();
            }
        }
    }
}
