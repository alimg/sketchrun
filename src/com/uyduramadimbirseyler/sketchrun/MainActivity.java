package com.uyduramadimbirseyler.sketchrun;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		GameView gview=(GameView) findViewById(R.id.gameView1);
		Game game=new Game();
		gview.setGame(game);
		GameThread thread= new GameThread(game);
		thread.start();
	}
}
