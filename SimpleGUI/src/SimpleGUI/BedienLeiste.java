package SimpleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BedienLeiste extends JPanel
{
	JButton gruen;
	JButton rot;
	JButton blau;
	Square sq;
	
	ActionListener listener;
    
    public BedienLeiste(Square sq)
    {
    	this.sq = sq;
    	gruen = new JButton("Grün");
    	rot = new JButton("Rot");
    	blau = new JButton("Blau");
        
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
    
    class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == gruen)
            {
            	sq.setColor(Color.GREEN);
            }
            else if(e.getSource() == rot)
            {
            	sq.setColor(Color.RED);
            }
            else if(e.getSource() == blau)
            {
            	sq.setColor(Color.BLUE);
            }
        }
    }
}
