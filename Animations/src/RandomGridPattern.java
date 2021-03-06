
import processing.core.*;

public class RandomGridPattern extends PApplet {
	int size = 25;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB, 20);
	}

	public void draw() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				fill(random(20));
				rect(j * 25, i * 25, size, size);
			}
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Random Grid Pattern" };
		RandomGridPattern animation = new RandomGridPattern();
		PApplet.runSketch(processingArgs, animation);
	}

}
