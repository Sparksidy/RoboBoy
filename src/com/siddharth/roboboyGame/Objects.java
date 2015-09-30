package com.siddharth.roboboyGame;

public class Objects {
	int centerX,centerY,speedX;
	private Background bg = Level2.getBg3();
	
	
	public Objects(int x,int y){
		this.centerX = x;
		this.centerY = y;
		
		this.speedX = 0;
	}
	
	public void obj_update(){
		centerX += speedX;
		speedX = bg.getSpeedX()* 4;
	}


	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	
	
	
}
