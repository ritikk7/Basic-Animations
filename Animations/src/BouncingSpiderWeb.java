
import processing.core.*;

public class BouncingSpiderWeb extends PApplet {

	float speedX = 2, speedY = 3;
	float x = 150, y = 150, R = 50;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB, 330, 255, 255);
		strokeWeight(2);
		noFill();
	}

	public void draw() {
		background(0);
		// move spider-web
		x += speedX;
		y += speedY;
		translate(x, y);

		// bounce spider-web
		if (x > width - (R + 15) || x < (R + 15))
			speedX = -speedX;
		if (y > height - (R + 15) || y < (R + 15))
			speedY = -speedY;

		// draw spider-web
		for (int i = 0, j = 15; i <= 60; i += 10) {
			stroke(j, 255, 255);
			ellipse(0, 0, 2 * (R - i), 2 * (R - i));
			j += 40;
		}

		float theta = 0;
		for (int i = 0; theta < (2 * PI); theta += (PI) / 6) {
			stroke(i, 255, 255);
			float x1 = (R + 15) * cos(theta), y1 = (R + 15) * sin(theta);
			line(0, 0, x1, y1);
			i += 30;
		}

	}

	public static void main(String[] args) {
		String[] processingArgs = { "Bouncing Spider Web" };
		BouncingSpiderWeb animation = new BouncingSpiderWeb();
		PApplet.runSketch(processingArgs, animation);
	}

}
