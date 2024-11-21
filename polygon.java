import java.awt.*;
import java.awt.event.*;
class polygon extends Frame
{
    polygon()
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
        g.fillRoundRect(30,30,250,250,30,30);
        g.setColor(Color.green);
        int[] x={40,200,40,100};
        int[] y={40,40,200,200};
        int n=4;
        g.fillPolygon(x,y,n);
    }
    public static void main(String[] args)
    {
        polygon p=new polygon();
        p.setTitle("My Polygon");
        p.setSize(600,600);
        p.setVisible(true);
    }
}