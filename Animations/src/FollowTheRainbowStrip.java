
import processing.core.*;

public class FollowTheRainbowStrip extends PApplet {
	float x, y, shadeR, shadeL;

	public void settings() {
		size(360, 100);
	}

	public void draw() {

		background(0);
		x = 0;
		y = 0;
		colorMode(HSB, 360, 250, 250);

		for (; x < 500; x++) {
			shadeR = abs(mouseX - x);
			stroke(shadeR, 250, 250);
			line(x, y, x, y + 100);

			shadeR += 0.75;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Follow Rainbow Strip w Mouse" };
		FollowTheRainbowStrip animation = new FollowTheRainbowStrip();
		PApplet.runSketch(processingArgs, animation);
	}

}
