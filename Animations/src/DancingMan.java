
import processing.core.*;

public class DancingMan extends PApplet {

	float x, y;

	public void settings() {
		size(500, 500);
	}

	public void draw() {
		background(0);
		stroke(255);
		strokeWeight(4);
		noFill();
		x = map(mouseX, 0, width, (float) (width * 0.45), (float) (width * 0.55));
		y = map(mouseY, 0, height, (float) (height * 0.3), (float) (height * 0.4));
		ellipse(x, y, 90, 90);
		bezier(470, 75, mouseX, mouseY, width - mouseX, height - mouseY, 135, 455);
		bezier(30, 75, mouseX, mouseY, width - mouseX, height - mouseY, 365, 455);

		// Sharingan
		pushMatrix();

		translate(x, y);
		scale((float) 0.35);

		ellipse(-40, -20, 60, 60);
		bezier(-40, 195 - 245, -90, 225 - 245, 10, 225 - 245, -40, 255 - 245);
		ellipse(250 - 290, 210 - 245, 10, 10);
		ellipse(250 - 290, 240 - 245, 10, 10);

		ellipse(40, -20, 60, 60);
		bezier(-40 + 80, 195 - 245, -90 + 80, 225 - 245, 10 + 80, 225 - 245, -40 + 80, 255 - 245);
		ellipse(250 - 290 + 80, 210 - 245, 10, 10);
		ellipse(250 - 290 + 80, 240 - 245, 10, 10);

		ellipse(0, 70, x - 150, y - 150);

		popMatrix();

		stroke(255);
		strokeWeight(1);

		pushStyle();
		colorMode(HSB, 500, 10, 10);
		pushStyle();
		fill(mouseX - 100, mouseX, mouseY, 100);
		ellipse(width - mouseX, height - mouseY, mouseY, mouseY);
		ellipse(mouseX, mouseY, mouseY, mouseY);
		popStyle();

		pushStyle();
		fill(mouseX + 100, mouseX, mouseY, 100);
		ellipse(width - mouseX, mouseY, mouseY, mouseY);
		ellipse(mouseX, height - mouseY, mouseY, mouseY);
		popStyle();
		popStyle();
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Dancing Man w Colour Lights" };
		DancingMan animation = new DancingMan();
		PApplet.runSketch(processingArgs, animation);
	}

}
