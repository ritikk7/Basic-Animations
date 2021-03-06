
import processing.core.*;

public class Bubbles extends PApplet {

	float offset = 0;
	float a = 50, b = 50;

	public void settings() {
		size(500, 500);
	}

	public void draw() {
		background(46, 179, 223);
		fill(76, 101, 228, 128);
		stroke(255, 128);
		strokeWeight(2);
		offset -= 0.01;

		float x1 = noise(offset) * width;
		float y1 = (offset * 100) + 500;

		float x2 = noise((float) (offset * 1.1)) * width;
		float y2 = (offset * 100) + 520;

		float x3 = noise((float) (offset * 1.3)) * width;
		float y3 = (offset * 100) + 540;

		float x4 = noise((float) (offset * 1.2)) * width;
		float y4 = (offset * 100) + 480;

		ellipse(x1, y1, a + 5, b + 5);
		ellipse(x2 + 100, y2 + 50, a, b);
		ellipse(x3 - 100, y3, a - 5, b + 5);
		ellipse(x4 - 120, y4, a, b);

		a += 0.25;
		b += 0.25;

		if (y3 <= 0) {
			offset = 0;
			a = 50;
			b = 50;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Bubble Physics" };
		Bubbles animation = new Bubbles();
		PApplet.runSketch(processingArgs, animation);
	}

}
