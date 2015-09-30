package com.siddharth.roboboyGame;

import android.graphics.Rect;




public class Zombie {
	private int centerX,centerY;
	private int speedX;
	
	private Background bg = Level2.getBg3();
	private Robot robot2 = Level2.getRobot();
	
	
	
	
	
	
	public Rect r1= new Rect(0,0,0,0);
	
	public int death=5;
	
	public boolean collidedToRobot;
	
	private int movementSpeed ;
	
	public Zombie(int centerX,int centerY){
		this.centerX = centerX;
		this.centerY = centerY;
		
		
	}
	
	public void updateZombie() {
		
        followRobot();
        
        centerX += speedX;
        speedX = bg.getSpeedX() * 5 + movementSpeed;
        
        r1.set(centerX+25, centerY+25, centerX +25 , centerY + 35);
        
        if (Rect.intersects(r1, Robot.yellowRed)) {
            collidedToRobot = checkCollision();
        }   
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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	
	
	public Rect getR() {
		return r1;
	}

	public void setR(Rect r) {
		this.r1 = r;
	}

	public boolean isCollidedToRobot() {
		return collidedToRobot;
	}

	public void setCollidedToRobot(boolean collidedToRobot) {
		this.collidedToRobot = collidedToRobot;
	}

	public boolean checkCollision() {
	        if (Rect.intersects(r1, Robot.rect)|| Rect.intersects(r1, Robot.rect2)
	                || Rect.intersects(r1, Robot.rect3) || Rect.intersects(r1, Robot.rect4)) {
	        	
	        	return true;	
	        }
	        else
	        	return false;
	        	
	    }
	

	 private void followRobot() {
	       
	        if (centerX < -95 || centerX > 810){
	            movementSpeed = 0;
	        }

	        else if (Math.abs(robot2.getCenterX() - centerX) < 5) {
	            movementSpeed = 0;
	        }

	        else {

	            if (robot2.getCenterX() >= centerX) {
	                movementSpeed = 1;
	            } else {
	                movementSpeed = -1;
	            }
	        }

	    }
	
	
	
}
