package gui;

import javax.swing.*;

public class PlayButton extends JButton
{
	boolean isPlaying;
	public PlayButton()
	{
		super();
		isPlaying = false;
	}

	public void play()
	{
		if (isPlaying)
		{
			isPlaying = false;
			setIcon(new ImageIcon("Icons/playButton.png"));
		}
		else
		{
			isPlaying = true;
			setIcon(new ImageIcon("Icons/stopButton.png"));
		}
	}
}