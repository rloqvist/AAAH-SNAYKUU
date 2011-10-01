
import gameLogic.Session;
import userInterface.SettingsWindow;
import userInterface.MainWindow;

class Main
{		
	public static void main(String[] args)
	{
		SettingsWindow settingsWindow = new SettingsWindow();
		
		while (!settingsWindow.isDone());
		
		Session session = settingsWindow.generateSession();
		
		runGame(session);
	}
		
	
	private static void runGame(Session session)
	{
		MainWindow mainWindow = new MainWindow(session, 12);
		
		while(true)
		{
			session.tick();
			mainWindow.repaint();
			
			try
			{
				Thread.currentThread().sleep(400);
			}
			catch (InterruptedException e)
			{
				break;
			}
			
		}
	}
}
