
import processing.core.*;

public class GradientShading extends PApplet {

	int size = 10;

	public void settings() {
		size(500, 500);
	}

	public void draw() {
		colorMode(RGB, 500);

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				fill((j + i) * 5);
				stroke((j + i) * 5);
				rect(j * 10, i * 10, size, size);
			}
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Gradient Shadowing" };
		GradientShading sketch = new GradientShading();
		PApplet.runSketch(processingArgs, sketch);
	}
}
