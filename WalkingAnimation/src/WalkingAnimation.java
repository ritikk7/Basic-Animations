
import processing.core.*;

public class WalkingAnimation extends PApplet {

	int scn = 0;
	final int W = 64, H = 64; // tile width and height
	PImage bk, platform1, platform2, platform3, doorLeftWall, doorRightWall;
	PImage topDoorL, topDoorR;
	PImage leftWall, wall, rightWall, brokenTop1, brokenTop2, brokenTop3, brokenWall, leftWing, rightWing;PImage flagTop, flagBottom, flagMid;
	PImage flagL, flagR;
	PImage torchL, torchR;
	PImage[] playerWalk;
	float x = 0, y = 684, speedX, speedY, gravity = (float) 0.2;
	int i = 1;
	boolean jumping = true, movingR, movingL;

	public void settings() {
		size(1024, 1024);
	}

	public void setup() {
		frameRate(15);
		bk = loadImage("src\\data\\backgroundCastles.png"); // 512 x 512

		platform1 = loadImage("src\\data\\snowMid.png");// 64 x 64
		platform2 = loadImage("src\\data\\snowCliffRightAlt.png");// 64 x 64
		platform3 = loadImage("src\\data\\snowCenter.png");// 64 x 64

		doorLeftWall = loadImage("src\\data\\medievalTile_175.png");
		doorRightWall = loadImage("src\\data\\medievalTile_177.png");

		topDoorL = loadImage("src\\data\\medievalTile_152.png");
		topDoorR = loadImage("src\\data\\medievalTile_154.png");

		leftWall = loadImage("src\\data\\medievalTile_066.png");
		wall = loadImage("src\\data\\medievalTile_112.png");
		rightWall = loadImage("src\\data\\medievalTile_068.png");
		brokenTop1 = loadImage("src\\data\\medievalTile_040.png");
		brokenTop2 = loadImage("src\\data\\medievalTile_041.png");
		brokenWall = loadImage("src\\data\\medievalTile_063.png");
		brokenTop3 = loadImage("src\\data\\medievalTile_021.png");
		leftWing = loadImage("src\\data\\medievalTile_038.png");
		rightWing = loadImage("src\\data\\medievalTile_039.png");

		flagTop = loadImage("src\\data\\medievalTile_093.png");
		flagMid = loadImage("src\\data\\medievalTile_117.png");
		flagBottom = loadImage("src\\data\\medievalTile_141.png");
		flagL = loadImage("src\\data\\medievalTile_217.png");
		flagR = loadImage("src\\data\\medievalTile_235.png");

		torchL = loadImage("src\\data\\medievalTile_187.png");
		torchR = loadImage("src\\data\\medievalTile_188.png");

	}

	public void draw() {
		switch (scn) {
		case 0:
			scene0();
			break;
		case 1:
			scene1();
			break;
		case 2:
			exit();
			break;
		}
	}

	void scene0() {
		background(0, 0, 60);
		textAlign(CENTER);
		textSize(30);
		text("Hit 'P' to play, 'E' to exit.", 512, 500);
		text("Hit 'M' during gameplay to return to this scene.", 512, 530);
	}

	void scene1() {
		background(bk);

		drawPlayer();
		drawCastle();

		// Jumping
		if (jumping) {
			speedY += (gravity);
			y += speedY;
			if (y > 11 * H)
				jumping = false;
			if (y <= 3 * H)
				y = 3 * H;
		}

		if (movingR)
			speedX = 3;
		else if (movingL)
			speedX = -3;

		// PLayer
		image(playerWalk[i], constrain(x += speedX, 0, 14 * W), constrain(y, 3 * H, 14 * H));
	}

	void drawPlayer() {
		playerWalk = new PImage[5];
		playerWalk[0] = loadImage("src\\data\\character_femaleAdventurer_wide.png"); // 64 x 64
		playerWalk[1] = loadImage("src\\data\\character_femaleAdventurer_walk2.png"); // 64 x 64
		playerWalk[2] = loadImage("src\\data\\character_femaleAdventurer_walk3.png"); // 64 x 64
		playerWalk[3] = loadImage("src\\data\\character_femaleAdventurer_walk4.png"); // 64 x 64
		playerWalk[4] = loadImage("src\\data\\character_femaleAdventurer_walk1.png"); // 64 x 64
	}

	void drawCastle() {
		image(doorLeftWall, 8 * W, 11 * H);
		image(doorRightWall, 9 * W, 11 * H);
		image(doorLeftWall, 8 * W, 12 * H);
		image(doorRightWall, 9 * W, 12 * H); // door
		image(topDoorL, 8 * W, 10 * H);
		image(topDoorR, 9 * W, 10 * H);

		for (int i = 7; i < 13; i++)
			image(leftWall, 6 * W, i * H);
		for (int i = 3; i < 7; i++) // leftWall
			image(wall, 7 * W, i * H);
		for (int i = 8; i < 13; i++)
			image(wall, 7 * W, i * H);
		image(brokenWall, 7 * W, 7 * H);
		image(flagL, 5 * W, 1 * H);

		for (int i = 3; i < 13; i++)
			image(wall, 10 * W, i * H); // RightWall
		for (int i = 7; i < 13; i++)
			image(rightWall, 11 * W, i * H);
		image(flagR, 12 * W, 1 * H);

		for (int i = 3; i < 10; i++)
			image(wall, 8 * W, i * H);
		for (int i = 3; i < 10; i++) // CenterWall
			image(wall, 9 * W, i * H);

		image(brokenTop2, 5 * W, 2 * H);
		image(brokenTop2, 6 * W, 2 * H);
		image(brokenTop2, 8 * W, 2 * H);
		image(brokenTop2, 9 * W, 2 * H);
		image(brokenTop2, 11 * W, 2 * H);
		image(brokenTop2, 12 * W, 2 * H);

		image(brokenTop2, 6 * W, 6 * H);
		image(brokenTop2, 11 * W, 6 * H);

		image(leftWing, 4 * W, 2 * H);
		image(rightWing, 13 * W, 2 * H);

		image(torchL, 7 * W, 8 * H); // torchL
		image(torchR, 10 * W, 8 * H); // torchR

		image(flagTop, 7 * W, 2 * H);
		image(flagBottom, 7 * W, 4 * H); // leftFlag
		image(flagMid, 7 * W, 3 * H);

		image(flagTop, 10 * W, 2 * H);
		image(flagBottom, 10 * W, 4 * H); // rightFlag
		image(flagMid, 10 * W, 3 * H);

		// platforms
		for (int i = 0; i < 16; i++) {
			image(platform1, W * i, 13 * H);
		}

		for (int i = 0; i < 16; i++) {
			image(platform3, W * i, 14 * H);
		}

		for (int i = 0; i < 16; i++) {
			image(platform3, W * i, 15 * H);
		}
	}

	public void keyPressed() {

		if (keyCode == RIGHT) {
			i++;
			movingR = true;
			if (i >= 4) {
				i = 1;
			}
			if (x >= 14 * W)
				x = 14 * W;
		}

		if (keyCode == LEFT) {
			i--;
			movingL = true;
			if (i <= 1) {
				i = 4;
			}
			if (x <= 0)
				x = 0;
		}

		if (key == ' ') {
			jumping = true;
			speedY = -6;
		}
	}

	public void keyReleased() {
		if (keyCode == LEFT || keyCode == RIGHT) {
			speedX = 0;
			i = 0;
			movingL = false;
			movingR = false;
		}

		if (scn == 0) {
			if (key == 'P' || key == 'p')
				scn = 1;
			if (key == 'E' || key == 'e')
				scn = 2;
		}
		if (scn == 1 && (key == 'M' || key == 'm'))
			scn = 0;
	}

	public static void main(String[] args) {
		String[] processingArgs = { "Rainbow Strip" };
		WalkingAnimation sketch = new WalkingAnimation();
		PApplet.runSketch(processingArgs, sketch);
	}

}
