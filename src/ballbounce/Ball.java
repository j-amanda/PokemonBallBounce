
package ballbounce;

import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;

public class Ball {
    
    int x, y; //starting spot for each ball, it becomes random
    int dx, dy; //the change in x and y, will be between -3 to 3
    BufferedImage ballImage; //what the ball image becomes, will be random
    BufferedImage bulbasaurImg, charmanderImg, pikachuImg, squirtleImg, pokeballImg, eeveeImg; //random selection of pokemon images
    private BufferedImage[] ballTypes = new BufferedImage[4]; //array of previous images
    int randomImg = new Random().nextInt(ballTypes.length); //allows random selectin of ballTypes
    int randomX = new Random().nextInt(500); //chooses random spot for original X of ball
    int randomY = new Random().nextInt(300); //chooses random spot for original Y of ball
    int[] directionInts = {-3, -2, -1, 1, 2, 3}; //ints that change in direction can become
    int randomXDirection = new Random().nextInt(directionInts.length); //allows random selection of directionInts
    int randomYDirection = new Random().nextInt(directionInts.length);
    
    public Ball() {
        this.x = randomX; //makes a random X start
        this.y = randomY; //makes a random Y start
        this.dx = directionInts[randomXDirection]; //starts between -3 to 3
        this.dy = directionInts[randomYDirection]; //starts between -3 to 3
        
        try {
            bulbasaurImg = ImageIO.read(getClass().getResource("images/Bulbasaur.gif"));
            charmanderImg = ImageIO.read(getClass().getResource("images/Charmander.gif"));
            pikachuImg = ImageIO.read(getClass().getResource("images/Pikachu.gif"));
            squirtleImg = ImageIO.read(getClass().getResource("images/Squirtle.gif"));
            
            ballTypes[0] = bulbasaurImg;
            ballTypes[1] = charmanderImg;
            ballTypes[2] = pikachuImg;
            ballTypes[3] = squirtleImg;

        } catch (Exception e) {
            //handle exception
            System.out.println("Problem with one or more of the sprite images! Check Ball class.");
            System.out.println(e);
        }
        
        this.ballImage = ballTypes[randomImg]; //makes the ballImage random
        
    }
    
}
