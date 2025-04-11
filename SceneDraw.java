import org.code.theater.*;
import org.code.media.*;

public class SceneDraw extends Scene {

  //instance variables
  private pig[] pigs;
  private String[] images;

  //parameterized constructor
  public SceneDraw(pig[] x, String[] y) {
    pigs = x;
    images = y;
  }

  /**
  * Draws blank background
  * @param - background image
  */
   public void background(String b) {
    drawImage(b, 0, 0, getWidth());
  }

  /**
  * Draws background with one character
  * @param - background image; pig that is drawn
  */
  public void background(String b, pig x) {
    drawImage(b, 0, 0, getWidth());
    drawImage(x.getpi(), x.getX(), x.getY(), 120);
  }

  /**
  * Draws background with two characters
  * @param - background image; pig that is drawn; pig that is drawn
  */
  public void background(String b, pig x, pig z) {
    drawImage(b, 0, 0, getWidth());
    drawImage(x.getpi(), x.getX(), x.getY(), 120);
    drawImage(z.getpi(), z.getX(), z.getY(), 120);
  }

  /**
  * First walk in from the right method
  * @param - pig that walks in
  */
  private void walkinR(pig main) {
    for(int i = 400; i >= 200; i -= 35) {
      background(images[0]);
      main.setX(i);
      drawImage(main.getpi(), main.getX(), main.getY(), 120);
      pause(0.1);
    }
  }

  /**
  * second walk in from the right method
  * @param - pig that walks in; background that is drawn
  */
  private void walkinR(pig main, String background) {
    for(int i = 400; i >= 270; i -= 35) {
      background(background);
      main.setX(i);
      drawImage(main.getpi(), main.getX(), main.getY(), 120);
      pause(0.1);
    }
  }

  /**
  * peppa walk in from the right method after going outside; flips image at the end
  * @param - pig that walks in; pig in the background; background that is drawn
  */
  private void walkinRP(pig main, pig back, String background) {
    for(int i = 400; i >= 0; i -= 35) {
      background(background, back);
      main.setX(i);
      drawImage(main.getpi(), main.getX(), main.getY(), 120);
      pause(0.1);
    }

    main.setFlipped(false);
    background(background, back);
    drawImage(main.getpi(), main.getX(), main.getY(), 120);
  }

  /**
  * Peppa walks in from the left method
  * @param - pig that walks in; pig in the background
  */
  private void walkinL(pig main, pig back) {
    for(int i = 0; i <= 50; i += 35) {
      background(images[0], back);
      main.setX(i);
      drawImage(main.getpi(), main.getX(), main.getY(), 120);
      pause(0.1);
    }
  }

  /**
  * Both pigs walk out to the right, offscreen
  * @param - pig that walks out; second pig that walks out; background that is drawn
  */
  private void walkout(pig main, pig back, String background) {
    for(int i = main.getX(); i < 450; i += 40) {
      background(background);
      main.setX(i);
      back.setX(back.getX() + 40);
      drawImage(main.getpi(), main.getX(), main.getY(), 120);
      drawImage(back.getpi(), back.getX(), back.getY(), 120);
      pause(0.1);
    }
  }

  /**
  * Draws first house scene beginning; changes depending on which pig it is
  * @param - pig that walks in; second pig that walks in
  */
  private void drawHScene(pig main, pig back) {
    if(main.getName().equals("Peppa")) {
      walkinL(main, back);
    } else if(main.getName().equals("George")) {
      walkinR(main);
    }
  }

  /**
  * After both pigs walk into the house; text is displayed
  * @param - First pig in; second pig in
  */
  private void afterin(pig x, pig y) {
    setTextHeight(15);
    drawText("Do you want to go", 60, 210);
    drawText("outside George?", 60, 235);

    pause(0.6);
    drawText("*yes*", 250, 235);
    playSound("oink-40664.wav");
    pause(0.5);
    
    background(images[0], x, y);
  }

  /**
  * After both pigs go outside; text is drawn and images are changed to prepare to throw
  */
  private void outsideT() {
    drawText("Throw the ball George!", 80, 200);
    pause(0.5);
    background(images[1], pigs[0]);
    pigs[1].setBall(false);
    pigs[1].setThrown();
    drawImage(pigs[1].getpi(), pigs[1].getX(), pigs[1].getY(), 120);
  }

  /**
  * Ball throwing animation; runs back and forth once
  * Draws ball image repeatedly
  */
  private void throwBall() {
    int x = 270;
    int y = 295;
    
    for(int i = 0; i < 20; i++) {
      background(images[1], pigs[0], pigs[1]);
      if(i < 10) {
        x -= 18;
        if(i < 5) {
          y -= 13;
        } else {
          y += 17;
        }
      } else {
        x += 20;
        if(i < 15) {
          y -= 17;
        } else {
          y += 13;
        }
      }
      drawImage("pball.png", x, y, 48);
      pause(0.05);
    }
  }

  /**
  * After they throw the ball; wanting to go home
  */
  private void goHome() {
    background(images[1], pigs[0], pigs[1]);
    drawText("I'm bored!", 80, 200);
    drawText("Let's go home.", 80, 220);
    pause(0.8);
    background(images[1], pigs[0], pigs[1]);
  }

  /**
  * Plays entire sequence of scenes
  */
  public void drawScene() {
    background(images[0]);
    drawHScene(pigs[1], pigs[0]);
    drawHScene(pigs[0], pigs[1]);
    afterin(pigs[1], pigs[0]);
    pigs[1].setFlipped(true);
    walkout(pigs[0], pigs[1], images[0]);

    background(images[1]);
    pigs[1].setBall(true);
    walkinR(pigs[1], images[1]);
    pigs[0].setFlipped(true);
    walkinRP(pigs[0], pigs[1], images[1]);
    outsideT();

    throwBall();

    drawImage(images[2], 0, 0, getWidth());
    pause(0.5);
    
    goHome();

    setTextHeight(80);
    drawText("THE END", 30, 120);
  }
  
}