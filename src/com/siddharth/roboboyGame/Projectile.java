package com.siddharth.roboboyGame;

import android.graphics.Rect;


public class Projectile {

    private int x, y, speedX;
    public boolean visible;
    public static boolean completed2;
   
    private Rect r;
    public boolean policebullet=false;
   
    public Projectile(int startX, int startY){
        x = startX;
        y = startY;
        speedX = 7;
        visible = true;
       
        r = new Rect(0, 0, 0, 0);
    }
   
    public void update(){
    
    		x += speedX;
	        r.set(x, y-30, x+10, y+5);
	        if (x > 800){
	            visible = false;
	            r = null;
	        }
	        if (x < 800){
	            checkCollision();
	        }
    		
    		
    	}
    	
       
   

    private void checkCollision(){
    	
    	if(GameScreen.levelover){
    		
    		if(Rect.intersects(r, Level2.zombie.r1)){
    			
    			visible=false;
    			
    			if(Level2.zombie.death > 0){
    				Level2.zombie.death -= 1;
    			}
    			if(Level2.zombie.death == 0){
    				Level2.zombie.setCenterX(-100);
    				Level2.score += 10;
    			}
    		}
    		if(Rect.intersects(r, Level2.zombie2.r1)){
    			
    			visible=false;
    			
    			if(Level2.zombie2.death > 0){
    				Level2.zombie2.death -= 1;
    			}
    			if(Level2.zombie2.death == 0){
    				Level2.zombie2.setCenterX(-100);
    				Level2.score += 10;
    			}
    		}
    		
    		if(Rect.intersects(r, Level2.zombie3.r1)){
    			
    			visible=false;
    			
    			if(Level2.zombie3.death > 0){
    				Level2.zombie3.death -= 1;
    			}
    			if(Level2.zombie3.death == 0){
    				Level2.zombie3.setCenterX(-100);
    				Level2.score += 10;
    				completed2=true;
    			}
    		}
    		
    		if(Rect.intersects(r, Level2.police1.r2)){
    			
    			visible=false;
    			
    			if(Level2.police1.health > 0){
    				Level2.police1.health -= 1;
    			}
    			if(Level2.police1.health == 0){
    				Level2.police1.setCenterX(-100);
    				Level2.score += 30;
    			}
    		}
    		
    		if(Rect.intersects(r, Level2.pol2.r2)){
    			
    			visible=false;
    			
    			if(Level2.pol2.health > 0){
    				Level2.pol2.health -= 1;
    			}
    			if(Level2.pol2.health == 0){
    				Level2.pol2.setCenterX(-100);
    				Level2.score += 30;
    			}
    		}
    		
    		
    		
    		
    		
    		
    	}
    	else{
    		if(Rect.intersects(r, GameScreen.hb.r)){
    			
	            visible = false;
	       
	            if (GameScreen.hb.health > 0) {
	                GameScreen.hb.health -= 1;
	            }
	            if (GameScreen.hb.health == 0) {
	                GameScreen.hb.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	       
	        if (Rect.intersects(r, GameScreen.hb2.r)){
	            visible = false;

	            if (GameScreen.hb2.health > 0) {
	                GameScreen.hb2.health -= 1;
	            }
	            if (GameScreen.hb2.health == 0) {
	                GameScreen.hb2.setCenterX(-100);
	                GameScreen.score += 5;
	               

	            }

	        }
	        
	        if(Rect.intersects(r, GameScreen.hb3.r)){
	            visible = false;
	       
	            if (GameScreen.hb3.health > 0) {
	                GameScreen.hb3.health -= 1;
	            }
	            if (GameScreen.hb3.health == 0) {
	                GameScreen.hb3.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	        
	        if(Rect.intersects(r, GameScreen.hb4.r)){
	            visible = false;
	       
	            if (GameScreen.hb4.health > 0) {
	                GameScreen.hb4.health -= 1;
	            }
	            if (GameScreen.hb4.health == 0) {
	                GameScreen.hb4.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	        if(Rect.intersects(r, GameScreen.hb5.r)){
	            visible = false;
	       
	            if (GameScreen.hb5.health > 0) {
	                GameScreen.hb5.health -= 1;
	            }
	            if (GameScreen.hb5.health == 0) {
	                GameScreen.hb5.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	        
	        if(Rect.intersects(r, GameScreen.hb6.r)){
	            visible = false;
	       
	            if (GameScreen.hb6.health > 0) {
	                GameScreen.hb6.health -= 1;
	            }
	            if (GameScreen.hb6.health == 0) {
	                GameScreen.hb6.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	        

	        if(Rect.intersects(r, GameScreen.b1.r)){
	            visible = false;
	       
	            if (GameScreen.b1.health > 0) {
	                GameScreen.b1.health -= 1;
	            }
	            if (GameScreen.b1.health == 0) {
	                GameScreen.b1.setCenterX(-100);
	                GameScreen.score += 5;

	            }

	        }
	        
	        if(Rect.intersects(r, GameScreen.b2.r)){
	            visible = false;
	       
	            if (GameScreen.b2.health > 0) {
	                GameScreen.b2.health -= 1;
	            }
	            if (GameScreen.b2.health == 0) {
	                GameScreen.b2.setCenterX(-100);
	                GameScreen.score += 5;
	                GameScreen.b2.dead=true;
	                

	            }

	        }
	        if(Rect.intersects(r, GameScreen.b3.r)){
	            visible = false;
	       
	            if (GameScreen.b3.health > 0) {
	                GameScreen.b3.health -= 1;
	            }
	            if (GameScreen.b3.health == 0) {
	                GameScreen.b3.setCenterX(-100);
	                GameScreen.score += 5;
	                GameScreen.b3.dead=true;
	                

	            }

	        }
    		
    		
    		
	    		
    	   }
       
        
        
        
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
   
   
}