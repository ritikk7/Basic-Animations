
import processing.core.*;

public class ImageFadeAway extends PApplet {

	PImage img;
	float trans, size = 1, x = 255, y = 255;

	public void settings() {
		size(600, 400);
	}

	public void setup() {
		img = loadImage("src\\data\\meme.jpg");
	}

	public void draw() {
		translate(300, 200);
		background(0);

		scale(size);
		rotate(trans);
		imageMode(CORNERS);
		image(img, -300, -200, 300, 200);
		tint(x, y);
		x -= 2;
		y -= 2;
		trans -= 0.08;

		if (size >= 0)
			size -= 0.01;
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Image Rotation" };
		ImageFadeAway animation = new ImageFadeAway();
		PApplet.runSketch(processingArgs, animation);
	}

}
