import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    //TAKES REALLY LONG TO RUN
    //background images
    String[] background = {"peppainside3.png", "peppaoutside.png", "10-seconds-later.jpg"};

    //pigs that can be moved
    pig pep = new pig("Peppa");
    pig geo = new pig("George");
    pig[] controlpigs = {pep, geo};

    //scene maker object
    SceneDraw s = new SceneDraw(controlpigs, background);

    //draws scene
    s.drawScene();
    Theater.playScenes(s);
    
  }
}