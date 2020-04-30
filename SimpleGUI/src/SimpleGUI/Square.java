package SimpleGUI;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel
{
	Color farbe;
	Color nextFarbe;
	String fehlermeldung = "Ohh, falsche Farbe...";
	String leer = "";
	JLabel label;
	
	public Square()
    {
        setColor(Color.GREEN);
        label = new JLabel(leer);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label);
    }
	
	public void setColor(Color farbe)
	{
        this.farbe = farbe;
		setBackground(farbe);
	}
	public Color getColor()
	{
        return this.farbe;
	}
	public void setNextColor(Color farbe)
	{
        this.nextFarbe = farbe;
	}
	public Color getNextColor()
	{
        return this.nextFarbe;
	}
	public void addFehlermeldung()
	{
		label.setText(fehlermeldung);
	}
	public void removeFehlermeldung()
	{
		label.setText(leer);
	}

}
