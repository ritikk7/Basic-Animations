
import processing.core.*;

public class SpaceRocket extends PApplet {

	public void settings() {
		size(600, 600);
	}

	public void draw() {

		background(75, 0, 130);

		pushMatrix();

		rotate(-PI / 6);
		translate(-200, 250);

		pushStyle();
		stroke(255);
		for (int i = 0; i < 100; i++) {
			strokeWeight(random(10));
			point(random(-600, 700), random(-600, 600));
		}
		popStyle();

		pushStyle();
		noFill();
		strokeWeight(3);
		stroke(0, 0, 255);
		arc(width / 2, height / 2, 400, 100, PI, 2 * PI);
		arc(width / 2, height / 2, 450, 105, PI, 2 * PI);
		arc(width / 2, height / 2, 500, 110, PI, 2 * PI);
		popStyle();

		pushStyle();
		strokeWeight(2);
		stroke(200, 0, 0);
		fill(100, 0, 0);
		ellipse(width / 2, height / 2, 200, 200);
		popStyle();

		pushStyle();
		noFill();
		strokeWeight(3);
		stroke(0, 0, 255);
		arc(width / 2, height / 2, 400, 100, 0, PI);
		arc(width / 2, height / 2, 450, 105, 0, PI);
		arc(width / 2, height / 2, 500, 110, 0, PI);
		popStyle();

		popMatrix();

		pushMatrix();

		noCursor();
		translate(mouseX, mouseY);

		scale((float) 0.15);

		strokeWeight(3);
		pushStyle();
		fill(0, 220);
		bezier(195, 170, 250, -40, 250, -40, 305, 170);
		quad(195, 170, 305, 170, 340, 455, 160, 455);
		popStyle();

		pushStyle();
		fill(255, 220);
		ellipse(300, 320, 15, 40);// left windows
		ellipse(290, 230, 15, 40);

		ellipse(200, 320, 15, 40);// right windows
		ellipse(210, 230, 15, 40);
		popStyle();

		pushStyle();
		fill(255, 220);
		quad(230, 390, 270, 390, 315, 420, 185, 420);
		popStyle();

		pushStyle();
		fill(0, 220);
		strokeWeight(25);
		strokeCap(ROUND);
		line(390, 470, 390, 300);
		line(475, 480, 475, 335);

		line(110, 470, 110, 300);
		line(25, 480, 25, 335);
		popStyle();

		pushStyle();
		fill(252, 90, 0, 220);
		quad(175, 335, 161, 445, 25, 445, 25, 420);
		quad(500 - 175, 335, 500 - 161, 445, 500 - 25, 445, 500 - 25, 420);
		popStyle();

		popMatrix();
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Rocket in Space" };
		SpaceRocket animation = new SpaceRocket();
		PApplet.runSketch(processingArgs, animation);
	}

}
