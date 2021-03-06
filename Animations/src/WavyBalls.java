
import processing.core.*;

public class WavyBalls extends PApplet {

	// first wave of ships (left to right, sinusoidal path)
	float x1 = 0, y1 = 0, x2 = -50, y2 = 0, x3 = -100, y3 = 0;
	float d1 = 30, d2 = 30, d3 = 30;
	int hue; // colors of first wave of ships
	// second wave of ships (right to left, straight path)
	float x4 = 820, y4 = -50, x5 = 850, y5 = -50;
	// all ships have same speed
	float speedX = 2;

	public void settings() {
		size(800, 200);
	}

	public void setup() {
		rectMode(CENTER);
		colorMode(HSB);
		noCursor();
		hue = 0;
	}

	public void draw() {
		background(0);
		translate(0, height / 2);
		// change color of ships in wave1
		hue = (hue + 1) % 255;
		fill(hue, 255, 255);
		// wave1: ship1
		x1 += speedX;
		y1 = 50 * sin(x1 / width * 6 * PI);
		d1 = random(30, 40);
		ellipse(x1, y1, d1, d1);
		// wave1: ship2
		x2 += speedX;
		y2 = 50 * sin(x2 / width * 6 * PI);
		d2 = random(30, 40);
		ellipse(x2, y2, d2, d2);
		// wave1: ship3
		x3 += speedX;
		y3 = 50 * sin(x3 / width * 6 * PI);
		d3 = random(30, 40);
		ellipse(x3, y3, d3, d3);
		// wave1: reset x of spaceships once they reach far right
		if (x1 > width + d1 / 2)
			x1 = -d1 / 2;
		if (x2 > width + d2 / 2)
			x2 = -d2 / 2;
		if (x3 > width + d3 / 2)
			x3 = -d3 / 2;

		// wave 2: ship4
		fill(126);
		ellipse(x4, y4, 20, 20);
		x4--;
		// wave 2: ship5
		fill(126);
		ellipse(x5, y5, 20, 20);
		x5--;
		// my spaceship
		fill(255);
		rect(mouseX, mouseY - height / 2, 40, 40);
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Wave Motion of Balls" };
		WavyBalls animation = new WavyBalls();
		PApplet.runSketch(processingArgs, animation);
	}

}
