package com.siddharth.roboboyGame;

import com.siddharth.framework.Image;
import com.siddharth.framework.Music;
import com.siddharth.framework.Sound;

public class Assets {
	 
    public static Image menu, splash, background,background2, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5, bird, bird2,bird3,bird4,coin1,coin2,coin3,coin4,coin5,fire1,fire2,fire3,fire4,fire5,pipe,tree,police,end;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown,tiledirt2, tilegrassTop2, tilegrassBot2, tilegrassLeft2, tilegrassRight2,z1,z2,z3,z4,z5,z6,z7,z8,z9,z10,z11,z12;
    public static Image button,police1,police2,police3,police4,police5,police6,police7,police8;
    public static Sound click;
    public static Music theme;
    
    public static void load(SampleGame sampleGame){
    	theme = sampleGame.getAudio().createMusic("survival.mp3");
    	theme.setLooping(true);
    	theme.setVolume(0.85f);
    	theme.play();
    	
    }
    
}
