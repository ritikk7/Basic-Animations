
import processing.core.*;

public class ConstrainedBall extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void draw() {
		background(0);
		float x1 = constrain(mouseX, (int) (0.25 * width + 25), (int) (0.75 * width - 25));
		float y1 = constrain(mouseY, (int) (0.25 * height + 25), (int) (0.75 * height - 25));
		ellipse(x1, y1, 50, 50);

		pushStyle();
		strokeWeight(3);
		stroke(255, 255, 0);
		line(width / 4, height / 4, 3 * width / 4, height / 4);
		line(width / 4, height / 4, width / 4, 3 * height / 4);
		line(3 * width / 4, height / 4, 3 * width / 4, 3 * height / 4);
		line(width / 4, 3 * height / 4, 3 * width / 4, 3 * height / 4);
		popStyle();

		pushStyle();
		strokeWeight(5);
		stroke(0);
		dashes(width / 4, height / 4, 3 * width / 4, height / 4);
		dashes(width / 4, height / 4, width / 4, 3 * height / 4);
		dashes(3 * width / 4, height / 4, 3 * width / 4, 3 * height / 4);
		dashes(width / 4, 3 * height / 4, 3 * width / 4, 3 * height / 4);
		popStyle();
	}

	void dashes(float x1, float y1, float x2, float y2) {
		for (int i = 0; i <= 10; i++) {
			float x = lerp(x1, x2, (i / 10));
			float y = lerp(y1, y2, (i / 10));
			point(x, y);
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Ball Constrained in a Square" };
		ConstrainedBall animation = new ConstrainedBall();
		PApplet.runSketch(processingArgs, animation);
	}

}
