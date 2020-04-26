package SimpleGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author (Finn Siegismund) 
 * @version (0.1)
 */

public class GUI extends JFrame
{
	private Square sq;
    private BedienLeiste bedienL;
    private Platzhalter platzNorth;
    private Platzhalter platzEast;
    private Platzhalter platzWest;
    
	public GUI()
    {
		sq = new Square();
	    bedienL = new BedienLeiste(sq);
	    platzNorth = new Platzhalter();
	    platzEast = new Platzhalter();
	    platzWest = new Platzhalter();
	    
		setLayout(new BorderLayout());
		
        add(sq, BorderLayout.CENTER);
        add(bedienL, BorderLayout.SOUTH);
        
        add(platzNorth, BorderLayout.NORTH);
        add(platzEast, BorderLayout.EAST);
        add(platzWest, BorderLayout.WEST);
        
        setLocation(50,0);
        setSize(600,500);
        setMinimumSize(new Dimension(300,250));
        setVisible(true);
    }
	
	public static void main(String[] args) 
	{
		GUI myGui = new GUI();
	}

}
