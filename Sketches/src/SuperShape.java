
import processing.core.*;

public class SuperShape extends PApplet {

	public void settings() {
		size(400, 400);
	}

	public void setup() {
		strokeWeight(2);
		colorMode(HSB, 2 * PI, 100, 100);
	}

	public void draw() {
		background(0);
		translate(width / 2, height / 2);

		// Black supershape
		float a = 1, b = 1;
		float m1 = 2, m2 = 12;
		float n1 = 2, n2 = 1, n3 = 1;
		supershape(a, b, m1, m2, n1, n2, n3);

		// Red supershape
		a = 1;
		b = 1;
		m1 = 88;
		m2 = 64;
		n1 = -20;
		n2 = 1;
		n3 = 1;
		supershape(a, b, m1, m2, n1, n2, n3);
	}

	void supershape(float a, float b, float m1, float m2, float n1, float n2, float n3) {
		/*
		 * The loop variable is an angle "theta" that changes from 0 to 2*PI with a very
		 * small increment in each iteration of the loop
		 */

		for (float theta = 0; theta <= 2 * PI; theta += 0.0001) {
			stroke(theta, 100, 100);
			float r = pow(pow(abs(cos((m1 * theta) / 4) / a), n2) + pow(abs(cos((m2 * theta) / 4) / b), n3), (-1 / n1));
			float x = 100 * r * cos(theta);
			float y = 100 * r * sin(theta);
			point(x, y);
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "SuperShape" };
		SuperShape sketch = new SuperShape();
		PApplet.runSketch(processingArgs, sketch);
	}
}
