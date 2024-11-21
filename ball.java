import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ball extends Rectangle{

	Random random;
	int Xvelocity;
	int Yvelocity;
	int initialspeed=2;
	ball(int x,int y,int width,int height)
	{
		super(x,y,width,height);
		random =new Random();
		
		int randomXDirection=random.nextInt(2);
		if(randomXDirection==0)
		{
			randomXDirection--;
		}
		setXDirection(randomXDirection*initialspeed);
		
		int randomYDirection=random.nextInt(2);
		if(randomYDirection==0)
		{
			randomYDirection--;
		}
		setYDirection(randomYDirection*initialspeed);
		
	}
	
	public void setXDirection(int randomXDirection)
	{
		Xvelocity=randomXDirection;
	}
	
	public void setYDirection(int randomYDirection)
	{
		Yvelocity=randomYDirection;
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
	}
	
	public void move()
	{
		x=x+Xvelocity;
		y=y+Yvelocity;
	}
}

