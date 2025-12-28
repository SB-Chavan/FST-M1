package activities;

import java.time.Duration;
import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;


public class ActionsBase {
    private final static PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(finger, 1);
        		swipe.addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()));
        		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));
        		swipe.addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()));
        		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    
    }
    
  
}




