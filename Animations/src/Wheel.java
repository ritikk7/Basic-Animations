
import processing.core.*;

public class Wheel extends PApplet {

	float x = 0, dr = 0;

	public void settings() {
		size(1500, 500);
	}

	public void draw() {
		pushStyle();
		colorMode(HSB, 1500, 1000, 1000);
		background(mouseX, mouseX, mouseX);
		popStyle();
		colorMode(RGB);
		translate(x, 250);
		x = x + mouseX / 100;
		dr = dr + mouseX / 100;
		if (x >= 1500) {
			x = 0;
		}

		pushStyle();
		pushMatrix();
		stroke(255, 255, 0);
		strokeWeight(mouseX / 100);
		rotate(x);

		line(-450, -50, -400, -100);
		line(-400, -100, -350, -50);
		line(-350, -50, -300, -100);
		line(-300, -100, -250, -50);
		line(-250, -50, -200, -100);

		line(-450, 50, -400, 0);
		line(-400, 0, -350, 50);
		line(-350, 50, -300, 0);
		line(-300, 0, -250, 50);
		line(-250, 50, -200, 0);

		line(-450, 150, -400, 100);
		line(-400, 100, -350, 150);
		line(-350, 150, -300, 100);
		line(-300, 100, -250, 150);
		line(-250, 150, -200, 100);
		popStyle();
		popMatrix();

		pushMatrix();

		rotate(radians(dr));

		pushStyle();
		strokeWeight(4);
		stroke(0, 0, 255);
		fill(0, 0, 200);
		ellipse(0, 0, 300, 300);
		fill(0);
		ellipse(0, 0, 250, 250);
		popStyle();

		noFill();
		stroke(0, 255, 0);
		strokeWeight(4);

		rotate(PI / 4);
		rect(0, 0, 130, 70);

		rotate(PI / 2);
		rect(0, 0, 130, 70);

		rotate(PI / 2);
		rect(0, 0, 130, 70);

		rotate(PI / 2);
		rect(0, 0, 130, 70);

		stroke(255, 0, 0);
		ellipse(0, 0, 60, 140);

		rotate(PI / 2);
		ellipse(0, 0, 60, 140);

		popMatrix();
	}

	public void keyPressed() {
		x = 0;
		dr = 0;
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Wheel w Variable Speed" };
		Wheel animation = new Wheel();
		PApplet.runSketch(processingArgs, animation);
	}

}
