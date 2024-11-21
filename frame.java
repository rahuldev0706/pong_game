import java.awt.*;
import java.awt.event.*;
class frame
{
    public static void main(String[] args)
    {
        Frame f=new Frame();
        f.setSize(500,500);
        f.setTitle("My Frame");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}