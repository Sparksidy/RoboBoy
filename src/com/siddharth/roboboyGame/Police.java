package com.siddharth.roboboyGame;

import java.util.ArrayList;

import android.graphics.Rect;

public class Police {
	private int centerX,centerY,speedX;
	
	private int movementSpeed;
	
	public int health=5;
	
	public Rect r2= new Rect(0,0,0,0);
	public boolean collidedTobot;
	private Background bg = Level2.getBg3();
	private Robot robot2 = Level2.getRobot();
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}

	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}

	public Police(int centerX,int centerY){
		this.centerX=centerX;
		this.centerY=centerY;
	}
	
	public void police_update(){
		followRobot();
		centerX += speedX;
		
		speedX = bg.getSpeedX()*4 + movementSpeed;
		 
        r2.set(centerX+25, centerY+25, centerX +25 , centerY + 35);
        
        if (Rect.intersects(r2, Robot.yellowRed)) {
            collidedTobot = checkCollision();
        }   
		
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
                movementSpeed = -5;
            }
        }

    }
	
	public boolean checkCollision() {
        if (Rect.intersects(r2, Robot.rect)|| Rect.intersects(r2, Robot.rect2)
                || Rect.intersects(r2, Robot.rect3) || Rect.intersects(r2, Robot.rect4)) {
        	
        	return true;	
        }
        else
        	return false;
        	
    }
	
	public void policeShoot(){
		Projectile p = new Projectile(centerX - 50, centerY + 25);
		projectiles.add(p);
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
	
}
