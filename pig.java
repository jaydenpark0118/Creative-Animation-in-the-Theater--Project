import org.code.theater.*;
import org.code.media.*;

public class pig extends Scene{

  //instance variables
  private String name;
  private int xLoc;
  private int yLoc;
  private String pic;
  private boolean hasBall;
  private boolean isFlipped;
  private boolean thrown;

  /**
  * Parameterized constructor
  * @param - name of pig
  */
  public pig(String name) {
    this.name = name;
    pic = setpi();
    hasBall = false;
    isFlipped = false;
    thrown = false;
  }

  /**
  * Returns name of pig
  * @return - name variable
  */
  public String getName() {
    return name;
  }

  /**
  * Returns X of pig
  * @return - xLoc variable
  */
  public int getX() {
    return xLoc;
  }

  /**
  * Returns Y of pig
  * @return - yLoc variable
  */
  public int getY() {
    return yLoc;
  }

  /**
  * Sets name of pig
  * @param - X number to be set
  */
  public void setX(int x) {
    xLoc = x;
  }

  /**
  * Sets name of pig
  * @param - Y number to be set
  */
  public void setY(int y) {
    yLoc = y;
  }

  /**
  * Sets ball status of pig
  * @param - boolean to be set
  */
  public void setBall(boolean x) {
    hasBall = x;
  }

  /**
  * Gets ball status of pig
  * @return - hasBall variable is returned
  */
  public boolean getBall() {
    return hasBall;
  }

  /**
  * Sets flipped status of pig
  * @param - boolean to be set
  */
  public void setFlipped(boolean x) {
    isFlipped = x;
  }

  /**
  * Gets flipped status of pig
  * @return - isFlipped variable is returned
  */
  public boolean getFlipped() {
    return isFlipped;
  }

  /**
  * Sets thrown status of pig to true
  */
  public void setThrown() {
    thrown = true;
  }

  /**
  * Gets thrown status of pig
  * @return - thrown variable is returned
  */
  public boolean getThrown() {
    return thrown;
  }

  /**
  * Sets initial x and y location based on the name
  * @return - original image
  */
  public String setpi() {
    if(getName().equals("Peppa")) {
      setX(50);
      setY(275);
      return "peppa.png";
      
    } else if(getName().equals("George")) {
      setX(200);
      setY(275);
      return "george.png";
      
    }
    return "";
  }

  /**
  * Gets images for pigs; checks for special changes; else, returns normal image
  * @return - image
  */
  public String getpi() {
    if(getName().equals("Peppa") && isFlipped == true) {
      return "peppa2.png";
    } else if(getName().equals("George") && isFlipped == true) {
      if(hasBall == true) {
        return "georgeball.png";
      } else if (thrown == true) {
        return "blankgeorge.png"; 
      } else {
        return "george2.png"; 

      }
    }
      return pic;
    
  }

}