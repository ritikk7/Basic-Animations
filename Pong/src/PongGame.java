
import processing.core.*;

public class PongGame extends PApplet {

	float Xb, Yb, r, speedX, speedY; // ball location, size, and speed
	float Xp1, Yp1, w, h;
	float Xp2, Yp2; // paddle location, width and height

	boolean isGameOver = false; // when true, just draw the GameOver message and stop the animation loop to end
								// the game
	int score1 = 0, score2 = 0;

	public void settings() {
		size(500, 500);
	}

	public void setup() {

		// initialize ball attributes
		Xb = random(r, width - r);
		Yb = 100;
		r = 15;
		speedX = (random(2, 4));
		speedY = (random(2, 4));

		// initialize paddle attributes
		w = 30;
		h = 8;
		Xp1 = width / 2;
		Yp1 = height - h;

		Xp2 = width / 2;
		Yp2 = 15 + h;

		// hide mouse cursor
		noCursor();
	}

	public void draw() {
		background(0);

		if (!isGameOver) { // play as long as it is not game over

			// DRAW game elements
			// draw Ball
			fill(255);
			noStroke();
			ellipse(Xb, Yb, 2 * r, 2 * r);
			// draw paddle
			stroke(0, 255, 0);
			strokeCap(ROUND);
			strokeWeight(h);
			// p1
			line(Xp1 - w, Yp1, Xp1 + w, Yp1);
			// p2
			line(Xp2 - w, Yp2, Xp2 + w, Yp2);
			// draw score
			fill(255, 0, 0);
			textAlign(LEFT);
			textSize(16);
			text("Player1: " + score1, 5, 15);
			text("Player2: " + score2, width - 90, 15);
			textSize(14);
			textAlign(CENTER);
			text("Press ENTER to exit", width / 2, 15);

			// MOVE game elements
			// move Paddle
			Xp1 = mouseX;
			// move ball
			Xb += speedX;
			Yb += speedY;

			// CHECK for collisions
			// bounce the ball off the two sides and the top edge

			if ((Xb + r) > width || (Xb - r) < 0) {
				speedX = -speedX;
			}

			if ((Yb - r) < 0) {
				speedY = -speedY;
			}

			// if ball lands on the paddle.
			// if the ball is at the bottom edge

			// player1
			if ((Yb + r) > (height - h)) {
				// if ball lands on paddle
				if (Xb > (Xp1 - w) && Xb < (Xp1 + w)) {
					speedY = -speedY;
					speedX += 0.1 * speedX;
					speedY += 0.1 * speedY;
				} else {
					score2++;
					Xb = random(r, width - r);
					Yb = random(90, 110);
					speedX = (random(2, 4));
					speedY = (random(2, 4));
				}
			}

			// for Player 2

			else if ((Yb - r) < (15 + h)) {
				if (Xb > (Xp2 - w) && Xb < (Xp2 + w)) {
					speedY = -speedY;
					speedX += 0.1 * speedX;
					speedY += 0.1 * speedY;
				} else {
					score1++;
					Xb = random(r, width - r);
					Yb = random(90, 110);
					speedX = (random(2, 4));
					speedY = (random(2, 4));
				}
			}

		} else {
			// if game over
			// the GameOver message and stopping the animation
			fill(255, 0, 0);
			textAlign(CENTER);
			textSize(20);
			text("GAME OVER", width / 2, height / 2);
			if (score1 > score2)
				text("PLAYER 1 Wins!!", width / 2, height / 2 + 20);
			else if (score1 < score2)
				text("PLAYER 2 Wins!!", width / 2, height / 2 + 20);
			else
				text("DRAW! BETTER LUCK NEXT TIME", width / 2, height / 2 + 20);
		}
	}

	public void keyPressed() {
		if (keyCode == LEFT)
			Xp2 -= 20;
		else if (keyCode == RIGHT)
			Xp2 += 20;
		else if (keyCode == ENTER)
			isGameOver = true;
	}

	public static void main(String[] args) {
		String[] processingArgs = { "The Classic Pong Game" };
		PongGame game = new PongGame();
		PApplet.runSketch(processingArgs, game);
	}

}
