package SimpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BedienLeiste extends JPanel
{
	JButton gruen;
	JButton rot;
	JButton blau;
	Square sq;
	Random zufall;
	Agent ag;
	double fehler = 0.1;			//Wahrscheinlichkeit eine falsche Farbe anzuzeigen; Wert zwischen 0 und 1
	ActionListener listener;
	
    
    public BedienLeiste(Square sq)
    {
    	this.sq = sq;
    	gruen = new JButton("Grün");
    	rot = new JButton("Rot");
    	blau = new JButton("Blau");
    	
    	zufall = new Random();
        
        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        setBackground(Color.WHITE);
        
        add(gruen);
        add(rot);
        add(blau);
        
        listener = new ButtonListener();
        
        gruen.addActionListener(listener);
        rot.addActionListener(listener);
        blau.addActionListener(listener);
        
        
    }
    
    public Boolean falscheFarbe()
    {
    	if(zufall.nextGaussian() < fehler)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public void setFalscheFarbe(Color farbe)
    {
    	sq.setNextColor(farbe);
    	
    	if(farbe.equals(Color.RED))
    	{
    		if(sq.getColor().equals(Color.GREEN))
    		{
    			sq.setColor(Color.BLUE);
    		}
    		else if(sq.getColor().equals(Color.BLUE))
    		{
    			sq.setColor(Color.GREEN);
    		}
    		else
    		{
    			sq.setColor(Color.GRAY);
    		}
    	}
    	if(farbe.equals(Color.BLUE))
    	{
    		if(sq.getColor().equals(Color.GREEN))
    		{
    			sq.setColor(Color.RED);
    		}
    		else if(sq.getColor().equals(Color.RED))
    		{
    			sq.setColor(Color.GREEN);
    		}
    		else
    		{
    			sq.setColor(Color.GRAY);
    		}
    	}
    	if(farbe.equals(Color.GREEN))
    	{
    		if(sq.getColor().equals(Color.RED))
    		{
    			sq.setColor(Color.BLUE);
    		}
    		else if(sq.getColor().equals(Color.BLUE))
    		{
    			sq.setColor(Color.RED);
    		}
    		else
    		{
    			sq.setColor(Color.GRAY);
    		}
    	}
    	
    	ag = new Agent(sq);
    	ag.start();
		//sq.setColor(farbe);
    }

    public void warte()
    {
    	try
    	{
    		Thread.sleep(zufall.nextInt(1000) + 500);
    	}
    	catch(Exception exception)
    	{
    		System.out.println("Ohh, ein echter Fehler");
    	}
    }
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == gruen)
            {
            	if(falscheFarbe())
            	{
            		setFalscheFarbe(Color.GREEN);
            	}
            	else
            	{
            		sq.setColor(Color.GREEN);
            	}
            }
            else if(e.getSource() == rot)
            {
            	if(falscheFarbe())
            	{
            		setFalscheFarbe(Color.RED);
            	}
            	else
            	{
            		sq.setColor(Color.RED);
            	}
            }
            else if(e.getSource() == blau)
            {
            	if(falscheFarbe())
            	{
            		setFalscheFarbe(Color.BLUE);
            	}
            	else
            	{
            		sq.setColor(Color.BLUE);
            	}
            }
        }
    }
}
