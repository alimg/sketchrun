package com.uyduramadimbirseyler.sketchrun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

	private Game mGame;
	private Paint paint;
	private RectF r=new RectF();
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setWillNotDraw(false);
		getHolder().addCallback(this);
	}
	
	public void setGame(Game game)
	{
		mGame=game;
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		if(mGame==null)
		{
			invalidate();
			return;
		}
		super.onDraw(canvas);
		if(mGame.ready)
		{
			r.left=mGame.player.pos.x;
			r.right=mGame.player.pos.x+50;
			r.top=mGame.player.pos.y;
			r.bottom=mGame.player.pos.y+100;
			canvas.drawRect(r, paint);
		}
		//Log.d("tag","asdf "+mGame.mState);
		invalidate();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		mGame.pause();
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mGame.setLoading();
		//Burada resimler yuklenecek
		paint=new Paint();
		paint.setColor(Color.GREEN);
		
		mGame.setLoaded();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}
	
}
