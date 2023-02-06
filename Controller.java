import gui.GUI;

public class Controller
{
	private final GUI gui;
	private final DBHandler dbHandler;

	public Controller()
	{
		gui = new GUI();
		setListeners();
		dbHandler = new DBHandler();
	}

	private void setListeners()
	{
		gui.getBtnPlay().addActionListener(e -> gui.getBtnPlay().play());
	}
}