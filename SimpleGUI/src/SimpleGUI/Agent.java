package SimpleGUI;

import java.awt.Color;

public class Agent extends Thread{
	Square sq;
	public void run()
	{
		try
		{
			Thread.sleep(1000);
			sq.addFehlermeldung();
			Thread.sleep(1000);
			sq.setColor(sq.getNextColor());
			sq.removeFehlermeldung();

		}
		catch(InterruptedException e)
		{
			System.out.println("Ohh, ein Fehler :(");
		}
		
	}
	Agent(Square sq)
	{
		this.sq = sq;
	}
}
