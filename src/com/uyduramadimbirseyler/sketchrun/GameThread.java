package com.uyduramadimbirseyler.sketchrun;

import android.os.SystemClock;

public class GameThread extends Thread {

	
	private Game mGame;

	GameThread(Game game){
		
		mGame=game;
	}
	
	@Override
	public void run() {

		long time=SystemClock.elapsedRealtime();
		long lastTime=time;
		while(mGame.isRunning())
		{
			time=SystemClock.elapsedRealtime();
			long dt=time-lastTime;
			lastTime=time;
			
			synchronized (mGame)
			{
				mGame.update(dt);
			}
			
		}
	}
}
