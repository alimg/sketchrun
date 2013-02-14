package com.uyduramadimbirseyler.sketchrun.gameobjects;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;

import android.graphics.Point;

public class Figure extends GameObject{
	
	public Point size=new Point(50,100);
	public Body body;
	public Fixture bodyFixture;
	public Fixture sensoryFixture;
	
	public void setPos(int i, int j) {
		body.setTransform(new Vec2(i,j), 0);
	}
	public Vec2 getPos()
	{
		return body.getPosition();
	}

}
