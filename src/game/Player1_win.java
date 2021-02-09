package game;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class Player1_win extends JDialog {

	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Player1_win dialog = new Player1_win();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Player1_win() {
		setTitle("Player_1 Wins");
		setSize(498,318);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		inicio();
	}
	
	private void inicio() {
		setPanel();
		
	}

	private void setPanel() {
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel victory = new JLabel("Victory!!!");
		victory.setFont(new Font("Arial Black", Font.BOLD, 20));
		victory.setForeground(Color.WHITE);
		victory.setHorizontalAlignment(SwingConstants.LEFT);
		victory.setBounds(10, 223, 150, 45);
		panel.add(victory);
		
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 482, 279);
		fondo.setIcon(new ImageIcon(getClass().getResource("/game/win.gif")));
		panel.add(fondo);
	}
}
