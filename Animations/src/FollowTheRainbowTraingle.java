
import processing.core.*;

public class FollowTheRainbowTraingle extends PApplet {
	float x, y, shadeR, shadeL;

	public void settings() {
		size(500, 360);
	}

	public void draw() {

		background(0);
		x = 0;
		y = 0;
		colorMode(HSB, 500, 250, 250);

		for (; x < 500; x++) {
			shadeR = abs(mouseX - x);
			stroke(shadeR, 250, 250);
			line(0, y, x, y + 360);

			shadeR += 1;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Follow Rainbow Triangle w Mouse" };
		FollowTheRainbowTraingle animation = new FollowTheRainbowTraingle();
		PApplet.runSketch(processingArgs, animation);
	}

}
