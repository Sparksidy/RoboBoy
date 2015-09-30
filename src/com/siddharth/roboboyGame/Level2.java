package com.siddharth.roboboyGame;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;

import com.siddharth.framework.Game;
import com.siddharth.framework.Graphics;
import com.siddharth.framework.Image;
import com.siddharth.framework.Input.TouchEvent;
import com.siddharth.framework.Screen;
import com.siddharth.roboboyGame.GameScreen.GameState;
import com.siddharth.roboboyGame.R;

public class Level2 extends Screen {

	public static Background bg3, bg4;
	private static Robot robot;
	private static Fire fire;

	private Image currentSprite, character, character2, character3,fire1,fire2,fire3,fire4,fire5,pipe2,tree2,police2,end2;
	private Image z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12;
	private Image p1,p2,p3,p4,p5,p6,p7,p8;
	
	public static Zombie zombie,zombie2,zombie3;
	public static Police police1,pol2;
	

	private Animation anim,fanim,zanim,panim;
	
	public Objects pipe,tree,police,end;

	public static GameState state2 = GameState.Ready;

	private ArrayList tilearray = new ArrayList();

	public static int score;
	
	public boolean policeShoot=true ;
	
	public int count=0;
	
	
	Paint paint, paint2;

	public Level2(Game game) {
		super(game);

		bg3 = new Background(0, 0);
		bg4 = new Background(2160, 0);
		
		robot = new Robot();
		
		zombie = new Zombie(700,290);
		zombie2= new Zombie(1600,290);
		zombie3 = new Zombie(6000,290);
		police1 = new Police(2000,290);
		pol2 = new Police(2800,290);
		
		fire = new Fire(2170,423);
		
		pipe = new Objects(205,389);
		tree = new Objects(1200,308);
		police = new Objects(2200,276);
		end = new Objects(5000,380);
		
		score = GameScreen.score;
		
		pipe2=Assets.pipe;
		tree2=Assets.tree;
		police2=Assets.police;
		end2=Assets.end;
		
		z1=Assets.z1;
		z2=Assets.z2;
		z3=Assets.z3;
		z4=Assets.z4;
		z5=Assets.z5;
		z6=Assets.z6;
		z7=Assets.z7;
		z8=Assets.z8;
		z9=Assets.z9;
		z10=Assets.z10;
		z11=Assets.z11;
		z12=Assets.z12;
		
		p1=Assets.police1;
		p2=Assets.police2;
		p3=Assets.police3;
		p4=Assets.police4;
		p5=Assets.police5;
		p6=Assets.police6;
		p7=Assets.police7;
		p8=Assets.police8;
		
		
		
		
		

		character = Assets.character;
		character2 = Assets.character2;
		character3 = Assets.character3;
		
		fire1 = Assets.fire1;
		fire2 = Assets.fire2;
		fire3 = Assets.fire3;
		fire4 = Assets.fire4;
		fire5 = Assets.fire5;
		
		
		

		anim = new Animation();
		anim.addFrame(character, 1250);
		anim.addFrame(character2, 50);
		anim.addFrame(character3, 50);
		anim.addFrame(character2, 50);
		
		fanim = new Animation();
		fanim.addFrame(fire1, 100);
		fanim.addFrame(fire2, 100);
		fanim.addFrame(fire3, 100);
		fanim.addFrame(fire4, 100);
		fanim.addFrame(fire5, 100);
		fanim.addFrame(fire4, 100);
		fanim.addFrame(fire3, 100);
		fanim.addFrame(fire1, 100);
		
		zanim = new Animation();
		zanim.addFrame(z1,50);
		zanim.addFrame(z2,50);
		zanim.addFrame(z3,50);
		zanim.addFrame(z4,50);
		zanim.addFrame(z5,50);
		zanim.addFrame(z6,50);
		zanim.addFrame(z7,50);
		zanim.addFrame(z8,50);
		zanim.addFrame(z9,50);
		zanim.addFrame(z10,50);
		zanim.addFrame(z11,50);
		zanim.addFrame(z12,50);
		zanim.addFrame(z1,50);
		zanim.addFrame(z2,50);
		zanim.addFrame(z3,50);
		zanim.addFrame(z4,50);
		zanim.addFrame(z5,50);
		zanim.addFrame(z6,50);
		zanim.addFrame(z7,50);
		zanim.addFrame(z8,50);
		zanim.addFrame(z9,50);
		zanim.addFrame(z10,50);
		zanim.addFrame(z11,50);
		zanim.addFrame(z12,50);
		
		panim = new Animation();
		panim.addFrame(p1, 50);
		panim.addFrame(p2, 50);
		panim.addFrame(p3, 50);
		panim.addFrame(p4, 50);
		panim.addFrame(p5, 50);
		panim.addFrame(p6, 50);
		panim.addFrame(p7, 50);
		panim.addFrame(p8, 50);
		panim.addFrame(p1, 50);
		panim.addFrame(p2, 50);
		panim.addFrame(p3, 50);
		panim.addFrame(p4, 50);
		panim.addFrame(p5, 50);
		panim.addFrame(p6, 50);
		panim.addFrame(p7, 50);
		
		
		
		

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

		currentSprite = anim.getImage();

	}

	private void loadMap() {
		ArrayList lines = new ArrayList();
		int width = 0;
		int height = 0;
		
		
		
		Scanner scanner = new Scanner(SampleGame.map2);
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
		System.out.println("Map Loaded");
	}

	@Override
	public void update(float deltaTime) {

		List touchEvents = game.getInput().getTouchEvents();

		if (state2 == GameState.Ready)
			updateReady(touchEvents);
		if (state2 == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state2 == GameState.GameOver)
			updateGameOver(touchEvents);
		if (state2 == GameState.LevelOver)
			updateLevelOver(touchEvents, deltaTime);
		if (state2 == GameState.Paused)
			updatePaused(touchEvents);

	}

	private void updateLevelOver(List touchEvents, float deltaTime) {
		// TODO Auto-generated method stub
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = (TouchEvent) touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					state2=GameScreen.GameState.GameOver;

				}
			}
		}

	}

	private void updateReady(List touchEvents) {
		// TODO Auto-generated method stub
		if (touchEvents.size() > 0)
			state2 = GameState.Running;
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
				}
			}
		}
	}

	private void updateRunning(List touchEvents, float deltaTime) {

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
		
		

		robot.update();
		
		if (robot.isJumped()) {
			currentSprite = Assets.characterJump;
		} else if (robot.isJumped() == false && robot.isDucked() == false) {
			currentSprite = anim.getImage();
		}
		
		
		//Bullets of Robo
		ArrayList projectiles = robot.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			if (p.isVisible() == true) {
				p.update();
			} else {
				projectiles.remove(i);
			}
		}
		
		
		
		//Bullets of police
		
		/*if(count==5){

			police1.policeShoot();
			ArrayList projectilespolice = police1.getProjectiles();
			for (int j = 0; j < projectilespolice.size(); j++) {
				Projectile p = (Projectile) projectilespolice.get(j);
				if (p.isVisible() == true) {
					p.update();
				} else {
					projectilespolice.remove(j);
				}
			}
			count++;
	
		}*/
		
		
		// Update Everything
		updateTiles();
		
		zombie.updateZombie();
		if(zombie.collidedToRobot){
			game.setScreen(new Level2(game));
		}
		zombie2.updateZombie();
		if(zombie2.collidedToRobot){
			game.setScreen(new Level2(game));
		}
		zombie3.updateZombie();
		if(zombie3.collidedToRobot){
			game.setScreen(new Level2(game));
		}
		
		police1.police_update();
		if(police1.collidedTobot){
			game.setScreen(new Level2(game));
		}
		pol2.police_update();
		if(pol2.collidedTobot){
			game.setScreen(new Level2(game));
		}
		
		bg3.update();
		bg4.update();
		animate();
		
		fire.fire_update();
		
		if(Projectile.completed2){
			state2=GameState.LevelOver;
		}
		
		
		//Objects update with respect o background
		pipe.obj_update();
		tree.obj_update();
		police.obj_update();
		end.obj_update();

		if (robot.getCenterY() > 500) {
			state2 = GameState.GameOver;
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

	private void updateTiles() {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
		}

	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub 
		Graphics g = game.getGraphics();

		// Background
		g.drawImage(Assets.background2, bg3.getBgX(), bg3.getBgY());
		g.drawImage(Assets.background2, bg4.getBgX(), bg4.getBgY());

		paintTiles(g);

		// Strings
		g.drawString("Score  " + score, 650, 30, paint);
		g.drawString("Lives  " + GameScreen.livesLeft, 100, 30, paint);
		
		
	
		
		
		//Game Objects
		g.drawImage(pipe2, pipe.getCenterX() - 48, pipe.getCenterY() - 48);
		g.drawImage(tree2, tree.getCenterX() - 48,tree.getCenterY() - 48);
		g.drawImage(police2,police.getCenterX() - 48,police.getCenterY() - 48);
		g.drawImage(end2, end.getCenterX() - 48,end.getCenterY() - 48);
		
		//Bullets
		ArrayList projectiles = robot.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			g.drawRect(p.getX(), p.getY(), 10, 5, Color.YELLOW);
		}
		

		// Character
		g.drawImage(currentSprite, robot.getCenterX() - 61,
				robot.getCenterY() - 63);
		// g.drawImage(Assets.character, 200, 300);
		
		
		//Zombies
		//g.drawRect(zombie.r1.left, zombie.r1.top,zombie.r1.right,zombie.r1.bottom, Color.RED);
		g.drawImage(zanim.getImage(), zombie.getCenterX(), zombie.getCenterY());
		g.drawImage(zanim.getImage(), zombie2.getCenterX(), zombie2.getCenterY());
		g.drawImage(zanim.getImage(), zombie3.getCenterX(), zombie3.getCenterY());
		
		//Police
		g.drawImage(panim.getImage(), police1.getCenterX(), police1.getCenterY());
		g.drawImage(panim.getImage(), pol2.getCenterX(), pol2.getCenterY());
		
		/*//Bullets of Police
		ArrayList projectilespolice = police1.getProjectiles();
		for (int i = 0; i < projectilespolice.size(); i++) {
			Projectile p = (Projectile) projectilespolice.get(i);
			g.drawRect((p.getX()),(p.getY()), 10, 5, Color.RED);
		}*/	
		
		//Fire
		g.drawImage(fanim.getImage(), fire.getX() - 48,fire.getY() - 48);
		
	
		

		if (state2 == GameState.Ready)
			drawNewLevelUI();
		if (state2 == GameState.Running)
			drawRunningUI();
		if (state2 == GameState.GameOver)
			drawGameOverUI();
		if (state2 == GameState.LevelOver)
			drawLevelOverUI();
		if (state2 == GameState.Paused)
			drawPausedUI();

	}

	private void paintTiles(Graphics g) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			if (t.type != 0) {
				g.drawImage(t.tileImage, t.getTileX(), t.getTileY());
			}
		}
	}

	public void drawLevelOverUI() {
		Graphics g = game.getGraphics();

		g.drawRect(0, 0, 1281, 801, Color.GRAY);
		g.drawString("Level 2 Complete! ", 400, 240, paint2);
		g.drawString("Congo Pongo! ", 400, 320, paint);
		// g.drawImage(level1, 0, 0);

	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("Try once more! ", 400, 240, paint2);
		g.drawString("Tap to enjoy again! ", 400, 290, paint);

	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 290, paint2);
	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();

		g.drawImage(Assets.button, 0, 285, 0, 0, 65, 65);
		g.drawImage(Assets.button, 0, 350, 0, 65, 65, 65);
		g.drawImage(Assets.button, 0, 415, 0, 130, 65, 65);
		g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);

	}

	public void drawNewLevelUI() {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("LEVEL 2", 400, 240, paint);

	}

	public void animate() {
		anim.update(10);
		fanim.update(10);
		zanim.update(10);
		panim.update(10);

	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1) {
			return true;
		} else
			return false;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if (state2 == GameState.Running)
			state2 = GameState.Paused;
	}

	private void nullify() {
		// Set all variables to null. You will be recreating them in the
		// constructor.
		paint = null;
		bg3 = null;
		bg4 = null;

		robot = null;

		currentSprite = null;
		character = null;
		character2 = null;
		character3 = null;

		anim = null;
		panim=null;
		zanim=null;
		fanim=null;
		
		zombie=null;
		zombie2=null;
		zombie3=null;
		
		police1=null;
		pol2=null;
		
		tree=null;
		end=null;
		police=null;
		pipe=null;

		// Call garbage collector to clean up memory.
		System.gc();
	}

	private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		if (state2 == GameState.Paused)
			state2 = GameState.Running;
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

	public static Background getBg3() {
		// TODO Auto-generated method stub
		return bg3;
	}

	public static Background getBg4() {
		// TODO Auto-generated method stub
		return bg4;
	}

	public static Robot getRobot() {
		// TODO Auto-generated method stub
		return robot;
	}

}
