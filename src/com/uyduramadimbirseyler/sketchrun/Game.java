package com.uyduramadimbirseyler.sketchrun;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;

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
	private World world;
	private Body ground;
	
	public Game() {
		mState=STATE_NONE;
		ready=false;
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
				ready=false;
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
		//player.pos.y=(player.pos.y+10*dt/1000.f)%120;
		world.step(1.0f/60f, 8, 8);
		
	}

	private void initNewGame() {
		
		world = new World(new Vec2(0, 1), true);
		BodyDef def = new BodyDef();
		def.type = BodyType.STATIC;
		ground = world.createBody(def);
		PolygonShape poly = new PolygonShape();		
		poly.setAsBox(25f, 1f);
		ground.createFixture(poly, 1).m_friction=1;
		ground.setTransform(new Vec2(0, 400),0 );
		
		Figure ply=new Figure();
		createPlayerBody(ply);
		player=ply;
		player.setPos( 1 , 10);

		mState=STATE_COUNTDOWN;
		ready=true;
	}
	
	private void createPlayerBody(Figure player) {
		
		BodyDef def = new BodyDef();
		def.type = BodyType.DYNAMIC;
		Body box = world.createBody(def);
 
		PolygonShape poly = new PolygonShape();		
		poly.setAsBox(0.2f, 0.8f);
		
		Fixture pf = box.createFixture(poly, 1f);
		pf.m_friction=0;	
 
		CircleShape circle = new CircleShape();		
		circle.m_radius=(0.2f);
		circle.m_p.set(0, -0.8f);
		Fixture sf = box.createFixture(circle, 0);			
		sf.m_friction=1f;
		box.setBullet(true);
		box.setFixedRotation(true);

		player.body=box;
		player.bodyFixture = pf;
		player.sensoryFixture = sf;
		
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
