package ballbounce;

import javax.swing.JFrame;

/*******************************************************************************
 * 
 * Jordan Davidson
 * 
 * CSIS 1410
 * Project 1 Ball Bounce
 * November 4, 2015
 * 
 * CREDITS *
 * 
 * Pokemon Copywright Nintendo & GameFreak: http://www.pokemon.com/us/
 * 
 * Pokeball Image by MangoTangoFox: http://mangotangofox.deviantart.com/
 * 
 * Pokemon Font by DaFont: http://www.dafont.com/pokemon.font
 * 
 * Pokemon Sprites by Pokemon Shuffle: http://www.pokemonshuffle.com/
 * 
 * Background by Antonio Villaran Lopez: https://www.flickr.com/photos/48021659@N07/
 * 
 * Adaptations from Exercise 18_19.java 
 * 
 ******************************************************************************/

public class BallBounce extends JFrame {

    public BallBounce() {
        add(new BallControl());
    }

    public static void main(String[] args) {
        BallBounce frame = new BallBounce();
        frame.setTitle("Pokemon Ball Bounce!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 475);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
