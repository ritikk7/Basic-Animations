
import processing.core.*;

public class TargetCatcherGame extends PApplet {

	float x, y, r = 15; // ball location and size
	float speedX = 0, speedY = 0; // speed of ball
	float xt, yt, rt = 19; // target location and size
	int score = 0; // keep score

	public void settings() {
		size(200, 200);
	}

	public void setup() {
		textSize(14);
		// ball initially at sketch center
		x = width / 2;
		y = height / 2;
		// target initially at random location within the sketch
		xt = random(rt, width - rt);
		yt = random(rt, height - rt);
		imageMode(CENTER);
		rectMode(CENTER);
	}

	public void draw() {
		background(0);
		// draw score
		fill(255, 0, 0);
		text("Score: " + score, 5, 15);

		// add image
		image(loadImage("src\\data\\bonus.jpg"), x, y, 2 * r, 2 * r);

		// draw target
		stroke(255, 180, 0);
		fill(255, 180, 0, 50);
		rect(xt, yt, 2 * rt, 2 * rt);

		// move ball
		x += speedX;
		y += speedY;

		// bounce ball off sketch edges.
		if (x > width - r || x < r)
			speedX = -speedX;
		if (y > height - r || y < r)
			speedY = -speedY;

		// Check if ball is completely inside target
		if (x + r < xt + rt && x - r > xt - rt && y + r < yt + rt && y - r > yt - rt) {
			score++;
			xt = random(rt, width - r);
			yt = random(rt, height - r);
		}
		// If it does two things:
		// a) increment score
		// b) move target to a new random location

	}

	public void keyPressed() {
		// a) UP decrements speedY by 1, DOWN increments speedY by 1. speedY must stay
		// in the range [-5,5] inclusive.
		if (keyCode == UP)
			speedY = constrain(speedY - 1, -5, 5);
		else if (keyCode == DOWN)
			speedY = constrain(speedY + 1, -5, 5);
		// b) LEFT decrements speedX by 1, RIGHT increments speedX by 1. speedX must
		// stay in the range [-5,5] inclusive.
		if (keyCode == LEFT)
			speedX = constrain(speedX - 1, -5, 5);
		else if (keyCode == RIGHT)
			speedX = constrain(speedX + 1, -5, 5);
		// c) SPACE freezes the ball and places it in the center of the sketch
		if (keyCode == ' ') {
			speedX = 0;
			speedY = 0;
		}
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Target Catcher Game" };
		TargetCatcherGame game = new TargetCatcherGame();
		PApplet.runSketch(processingArgs, game);
	}

}
