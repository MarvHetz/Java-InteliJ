package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame
{

	private final JPanel contentPane;
	private PlayButton btnPlay;
	private JButton btnPrevious;
	private JButton btnNext;
	private JList listPlaylists;
	private JTextField textField;
	private JLabel lblSearch;
	private JList list_1;
	private JLabel lblPlaylists;
	private JLabel lblSong;
	private JLabel lblPlaylist;
	private JButton btnAddPlaylist;
	private JButton btnDeletePlaylist;
	private JButton btnAddSong;
	private JButton btnDeleteSong;

	public GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Musicplayer");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\icon.png"));
		setBounds(100, 100, 711, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnPlay());
		contentPane.add(getBtnPrevious());
		contentPane.add(getBtnNext());
		contentPane.add(getListPlaylists());
		contentPane.add(getTextField());
		contentPane.add(getLblSearch());
		contentPane.add(getList_1());
		contentPane.add(getLblPlaylists());
		contentPane.add(getLblSong());
		contentPane.add(getLblPlaylist());
		contentPane.add(getBtnAddPlaylist());
		contentPane.add(getBtnDeletePlaylist());
		contentPane.add(getBtnAddSong());
		contentPane.add(getBtnDeleteSong());
		setVisible(true);
	}

	public PlayButton getBtnPlay()
	{
		if (btnPlay == null)
		{
			btnPlay = new PlayButton();
			btnPlay.setIcon(new ImageIcon("Icons\\playButton.png"));
			btnPlay.setBounds(333, 443, 37, 39);
		}
		return btnPlay;
	}

	public JButton getBtnPrevious()
	{
		if (btnPrevious == null)
		{
			btnPrevious = new JButton("");
			btnPrevious.setIcon(new ImageIcon("Icons\\previousButton.png"));
			btnPrevious.setBounds(286, 443, 37, 39);
		}
		return btnPrevious;
	}

	public JButton getBtnNext()
	{
		if (btnNext == null)
		{
			btnNext = new JButton("");
			btnNext.setIcon(new ImageIcon("Icons\\skipButton.png"));
			btnNext.setBounds(380, 443, 37, 39);
		}
		return btnNext;
	}

	public JList getListPlaylists()
	{
		if (listPlaylists == null)
		{
			listPlaylists = new JList();
			listPlaylists.setBounds(10, 86, 152, 349);
		}
		return listPlaylists;
	}

	public JTextField getTextField()
	{
		if (textField == null)
		{
			textField = new JTextField();
			textField.setBounds(66, 17, 140, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	public JLabel getLblSearch()
	{
		if (lblSearch == null)
		{
			lblSearch = new JLabel("Search:");
			lblSearch.setBounds(10, 20, 46, 14);
		}
		return lblSearch;
	}

	public JList getList_1()
	{
		if (list_1 == null)
		{
			list_1 = new JList();
			list_1.setBounds(183, 48, 464, 387);
		}
		return list_1;
	}

	public JLabel getLblPlaylists()
	{
		if (lblPlaylists == null)
		{
			lblPlaylists = new JLabel("Playlists:");
			lblPlaylists.setBounds(10, 71, 59, 14);
		}
		return lblPlaylists;
	}

	public JLabel getLblSong()
	{
		if (lblSong == null)
		{
			lblSong = new JLabel("No Song selected");
			lblSong.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSong.setBounds(43, 446, 148, 36);
		}
		return lblSong;
	}

	public JLabel getLblPlaylist()
	{
		if (lblPlaylist == null)
		{
			lblPlaylist = new JLabel("Musicplayer");
			lblPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlaylist.setBounds(257, 8, 242, 34);
		}
		return lblPlaylist;
	}

	public JButton getBtnAddPlaylist()
	{
		if (btnAddPlaylist == null)
		{
			btnAddPlaylist = new JButton("Add Playlist");
			btnAddPlaylist.setHorizontalAlignment(SwingConstants.LEFT);
			btnAddPlaylist.setBounds(0, 48, 87, 23);
		}
		return btnAddPlaylist;
	}

	public JButton getBtnDeletePlaylist()
	{
		if (btnDeletePlaylist == null)
		{
			btnDeletePlaylist = new JButton(" Delete Playlist");
			btnDeletePlaylist.setHorizontalAlignment(SwingConstants.LEFT);
			btnDeletePlaylist.setBounds(76, 48, 103, 23);
		}
		return btnDeletePlaylist;
	}

	public JButton getBtnAddSong()
	{
		if (btnAddSong == null)
		{
			btnAddSong = new JButton("Add Song");
			btnAddSong.setBounds(434, 447, 110, 35);
		}
		return btnAddSong;
	}

	public JButton getBtnDeleteSong()
	{
		if (btnDeleteSong == null)
		{
			btnDeleteSong = new JButton("Delete Song");
			btnDeleteSong.setBounds(542, 447, 105, 35);
		}
		return btnDeleteSong;
	}
}