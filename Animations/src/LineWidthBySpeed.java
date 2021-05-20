
import processing.core.*;

public class LineWidthBySpeed extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		background(255);
		stroke(0);
		frameRate(30);
	}

	public void draw() {
		float speed = abs((((mouseX - pmouseX) ^ 2 + (mouseY - pmouseY) ^ 2) ^ 1 / 2) / frameRate);
		strokeWeight(speed);
		line(pmouseX, pmouseY, mouseX, mouseY);
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Line Width changes w Speed" };
		LineWidthBySpeed animation = new LineWidthBySpeed();
		PApplet.runSketch(processingArgs, animation);
	}

}
