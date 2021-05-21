
import processing.core.*;

public class SpiralAnimation extends PApplet {

	float x1, y1, x2, y2;

	// attributes of the two circles - change to get differnt outputs
	float r1 = 120, r2 = 160;
	float theta1 = 0, theta2 = PI / 4;
	float speedTh1 = PI / 35, speedTh2 = (float) (PI / 57.5);

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		background(0);
		stroke(255, 255, 0, 50); // line color
		fill(255); // text color
		text("INNER Radius = " + r1 + "  Speed Theta 1 =  PI / " + PI / speedTh1, 10, 15);
		text("OUTER Radius = " + r2 + "  Speed Theta 2:  PI / " + PI / speedTh2, 10, 30);
	}

	public void draw() {
		// [+2] move the origin to the center of the sketch
		translate(width / 2, height / 2);

		// [+4] compute (x1,y1) and (x2,y2) using r and theta (circle equations)
		x1 = r2 * cos(theta2);
		y1 = r2 * sin(theta2);
		x2 = r1 * cos(theta1);
		y2 = r1 * sin(theta1);

		// [+1] draw a line between (x1,y1) and (x2,y2)
		line(x1, y1, x2, y2);

		// [+8] animate theta1 and theta2
		theta1 += speedTh1;
		theta2 += speedTh2;
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Yellow Spiral Animation" };
		SpiralAnimation animation = new SpiralAnimation();
		PApplet.runSketch(processingArgs, animation);
	}

}
