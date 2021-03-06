
import processing.core.*;

public class MulticolourLights extends PApplet {

	float r, g, b, a;
	float diam, x, y;

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		background(0);
		smooth();
	}

	public void draw() {
		// Fill all variables with random values
		r = random(255);
		g = random(255);
		b = random(255);
		a = random(128);
		diam = random(40);
		x = random(width);
		y = random(height);
		// Use values to draw an ellipse
		noStroke();
		fill(r, g, b, a);
		ellipse(x, y, diam, diam);
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Multicolour Lights" };
		MulticolourLights animation = new MulticolourLights();
		PApplet.runSketch(processingArgs, animation);
	}

}
