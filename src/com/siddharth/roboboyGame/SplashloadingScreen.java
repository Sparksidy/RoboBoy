package com.siddharth.roboboyGame;

import com.siddharth.framework.Game;
import com.siddharth.framework.Graphics;
import com.siddharth.framework.Graphics.ImageFormat;
import com.siddharth.framework.Screen;

public class SplashloadingScreen extends Screen {
	public SplashloadingScreen(Game game){
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		Assets.splash = g.newImage("splash.jpg", ImageFormat.RGB565);
		
		game.setScreen(new LoadingScreen(game));
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		
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
