
import processing.core.*;

public class FlyingBird extends PApplet {

	public void settings() {
		size(1000, 500);
	}

	public void draw() {
		colorMode(HSB);
		background(133, 308, 231);
		colorMode(RGB);

		// cloud_left
		pushStyle();
		fill(0, 0, 240);
		stroke(0, 0, 240);
		triangle(0, 125, 0, 250, 400, 250);
		bezier(0, 125, 11, 85, 81, 81, 80, 150);
		bezier(80, 150, 88, 111, 178, 106, 160, 175);
		bezier(160, 175, 157, 132, 266, 111, 240, 200);
		bezier(240, 200, 242, 141, 387, 161, 320, 225);
		bezier(320, 225, 393, 140, 398, 238, 400, 250);
		popStyle();

		// sun
		pushStyle();
		colorMode(HSB);
		stroke(25, 200, 255);
		strokeWeight(5);
		fill(45, 255, 255);
		ellipse(666, 192, 200, 200);
		popStyle();

		// cloud_right
		pushStyle();
		fill(0, 0, 240);
		stroke(0, 0, 240);
		triangle(1000, 150, 1000, 300, 500, 300);
		bezier(1000, 150, 948, 67, 848, 74, 875, 188);
		bezier(875, 188, 838, 44, 720, 163, 750, 225);
		bezier(750, 225, 720, 138, 595, 131, 625, 263);
		bezier(625, 263, 603, 91, 454, 307, 500, 300);
		popStyle();

		// top_cloud
		pushStyle();
		fill(0, 0, 240);
		stroke(0, 0, 240);
		rect(400, 20, 260, 60);
		triangle(300, 80, 400, 20, 400, 80);
		triangle(760, 80, 660, 20, 660, 80);
		bezier(300, 80, 272, 85, 215, -34, 400, 20);
		bezier(760, 80, 815, 15, 812, -24, 660, 20);
		bezier(400, 20, 371, -47, 465, -89, 530, 20);
		bezier(530, 20, 509, 3, 684, -128, 660, 20);
		popStyle();

		// bird
		pushMatrix();
		rotate(-PI / 8);
		pushStyle();
		fill(528, 1, 6);
		triangle(86, 330, 159, 400, 121, 400);// back wing
		bezier(86, 330, 81, 333, 86, 354, 112, 365);
		bezier(102, 351, 102, 355, 89, 374, 133, 384);

		triangle(80, 388, 15, 390, 3, 422);// tail
		popStyle();

		pushStyle();
		fill(266, 119, 51);
		ellipse(100, 400, 120, 50); // bod
		popStyle();

		pushStyle();
		fill(369, 185, 0);
		ellipse(157, 400, 40, 40); // face
		popStyle();

		pushStyle();
		fill(267, 90, 297);
		ellipse(163, 394, 10, 10);// outerEye
		popStyle();

		pushStyle();
		fill(0);
		ellipse(165, 394, 3, 3);// eye
		popStyle();

		pushStyle();
		fill(147, 43, -39);
		triangle(209, 400, 174, 389, 176, 409);// beak
		popStyle();

		pushStyle();
		fill(528, 1, 6);
		triangle(60, 330, 100, 400, 130, 400); // front wing
		bezier(60, 330, 53, 361, 143, 404, 80, 367);
		bezier(94, 375, 40, 306, 87, 427, 114, 402);
		bezier(100, 380, 48, 346, 102, 435, 128, 400);
		popStyle();

		popMatrix();

		// cloud_bottom
		pushStyle();
		fill(0, 0, 240);
		stroke(0, 0, 240);
		bezier(280, 500, 253, 358, 505, 501, 387, 500);
		bezier(383, 500, 407, 280, 561, 501, 485, 500);
		bezier(479, 500, 596, 215, 751, 501, 595, 500);
		bezier(577, 500, 746, 358, 798, 425, 781, 500);
		popStyle();

		pushStyle();
		triangle(350, 300, 390, 330, 400, 330);
		ellipse(420, 350, 120, 60);
		fill(0);
		textAlign(CENTER);
		text("I am so High!", 420, 350);
		popStyle();

	}

	public static void main(String[] args) {
		String[] processingArgs = { "Flying Bird Sketch" };
		FlyingBird sketch = new FlyingBird();
		PApplet.runSketch(processingArgs, sketch);
	}

}
