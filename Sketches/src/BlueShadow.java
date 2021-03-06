
import processing.core.*;

public class BlueShadow extends PApplet {
	float x, y, d;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		background(0);
	}

	public void draw() {
		x = 250;
		y = 250;
		d = 500;
		noStroke();
		colorMode(HSB, 255, 100, 100);
		int counter = 0;
		int bright = 0;

		while (counter <= 500 && d > 0) {
			fill(184, 100, bright);
			ellipse(x, y, d += 10, d -= 21);
			counter++;
			bright += 3;
		}

	}

	public static void main(String[] args) {
		String[] processingArgs = { "Blue Shadow" };
		BlueShadow sketch = new BlueShadow();
		PApplet.runSketch(processingArgs, sketch);
	}

}
