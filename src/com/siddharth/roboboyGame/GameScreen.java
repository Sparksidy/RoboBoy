package com.siddharth.roboboyGame;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.siddharth.framework.Game;
import com.siddharth.framework.Graphics;
import com.siddharth.framework.Image;
import com.siddharth.framework.Input.TouchEvent;
import com.siddharth.framework.Screen;

public class GameScreen extends Screen {

	// Game States
	public static enum GameState {
		Ready, Running, Paused, GameOver, LevelOver, NewLevel
	}

	public static GameState state = GameState.Ready;

	public static int score = 0;

	// Variable Setup
	private static Background bg1, bg2;
	private static Robot robot;
	public static Heliboy hb, hb2, hb3, hb4, hb5, hb6, hb7, hb8, b1, b2, b3;
	public static Coin c1, c2, c3, c4, c5, c6;

	private Image currentSprite, character, character2, character3, heliboy,
			heliboy2, heliboy3, heliboy4, heliboy5, bird, bird2, bird3, bird4,
			level1, coin1, coin2, coin3, coin4, coin5;

	private Animation anim, hanim, banim, canim;

	private ArrayList tilearray = new ArrayList();

	public static int livesLeft = 3;
	Paint paint, paint2;

	public static boolean levelover = false; 

	public GameScreen(Game game) {
		super(game);

		bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);
		robot = new Robot();

		hb = new Heliboy(340, 360);
		hb2 = new Heliboy(700, 360);
		hb3 = new Heliboy(1000, 360);
		hb4 = new Heliboy(1400, 360);
		hb5 = new Heliboy(1900, 160);
		hb6 = new Heliboy(2500, 260);

		b1 = new Heliboy(3500, 340);
		b2 = new Heliboy(4000, 320);
		b3 = new Heliboy(4300, 320);

		c1 = new Coin(500, 340);
		c2 = new Coin(900, 280);
		c3 = new Coin(1600, 160);
		c4 = new Coin(2000, 160);
		c5 = new Coin(2800, 260);
		c6 = new Coin(4200, 260);

		character = Assets.character;
		character2 = Assets.character2;
		character3 = Assets.character3;

		heliboy = Assets.heliboy;
		heliboy2 = Assets.heliboy2;
		heliboy3 = Assets.heliboy3;
		heliboy4 = Assets.heliboy4;
		heliboy5 = Assets.heliboy5;

		bird = Assets.bird;
		bird2 = Assets.bird2;
		bird3 = Assets.bird3;
		bird4 = Assets.bird4;

		coin1 = Assets.coin1;
		coin2 = Assets.coin2;
		coin3 = Assets.coin3;
		coin4 = Assets.coin4;
		coin5 = Assets.coin5;

		anim = new Animation();
		anim.addFrame(character, 1250);
		anim.addFrame(character2, 50);
		anim.addFrame(character3, 50);
		anim.addFrame(character2, 50);

		hanim = new Animation();
		hanim.addFrame(heliboy, 100);
		hanim.addFrame(heliboy2, 100);
		hanim.addFrame(heliboy3, 100);
		hanim.addFrame(heliboy4, 100);
		hanim.addFrame(heliboy5, 100);
		hanim.addFrame(heliboy4, 100);
		hanim.addFrame(heliboy3, 100);
		hanim.addFrame(heliboy2, 100);

		banim = new Animation();
		banim.addFrame(bird, 100);
		banim.addFrame(bird2, 100);
		banim.addFrame(bird3, 100);
		banim.addFrame(bird4, 100);
		banim.addFrame(bird, 100);
		banim.addFrame(bird2, 100);
		banim.addFrame(bird3, 100);
		banim.addFrame(bird4, 100);

		canim = new Animation();
		canim.addFrame(coin1, 100);
		canim.addFrame(coin2, 100);
		canim.addFrame(coin3, 100);
		canim.addFrame(coin4, 100);
		canim.addFrame(coin5, 100);
		canim.addFrame(coin1, 100);
		canim.addFrame(coin2, 100);
		canim.addFrame(coin3, 100);
		canim.addFrame(coin4, 100);

		currentSprite = anim.getImage();

		loadMap();

		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);

		paint2 = new Paint();
		paint2.setTextSize(75);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);

	}

	private void loadMap() {
		ArrayList lines = new ArrayList();
		int width = 0;
		int height = 0;

		Scanner scanner = new Scanner(SampleGame.map);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			if (line == null) {
				break;
			}
			if (!line.startsWith("!")) {
				lines.add(line);
				width = Math.max(width, line.length());
			}
		}

		height = lines.size();

		for (int j = 0; j < 12; j++) {
			String line = (String) lines.get(j);
			for (int i = 0; i < width; i++) {
				if (i < line.length()) {
					char ch = line.charAt(i);
					Tile t = new Tile(i, j, Character.getNumericValue(ch));
					tilearray.add(t);
				}
			}
		}

	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		List touchEvents = game.getInput().getTouchEvents();

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
		if (state == GameState.LevelOver)
			updateRunningLevelOver(touchEvents, deltaTime);

	}

	private void updateRunningLevelOver(List touchEvents, float deltaTime) {
		// TODO Auto-generated method stub
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = (TouchEvent) touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					levelover = true;
					game.setScreen(new Level2(game));

				}
			}
		}

	}

	private void updateGameOver(List touchEvents) {
		// TODO Auto-generated method stub

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = (TouchEvent) touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					state=GameState.Ready;
				}
			}
		}
	}

	private void updatePaused(List touchEvents) {
		// TODO Auto-generated method stub
		Assets.theme.pause();
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = (TouchEvent) touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {
					if (!inBounds(event, 0, 0, 35, 35)) {
						Assets.theme.play();
						resume();
					}

				}
				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}

	}

	private void updateRunning(List touchEvents, float deltaTime) {
		// TODO Auto-generated method stub

		// Input Handling
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = (TouchEvent) touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 285, 65, 65)) {
					robot.jump();
					currentSprite = anim.getImage();
					robot.setDucked(false);

				} else if (inBounds(event, 0, 350, 65, 65)) {
					if (robot.isDucked() == false && robot.isJumped() == false
							&& robot.isReadyToFire()) {
						robot.shoot();
					}
				} else if (inBounds(event, 0, 415, 65, 65)
						&& robot.isJumped() == false) {
					currentSprite = Assets.characterDown;
					robot.setDucked(true);
					robot.setSpeedX(0);

				}

				if (event.x > 400) {
					// Move Right

					robot.moveRight();
					robot.setMovingRight(true);

				}

			}

			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 415, 65, 65)) {
					currentSprite = anim.getImage();
					robot.setDucked(false);

				}
				if (inBounds(event, 0, 0, 35, 35)) {
					pause();

				}
				if (event.x > 400) {
					robot.stopRight();
				}

			}

		}

		if (livesLeft == 0) {
			livesLeft = 3;
			score = 0;
			state = GameState.GameOver;

		}

		robot.update();

		if (robot.isJumped()) {
			currentSprite = Assets.characterJump;
		} else if (robot.isJumped() == false && robot.isDucked() == false) {
			currentSprite = anim.getImage();
		}

		// Bullets of Robo
		ArrayList projectiles = robot.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			if (p.isVisible() == true) {
				p.update();
			} else {
				projectiles.remove(i);
			}
		}

		// Update Everything
		updateTiles();

		// Coin Updates
		c1.coin_update();
		c2.coin_update();
		c3.coin_update();
		c4.coin_update();
		c5.coin_update();
		c6.coin_update();

		if (robot.done) {
			state = GameState.LevelOver;
			levelover = true;
			score = 0;
		}

		b1.update();
		if (b1.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		b2.update();
		if (b2.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		b3.update();
		if (b3.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}

		hb.update();
		if (hb.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		hb2.update();
		if (hb2.collided) {

			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		hb3.update();
		if (hb3.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}

		hb4.update();
		if (hb4.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		hb5.update();
		if (hb5.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}
		hb6.update();
		if (hb6.collided) {
			livesLeft -= 1;
			game.setScreen(new GameScreen(game));

		}

		bg1.update();
		bg2.update();
		animate();

		if (robot.getCenterY() > 500) {
			state = GameState.GameOver;
			score = 0;
		}

	}

	private void updateReady(List touchEvents) {
		// TODO Auto-generated method stub
		if (touchEvents.size() > 0)
			state = GameState.Running;
	}

	private void updateTiles() {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub

		Graphics g = game.getGraphics();

		g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
		g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
		paintTiles(g);
		g.drawString("Score  " + score, 650, 30, paint);
		g.drawString("Lives  " + livesLeft, 100, 30, paint);

		// Bullets of Robo
		ArrayList projectiles = robot.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			g.drawRect(p.getX(), p.getY(), 10, 5, Color.YELLOW);
		}

		// First draw the game elements.
		g.drawImage(currentSprite, robot.getCenterX() - 61,
				robot.getCenterY() - 63);
		g.drawImage(hanim.getImage(), hb.getCenterX() - 48,
				hb.getCenterY() - 48);
		g.drawImage(hanim.getImage(), hb2.getCenterX() - 48,
				hb2.getCenterY() - 48);
		g.drawImage(hanim.getImage(), hb3.getCenterX() - 48,
				hb3.getCenterY() - 48);
		g.drawImage(hanim.getImage(), hb4.getCenterX() - 48,
				hb4.getCenterY() - 48);
		g.drawImage(hanim.getImage(), hb5.getCenterX() - 48,
				hb5.getCenterY() - 48);
		g.drawImage(hanim.getImage(), hb6.getCenterX() - 48,
				hb6.getCenterY() - 48);
		g.drawImage(banim.getImage(), b1.getCenterX() - 48,
				b1.getCenterY() - 48);
		g.drawImage(banim.getImage(), b2.getCenterX() - 48,
				b2.getCenterY() - 48);
		g.drawImage(banim.getImage(), b3.getCenterX() - 48,
				b3.getCenterY() - 48);
		g.drawImage(canim.getImage(), c1.getCenterX(), c1.getCenterY());
		g.drawImage(canim.getImage(), c2.getCenterX(), c2.getCenterY());
		g.drawImage(canim.getImage(), c3.getCenterX(), c3.getCenterY());
		g.drawImage(canim.getImage(), c4.getCenterX(), c4.getCenterY());
		g.drawImage(canim.getImage(), c5.getCenterX(), c5.getCenterY());
		g.drawImage(canim.getImage(), c6.getCenterX(), c6.getCenterY());

		// g.drawRect(c1.r1.left, c1.r1.top,c1.r1.right,c1.r1.bottom,
		// Color.BLUE);
		// g.drawRect(robot.rect4.left, robot.rect4.top,robot.rect4.right
		// ,robot.rect4.bottom , Color.GRAY);
		// Example:
		// g.drawImage(Assets.background, 0, 0);
		// g.drawImage(Assets.character, characterX, characterY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();
		if (state == GameState.LevelOver)
			drawLevelOverUI();

	}

	private void paintTiles(Graphics g) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			if (t.type != 0) {
				g.drawImage(t.tileImage, t.getTileX(), t.getTileY());
			}
		}
	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("LEVEL 1", 400, 240, paint);
	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();

		g.drawImage(Assets.button, 0, 285, 0, 0, 65, 65);
		g.drawImage(Assets.button, 0, 350, 0, 65, 65, 65);
		g.drawImage(Assets.button, 0, 415, 0, 130, 65, 65);
		g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);

	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 290, paint2);
	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("Never Give Up", 400, 240, paint2);
		g.drawString("Tap again! ", 400, 290, paint);

	}

	public void drawLevelOverUI() {
		Graphics g = game.getGraphics();

		g.drawRect(0, 0, 1281, 801, Color.GRAY);
		g.drawString("Level Complete! ", 400, 240, paint2);
		g.drawString("Congo Pongo! ", 400, 320, paint);
		// g.drawImage(level1, 0, 0);

	}

	public void animate() {
		anim.update(10);
		hanim.update(50);
		banim.update(10);
		canim.update(10);
	}

	private void nullify() {
		// Set all variables to null. You will be recreating them in the
		// constructor.
		paint = null;
		bg1 = null;
		bg2 = null;
		robot = null;
		hb = null;
		hb2 = null;
		hb3 = null;
		hb4 = null;
		hb5 = null;
		hb6 = null;
		b1 = null;
		b2 = null;
		b3 = null;
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		c5 = null;
		c6 = null;

		currentSprite = null;
		character = null;
		character2 = null;
		character3 = null;
		heliboy = null;
		heliboy2 = null;
		heliboy3 = null;
		heliboy4 = null;
		heliboy5 = null;
		bird = null;
		bird2 = null;
		bird3 = null;
		bird4 = null;
		coin1 = null;
		coin2 = null;
		coin3 = null;
		coin4 = null;
		coin5 = null;

		anim = null;
		hanim = null;
		banim = null;
		canim = null;

		// Call garbage collector to clean up memory.
		System.gc();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if (state == GameState.Running)
			state = GameState.Paused;
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		if (state == GameState.Paused)
			state = GameState.Running;

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub
		pause();
	}

	private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));

	}

	public static Background getBg1() {
		// TODO Auto-generated method stub
		return bg1;
	}

	public static Background getBg2() {
		// TODO Auto-generated method stub
		return bg2;
	}

	public static Robot getRobot() {
		// TODO Auto-generated method stub
		return robot;
	}

}
