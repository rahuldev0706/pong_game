import java.awt.*;
import java.awt.event.*;
class button extends Frame implements ActionListener
{
    Button b1,b2,b3;
    button()
    {
        this.setLayout(null);
        b1=new Button("blue");
        b2=new Button("red");
        b3=new Button("yellow");
        b1.setBounds(100,100,70,40);
        b2.setBounds(100,160,70,40);
        b3.setBounds(100,220,70,40);
        add(b1);
        this.add(b2);
        this.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(s.equals("red"))
        this.setBackground(Color.red);
        if(s.equals("yellow"))
        this.setBackground(Color.yellow);
        if(ae.getSource()==b1)
        setBackground(Color.blue);
    }
    public static void main(String[] args)
    {
        button b=new button();
        b.setSize(500,500);
        b.setVisible(true);
    }
}