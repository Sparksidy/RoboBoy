package com.siddharth.roboboyGame;

import android.graphics.Rect;

public class Coin{

	private int centerX, centerY, speedX;
	
	//private Robot 		robot = GameScreen.getRobot();
	private Background 	bg    =	GameScreen.getBg1();
	
	public  Rect r1 = new Rect(0,0,0,0);
	
	
	

	public Coin(int centerX, int centerY) {
		this.centerX = centerX;
		this.centerY = centerY;

	}

	public void coin_update() {
		
		centerX += speedX ;
		speedX = bg.getSpeedX()*4;
		
		r1.set(centerX,centerY,centerX+30,centerY+30);	
		
		
	}
	
	
	
	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterX(int centerX){
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

}
