import gui.GUI;

public class Controller
{
	private final GUI gui;
	private final DBHandler dbHandler;
	private final Player player;

	public Controller()
	{
		gui = new GUI();
		dbHandler = new DBHandler();
		player = new Player();
		setListeners();
	}

	private void setListeners()
	{
		gui.getBtnPlay().addActionListener(e -> gui.getBtnPlay().play(player));
		gui.getBtnPrevious().addActionListener(e -> gui.getBtnPrevious());
	}
}