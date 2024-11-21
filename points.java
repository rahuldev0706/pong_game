import java.awt.*;
import java.awt.event.*;
class points extends Frame
{
    points()
    {
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        for(;;)
        {
            int x=(int) (Math.random()*500);
            int y=(int) (Math.random()*1000);
            g.drawLine(x,y,x,y);
            try{
                Thread.sleep(20);
            }catch(InterruptedException ie){}
        }
    }
    public static void main(String[] args)
    {
        points p=new points();
        p.setTitle("Points");
        p.setSize(500,500);
        p.setVisible(true);
    }
}