package com.siddharth.roboboyGame;

public class Fire {
	
	int x,y,speedX;
	private Background bg = Level2.getBg3();
	
	
	public Fire(int x,int y){
		this.x=x;
		this.y=y;
		
		speedX=0;
	}
	
	public void fire_update(){
		x += speedX;
		speedX = bg.getSpeedX()* 4;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
