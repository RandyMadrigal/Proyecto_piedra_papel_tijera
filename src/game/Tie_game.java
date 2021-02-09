package game;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;


public class Tie_game extends JDialog {

	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tie_game dialog = new Tie_game();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tie_game() {
		setTitle("Cpu Wins!");
		setSize(498,392);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(null);
		
		inicio();
	}
	
	private void inicio() {
		setPanel();
		
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 492, 363);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel tie_game = new JLabel("TIE GAME!!!! XD");
		tie_game.setForeground(Color.WHITE);
		tie_game.setFont(new Font("Arial Black", Font.BOLD, 15));
		tie_game.setHorizontalAlignment(SwingConstants.CENTER);
		tie_game.setBounds(131, 11, 222, 50);
		panel.add(tie_game);
		
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(Cpu_win.class.getResource("/game/tie.gif")));
		fondo.setBounds(0, 0, 492, 360);
		panel.add(fondo);
		
	}

}
