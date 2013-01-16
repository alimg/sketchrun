package com.uyduramadimbirseyler.sketchrun;

import java.util.ArrayList;

import com.uyduramadimbirseyler.sketchrun.gameobjects.Figure;
import com.uyduramadimbirseyler.sketchrun.gameobjects.GameObject;

public class Game {
	public static final int STATE_NONE=0;
	public static final int STATE_LOADING=1;
	public static final int STATE_RUNNING=2;
	public static final int STATE_COUNTDOWN=3;
	public static final int STATE_PAUSE=4;
	public static final int STATE_DEATH=5;
	public static final int STATE_INIT=6;
	public Figure player;
	public ArrayList <GameObject> objects;
	
	public int mState;//
	private boolean loading;
	private boolean loaded;
	public boolean ready;
	
	public Game() {
		mState=STATE_NONE;
		
	}
	
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return true;
	}

	public void update(long dt) {
		
		switch(mState)
		{
		case STATE_NONE:
				return;
			case STATE_LOADING:
			if(loaded)
				mState=STATE_INIT;
			return;
		case STATE_INIT:
			initNewGame();
			break;
		case STATE_COUNTDOWN:
			mState=STATE_RUNNING;
			break;
		case STATE_RUNNING:
			updateGame(dt);
			break;
		case STATE_DEATH:
			return;
		}
	}
	
	private void updateGame(long dt) {
		player.pos.y=(player.pos.y+10*dt/1000.f)%120;
		
	}

	private void initNewGame() {
		player=new Figure();
		player.pos.set(20, 120);
		mState=STATE_COUNTDOWN;
		ready=true;
	}

	public void setLoading(){
		loading=true;
		mState=STATE_LOADING;
	}
	public void setLoaded(){
		loaded=true;
		loading=false;
	}
	
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}
