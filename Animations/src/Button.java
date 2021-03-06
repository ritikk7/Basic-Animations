
import processing.core.*;

public class Button extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		frameRate(60);
	}

	public void draw() {
	}

	public void mouseDragged() {
		background(0);
		stroke(255, 255, 0);
		strokeWeight(8);
		fill(255, 0, 0);
		ellipse(mouseX, mouseY, 80, 80);
	}

	public void mouseMoved() {
		background(0);
		stroke(255);
		strokeWeight(4);
		fill(0, 255, 0);
		ellipse(mouseX, mouseY, 80, 80);
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Basic Push Button" };
		Button animation = new Button();
		PApplet.runSketch(processingArgs, animation);
	}

}
