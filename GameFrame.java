import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GameFrame extends JFrame {

	GamePanel panel;
	GameFrame()
	{
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("pong game");
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
