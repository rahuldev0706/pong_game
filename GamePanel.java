import java.awt.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

	static final int GAME_WIDTH=800;
	static final int GAME_HEIGHT=(int)(GAME_WIDTH*(0.5555));
	static final Dimension SCREEN_SIZE=new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER=25;
	static final int PADDLE_HEIGHT=100;
	static final int PADDLE_WIDTH=25;
	Thread gameThread;
	Image image;
	Graphics graphics;
	paddle paddle1;
	paddle paddle2;
	ball ball;
	score score;
	Random random;
	
	
	GamePanel()
	{
		newpaddles();
		newball();
		score =new score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread =new Thread(this);
		gameThread.start();
		
	}
	
	
	public void newball()
	{
		random =new Random();
		
		ball = new ball((GAME_HEIGHT/2-BALL_DIAMETER/2),random.nextInt(GAME_WIDTH/2-BALL_DIAMETER),BALL_DIAMETER/2,BALL_DIAMETER/2);
	}
	
	
	public void newpaddles()
	{
		paddle1=new paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_HEIGHT,PADDLE_WIDTH,1);
		paddle2 =new paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_HEIGHT,PADDLE_WIDTH,2);
	}
	
	
	public void paint(Graphics g)
	{
			image =createImage(getWidth(),getHeight());
			graphics = image.getGraphics();
			draw(graphics);
			g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g)
	{
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void move()
	{
		ball.move();
	}
	
	public void checkCollision()
	{
		//for balls (not going out in top & bottom directions)
		if(ball.y<=0)
		{
			ball.setYDirection(-ball.Yvelocity);
		}
		if(ball.y>= GAME_HEIGHT-BALL_DIAMETER)
		{
			ball.setYDirection(-ball.Yvelocity);
		}
		//for balls (checking collision with paddles)
		      //paddle1
		if(ball.intersects(paddle1))
		{
			ball.Xvelocity= Math.abs(ball.Xvelocity);
			ball.Xvelocity++;
			if(ball.Yvelocity>0)
			     ball.Yvelocity++;
			else
				ball.Yvelocity--;
			ball.setXDirection(ball.Xvelocity);
			ball.setYDirection(ball.Yvelocity);
				
		}
		
		      //paddle2
		if(ball.intersects(paddle2))
		{
			ball.Xvelocity= Math.abs(ball.Xvelocity);
			ball.Xvelocity++;
			if(ball.Yvelocity>0)
			     ball.Yvelocity++;
			else
				ball.Yvelocity--;
			ball.setXDirection(-ball.Xvelocity);
			ball.setYDirection(ball.Yvelocity);
				
		}
		//for paddles(for mot going out of screen)
		if(paddle1.y<=0)
		{
			paddle1.y=0;
		}
		if(paddle1.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
		{
			paddle1.y=GAME_HEIGHT-PADDLE_HEIGHT;
		}
		
		if(paddle2.y<=0)
		{
			paddle2.y=0;
		}
		if(paddle2.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
		{
			paddle2.y=GAME_HEIGHT-PADDLE_HEIGHT;
		}
		
		//for updating scores
		  //for player1
		   if(ball.x<=0)
		   {
			   score.player2++;
			   newpaddles();
			   newball();
		   }
		   //for player2
		   if(ball.x>=GAME_WIDTH-BALL_DIAMETER)
		   {
			   score.player1++;
			   newpaddles();
			   newball();
		   }
	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns=1000000000/amountofTicks;
		double delta=0;
		while(true)
		{
			long now= System.nanoTime();
			delta +=(now-lastTime)/ns;
			lastTime=now;
			if(delta>=1)
			{
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
		
		
	}
	
	public class AL extends KeyAdapter
	{
		 public void keyPressed(KeyEvent e)
		 {
			 paddle1.keyPressed(e);
			 paddle2.keyPressed(e);
		 }
		 
		 public void keyReleased(KeyEvent e)
		 {
			 paddle1.keyReleased(e);
			 paddle2.keyReleased(e);
		 }
		 
	}
}
