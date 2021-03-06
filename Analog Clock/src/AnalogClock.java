
import processing.core.*;

public class AnalogClock extends PApplet {
	float x, y, x2, y2;

	public void settings() {
		size(200, 200);
	}

	public void setup() {
		textSize(18);
		textAlign(CENTER, CENTER);
		frameRate(60);
	}

	public void draw() {
		background(0);
		translate(100, 100);

		// draw clock face
		stroke(0, 255, 255);
		fill(8, 1, 75);
		ellipse(0, 0, 195, 195);

		// draw time numbers
		fill(0, 255, 255); // Numbers color
		float angle = -PI / 2;
		for (int i = 12; i >= 1; i--) {
			text(i, 85 * cos(angle), 85 * sin(angle));
			angle -= PI / 6;
		}

		// draw time ticks
		fill(0, 255, 255);
		angle = 0;
		for (int i = 0; i < 60; i++) {
			line(65 * cos(angle), 65 * sin(angle), 70 * cos(angle), 70 * sin(angle));
			angle += PI / 30;
		}

		// draw hours hand
		stroke(255, 0, 0);
		strokeWeight(5);
		float angleleHours = hour() * PI / 6 - PI / 2; // hours * 30 degrees
		x = 40 * cos(angleleHours);
		y = 40 * sin(angleleHours);
		line(0, 0, x, y);

		// draw minutes hand
		stroke(0, 255, 0);
		strokeWeight(2);
		float angleleMin = minute() * PI / 30 - PI / 2; // minutes * 6 degrees
		x = 55 * cos(angleleMin);
		y = 55 * sin(angleleMin);
		line(0, 0, x, y);

		// draw seconds hand

		stroke(255, 255, 0);
		strokeWeight(1);
		float angleleSec = second() * PI / 30 - PI / 2; // seconds * 6 degrees
		x = 70 * cos(angleleSec);
		y = 70 * sin(angleleSec);
		line(0, 0, x, y);
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Analog Clock" };
		AnalogClock clock = new AnalogClock();
		PApplet.runSketch(processingArgs, clock);
	}

}
