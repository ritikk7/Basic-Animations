
import processing.core.*;

public class RainbowStrip extends PApplet {
	float x, y, shade;

	public void settings() {
		size(500, 500);
	}

	public void draw() {
		background(0);
		x = 10;
		y = 200;
		colorMode(HSB, 360, 250, 250);
		shade = 0;

		while (x < 490) {
			stroke(shade, 250, 250);
			line(x, y, x, y + 100);
			x++;
			shade += 0.75;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Rainbow Strip" };
		RainbowStrip sketch = new RainbowStrip();
		PApplet.runSketch(processingArgs, sketch);
	}

}
