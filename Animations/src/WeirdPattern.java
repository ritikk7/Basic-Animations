
import processing.core.*;

public class WeirdPattern extends PApplet {

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		strokeWeight(3);
	}

	public void draw() {
		background(mouseX);

		rectMode(CORNERS);
		pushStyle();
		colorMode(HSB);
		fill(0, 200, mouseX);
		rect(50, 50, mouseX, mouseY);
		rect(mouseX, mouseY, 450, 450);
		rect(450, 50, mouseX, mouseY);
		rect(50, 450, mouseX, mouseY);
		popStyle();

		triangle(mouseX - 100, 50, 50, mouseY, mouseX, mouseY);
		triangle(mouseX + 100, 50, mouseX, mouseY, 450, mouseY);
		triangle(mouseX + 100, mouseY, mouseX, 450, 450, 450);
		triangle(mouseX - 100, mouseY, 50, 450, mouseX, 450);

		ellipse(mouseX, mouseY, 60, 60);

		pushStyle();
		bezier(mouseX, mouseY - 30, mouseX + 50, mouseY, mouseX - 50, mouseY, mouseX, mouseY + 30);
		popStyle();

		pushStyle();
		fill(0);
		ellipse(mouseX, mouseY - 15, 10, 10);
		ellipse(mouseX, mouseY + 15, 10, 10);
		popStyle();
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Weird Pattern" };
		WeirdPattern animation = new WeirdPattern();
		PApplet.runSketch(processingArgs, animation);
	}

}
