package mosque;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class NewJApplet extends Applet implements Runnable 
{
    String msg;
    Thread thrd = null;
    int state;
    boolean stopFlag;

    @Override
    public void init() // Set colors and initialize thread. 
    {    //g.setFont(new Font("Arial",Font.BOLD,20));   
        
        setBackground(Color.white);
        setForeground(Color.red);
        
        JLabel l = new JLabel(msg);
        l.setBounds(20, 20, 100, 30);
        add(l);
        
    }

    @Override
    public void start() // Start thread 
    {       
        msg = getParameter("message");
        if (msg == null) 
        {
            msg = "Wellcome to Java 2 Using Thread.     ";
        }
        msg = " " + msg;
        thrd = new Thread(this);
        stopFlag = false;
        thrd.start();
    }

    @Override
    public void run() // Entry point for the thread that runs the banner. 
    {
        char ch;
        for (;;) // Display banner 
        {
            try 
            {
                repaint();
                Thread.sleep(150);
                 
                ch = msg.charAt(1);
                msg = msg.substring(1, msg.length());
                msg += ch;
                if (stopFlag) 
                {
                    break;
                }
            } 
            catch (InterruptedException e) { }
        }
    }

    @Override
    public void stop()// Pause the banner. 
    {
        stopFlag = true;
        thrd = null;
    }

    // Display the banner. 
    @Override
    public void paint(Graphics g) 
    {
        
    }
}
