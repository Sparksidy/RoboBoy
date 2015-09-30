package com.siddharth.roboboyGame;

import com.siddharth.framework.Game;
import com.siddharth.framework.Graphics;
import com.siddharth.framework.Graphics.ImageFormat;
import com.siddharth.framework.Screen;

public class LoadingScreen extends Screen  {
	public LoadingScreen(Game game){
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		  Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
	        Assets.background = g.newImage("background.png", ImageFormat.RGB565);
	        Assets.background2 = g.newImage("backgroundnight.png", ImageFormat.RGB565);
	        
	        Assets.pipe = g.newImage("Pipe.png", ImageFormat.ARGB4444);
	        Assets.tree = g.newImage("Tree.png", ImageFormat.ARGB4444);
	        Assets.police = g.newImage("Police.png", ImageFormat.ARGB4444);
	        Assets.end = g.newImage("end.png", ImageFormat.ARGB4444);
	        
	        
	        Assets.police1 = g.newImage("police1.png", ImageFormat.ARGB4444);
	        Assets.police2 = g.newImage("police2.png", ImageFormat.ARGB4444);
	        Assets.police3 = g.newImage("police3.png", ImageFormat.ARGB4444);
	        Assets.police4 = g.newImage("police4.png", ImageFormat.ARGB4444);
	        Assets.police5 = g.newImage("police5.png", ImageFormat.ARGB4444);
	        Assets.police6 = g.newImage("police6.png", ImageFormat.ARGB4444);
	        Assets.police7 = g.newImage("police7.png", ImageFormat.ARGB4444);
	        Assets.police8 = g.newImage("police8.png", ImageFormat.ARGB4444);
	        
	        
	        
	        Assets.z1 = g.newImage("zombi1.png", ImageFormat.ARGB4444);
	        Assets.z2 = g.newImage("zombi2.png", ImageFormat.ARGB4444);
	        Assets.z3 = g.newImage("zombi3.png", ImageFormat.ARGB4444); 
	        Assets.z4 = g.newImage("zombi4.png", ImageFormat.ARGB4444);
	        Assets.z5 = g.newImage("zombi5.png", ImageFormat.ARGB4444);
	        Assets.z6 = g.newImage("zombi6.png", ImageFormat.ARGB4444);
	        Assets.z7 = g.newImage("zombi7.png", ImageFormat.ARGB4444);
	        Assets.z8 = g.newImage("zombi8.png", ImageFormat.ARGB4444);
	        Assets.z9 = g.newImage("zombi9.png", ImageFormat.ARGB4444);
	        Assets.z10 = g.newImage("zombi10.png", ImageFormat.ARGB4444);
	        Assets.z11 = g.newImage("zombi11.png", ImageFormat.ARGB4444);
	        Assets.z12 = g.newImage("zombi12.png", ImageFormat.ARGB4444);
	        
	        
	        Assets.character = g.newImage("character.png", ImageFormat.ARGB4444);
	        Assets.character2 = g.newImage("character2.png", ImageFormat.ARGB4444);
	        Assets.character3  = g.newImage("character3.png", ImageFormat.ARGB4444);
	        Assets.characterJump = g.newImage("jumped.png", ImageFormat.ARGB4444);
	        Assets.characterDown = g.newImage("down.png", ImageFormat.ARGB4444);

	       
	        Assets.heliboy = g.newImage("heliboy.png", ImageFormat.ARGB4444);
	        Assets.heliboy2 = g.newImage("heliboy2.png", ImageFormat.ARGB4444);
	        Assets.heliboy3  = g.newImage("heliboy3.png", ImageFormat.ARGB4444);
	        Assets.heliboy4  = g.newImage("heliboy4.png", ImageFormat.ARGB4444);
	        Assets.heliboy5  = g.newImage("heliboy5.png", ImageFormat.ARGB4444);
	        
	        Assets.bird = g.newImage("bird.png", ImageFormat.ARGB4444);
	        Assets.bird2 = g.newImage("bird2.png", ImageFormat.ARGB4444);
	        Assets.bird3 = g.newImage("bird3.png", ImageFormat.ARGB4444);
	        Assets.bird4 = g.newImage("bird4.png", ImageFormat.ARGB4444);
	      
	        Assets.coin1 = g.newImage("Coin1.png", ImageFormat.ARGB4444);
	        Assets.coin2 = g.newImage("Coin2.png", ImageFormat.ARGB4444);
	        Assets.coin3 = g.newImage("Coin3.png", ImageFormat.ARGB4444);
	        Assets.coin4 = g.newImage("Coin4.png", ImageFormat.ARGB4444);
	        Assets.coin5 = g.newImage("Coin5.png", ImageFormat.ARGB4444);
	        
	        Assets.fire1 = g.newImage("Fire1.png", ImageFormat.ARGB4444);
	        Assets.fire2 = g.newImage("Fire2.png", ImageFormat.ARGB4444);
	        Assets.fire3 = g.newImage("Fire3.png", ImageFormat.ARGB4444);
	        Assets.fire4 = g.newImage("Fire4.png", ImageFormat.ARGB4444);
	        Assets.fire5 = g.newImage("Fire5.png", ImageFormat.ARGB4444);
		       


	       
	        Assets.tiledirt = g.newImage("tiledirt.png", ImageFormat.RGB565);
	        Assets.tilegrassTop = g.newImage("tilegrasstop.png", ImageFormat.RGB565);
	        Assets.tilegrassBot = g.newImage("tilegrassbot.png", ImageFormat.RGB565);
	        Assets.tilegrassLeft = g.newImage("tilegrassleft.png", ImageFormat.RGB565);
	        Assets.tilegrassRight = g.newImage("tilegrassright.png", ImageFormat.RGB565);
	        
	        
	        Assets.tiledirt2 = g.newImage("tiledirt2.png", ImageFormat.RGB565);
	        Assets.tilegrassTop2 = g.newImage("tilegrasstop2.png", ImageFormat.RGB565);
	        Assets.tilegrassBot2 = g.newImage("tilegrassbot2.png", ImageFormat.RGB565);
	        Assets.tilegrassLeft2 = g.newImage("tilegrassleft2.png", ImageFormat.RGB565);
	        Assets.tilegrassRight2 = g.newImage("tilegrassright2.png", ImageFormat.RGB565);
	        
	       
	        
	        Assets.button = g.newImage("button.jpg", ImageFormat.RGB565);
	        
	        
	        game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub
		
	}
	
	
}
