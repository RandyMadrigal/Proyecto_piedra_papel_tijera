package game;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class Cpu_win extends JDialog {

	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cpu_win dialog = new Cpu_win();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cpu_win() {
	
		setTitle("Cpu Wins!");
		setSize(512,392);
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
		panel.setBounds(0, 0, 507, 363);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Cpu_win.class.getResource("/game/lose.gif")));
		fondo.setBounds(0, 0, 507, 360);
		panel.add(fondo);
		
		
	}
	

}
