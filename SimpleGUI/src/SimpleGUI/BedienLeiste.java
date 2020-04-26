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
	double fehler = 0.2;			//Wahrscheinlichkeit eine falsche Farbe anzuzeigen; Wert zwischen 0 und 1
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
    	sq.setColor(Color.WHITE);
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
            		warte();
            		setFalscheFarbe(Color.GREEN);
            	}
            	else
            	{
            		warte();
            		sq.setColor(Color.GREEN);
            	}
            }
            else if(e.getSource() == rot)
            {
            	if(falscheFarbe())
            	{
            		warte();
            		setFalscheFarbe(Color.RED);
            	}
            	else
            	{
            		warte();
            		sq.setColor(Color.RED);
            	}
            }
            else if(e.getSource() == blau)
            {
            	if(falscheFarbe())
            	{
            		warte();
            		setFalscheFarbe(Color.BLUE);
            	}
            	else
            	{
            		warte();
            		sq.setColor(Color.BLUE);
            	}
            }
        }
    }
}
