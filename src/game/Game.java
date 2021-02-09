package game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class Game {

	private JFrame frame;
	private JPanel panel;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem restart,salir;
	private JLabel player1,player2,marcador,cpuMarcador,mostrarGanador;
	private Border border;
	private JLabel cpu;
	private JButton boton_piedra,boton_papel,boton_tijera;
	
	public int puntaje=0,puntajeCpu=0;
	public String resultado,cpu_resultado;
	
	public static void main(String[] args) {
		/*
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setVentana();
		setMenubar();
		setPanel();
		setPlayer1();
		setPlayer2();
	}
	
	private void setVentana() {
		frame = new JFrame();
		frame.setBounds(100, 100, 807, 603);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Piedra_Papel_Tijera");
		frame.setLocationRelativeTo(null);
		
		//Logo de ventana
		Image logo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/game/logo.png"));
				frame.setIconImage(logo);
				frame.getContentPane().setLayout(null);
				
	}
	
	
	private void setMenubar() {
		border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
		
		barra = new JMenuBar();
		barra.setBorder(border);
		frame.setJMenuBar(barra);
		
		menu = new JMenu("Menu");
		
		restart = new JMenuItem("Restart");
		ImageIcon logo_restart = new ImageIcon(getClass().getResource("/game/new_game.png"));
		restart.setIcon(logo_restart);
		restart.addActionListener(evento_restart);
		
		salir = new JMenuItem("Salir");
		ImageIcon logo_salir = new ImageIcon(getClass().getResource("/game/salir.png"));
		salir.setIcon(logo_salir);
		salir.addActionListener(evento_menu);
		
		menu.add(restart);
		menu.add(salir);
		barra.add(menu);
		
	}
	
	private void setPanel(){
		panel = new JPanel();
		panel.setBounds(0, 0, 801, 550);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*
		border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
		JLabel principal = new JLabel();
		principal.setBorder(border);
		principal.setBackground(Color.WHITE);
		principal.setBounds(10, 11, 770, 241);
	
		ImageIcon logo_principal = new ImageIcon(getClass().getResource("/game/piedra_papel_tijera_.png"));
		principal.setIcon(new ImageIcon(logo_principal.getImage().getScaledInstance(770,550,Image.SCALE_SMOOTH)));
		
		panel.add(principal);
									*/
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 263, 781, 6);
		
		panel.add(separator);
		
		border = BorderFactory.createLineBorder(Color.MAGENTA,1);
		
		mostrarGanador = new JLabel("");
		mostrarGanador.setForeground(Color.MAGENTA);
		mostrarGanador.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarGanador.setBorder(border);
		mostrarGanador.setBounds(308, 315, 153, 59);
		panel.add(mostrarGanador);
		
		JLabel chan = new JLabel("Chan c:");
		
		chan.setForeground(Color.GREEN);
		chan.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		chan.setHorizontalAlignment(SwingConstants.RIGHT);
		chan.setBounds(735, 509, 45, 23);
		panel.add(chan);
		
	}
	
	private void setPlayer1(){
		border = BorderFactory.createLineBorder(Color.BLUE, 2);
		player1 = new JLabel("");
		player1.setBounds(50, 280, 243, 143);
		player1.setBorder(border);
		panel.add(player1);
		
		boton_piedra = new JButton();
		boton_piedra.setBackground(Color.BLACK);
		boton_piedra.setBorder(null);
		boton_piedra.setIcon(new ImageIcon(getClass().getResource("/game/piedra_.png")));
		boton_piedra.setBounds(97, 36, 153, 143);
		boton_piedra.addActionListener(evento_player1);
		
		panel.add(boton_piedra);
		
		boton_papel = new JButton();
		boton_papel.setBorder(null);
		boton_papel.setBackground(Color.BLACK);
		boton_papel.setIcon(new ImageIcon(getClass().getResource("/game/papel_.png")));
		boton_papel.setBounds(295, 21, 188, 168);
		boton_papel.addActionListener(evento_player1);
		
		panel.add(boton_papel);
		
		boton_tijera = new JButton("");
		boton_tijera.setBackground(Color.BLACK);
		boton_tijera.setBorder(null);
		boton_tijera.setIcon(new ImageIcon(getClass().getResource("/game/tijera_.png")));
		boton_tijera.setBounds(511, 21, 176, 168);
		boton_tijera.addActionListener(evento_player1);
		
		panel.add(boton_tijera);
		
		marcador = new JLabel("0");
		marcador.setFont(new Font("Tahoma", Font.BOLD, 11));
		marcador.setForeground(Color.GREEN);
		marcador.setHorizontalAlignment(SwingConstants.CENTER);
		marcador.setBounds(132, 478, 54, 31);
		panel.add(marcador);
	}
	
	private void setPlayer2() {
		border = BorderFactory.createLineBorder(Color.RED, 2);
		
		player2 = new JLabel();
		player2.setBounds(482, 280, 243, 143);
		player2.setBorder(border);
		panel.add(player2);
		
		cpu = new JLabel("CPU");
		cpu.setForeground(Color.GREEN);
		cpu.setFont(new Font("Tahoma", Font.BOLD, 11));
		cpu.setHorizontalAlignment(SwingConstants.CENTER);
		cpu.setBounds(511, 446, 195, 19);
		panel.add(cpu);	
		
		cpuMarcador = new JLabel("0");
		cpuMarcador.setForeground(Color.GREEN);
		cpuMarcador.setFont(new Font("Tahoma", Font.BOLD, 11));
		cpuMarcador.setHorizontalAlignment(SwingConstants.CENTER);
		cpuMarcador.setBounds(581, 478, 54, 31);
		panel.add(cpuMarcador);
		
	}
	
	ActionListener evento_menu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == salir ) {
				System.exit(0);	
			}
			
		}
	};
	
	ActionListener evento_player1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == boton_piedra){
				 ImageIcon opcion = new ImageIcon(getClass().getResource("/game/piedra.png"));
				 player1.setIcon(new ImageIcon(opcion.getImage().getScaledInstance(player1.getWidth(), player1.getHeight(), Image.SCALE_SMOOTH)));
				 resultado = "piedra";
				 
				//Numero aleatorio
					Random aleatorio = new Random();
					int numero = aleatorio.nextInt(3);
					
					if(numero == 0){
						ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/piedra.png"));
						player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
						cpu_resultado ="piedra";
					}	
					
					else if(numero == 1) {
						ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/papel.png"));
						player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
						cpu_resultado ="papel";
					}
					else {
						ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/tijera.png"));
						player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
						cpu_resultado ="tijera";
					}
			}

			else if(e.getSource() == boton_papel) {
				ImageIcon opcion = new ImageIcon(getClass().getResource("/game/papel.png"));
				player1.setIcon(new ImageIcon(opcion.getImage().getScaledInstance(player1.getWidth(), player1.getHeight(), Image.SCALE_SMOOTH)));
				resultado = "papel";
				
				//Numero aleatorio
				Random aleatorio = new Random();
				int numero = aleatorio.nextInt(3);
				
				if(numero == 0){
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/piedra.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="piedra";
				}	
				
				else if(numero == 1) {
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/papel.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="papel";
				}
				else {
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/tijera.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="tijera";
				}
				
				
			}
			else {
				ImageIcon opcion = new ImageIcon(getClass().getResource("/game/tijera.png"));
				player1.setIcon(new ImageIcon(opcion.getImage().getScaledInstance(player1.getWidth(), player1.getHeight(), Image.SCALE_SMOOTH)));
				resultado = "tijera";
				
				//Numero aleatorio
				Random aleatorio = new Random();
				int numero = aleatorio.nextInt(3);
	
				if(numero == 0){
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/piedra.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="piedra";
				}	
				
				else if(numero == 1) {
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/papel.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="papel";
				}
				else {
					ImageIcon opcionCpu = new ImageIcon(getClass().getResource("/game/tijera.png"));
					player2.setIcon(new ImageIcon(opcionCpu.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
					cpu_resultado ="tijera";
				}
			}
			
			getWinner();
		}
	};
	
	ActionListener evento_restart = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			puntaje=0;
			puntajeCpu=0;
			marcador.setText("0");
			cpuMarcador.setText("0");
			mostrarGanador.setText("");
		}
	};
	
	public void getWinner() {
		//Empate
		if(this.resultado.equalsIgnoreCase(this.cpu_resultado) ) {
			mostrarGanador.setText("Empate!!");
			
			Tie_game empate = new Tie_game();
			empate.setVisible(true);
		}
		//Piedra
		if(this.resultado.equals("piedra") && this.cpu_resultado.equals("tijera")){
			mostrarGanador.setText("Player 1 Win");
			++puntaje;
			marcador.setText(String.valueOf(puntaje));
			
			Player1_win jugador1 = new Player1_win();
			jugador1.setVisible(true);
			
		}
		else if(this.cpu_resultado.equals("piedra") && this.resultado.equals("tijera")){
			mostrarGanador.setText(" CPU WIN! ");
			++puntajeCpu;
			cpuMarcador.setText(String.valueOf(puntajeCpu));
			
			Cpu_win cpu1 = new Cpu_win();
			cpu1.setVisible(true);
		}
		//Papel
		if(this.resultado.equals("papel") && this.cpu_resultado.equals("piedra")){
			mostrarGanador.setText("Player 1 Win");
			++puntaje;
			marcador.setText(String.valueOf(puntaje));
			
			Player1_win jugador1 = new Player1_win();
			jugador1.setVisible(true);
		}
		else if(this.cpu_resultado.equals("papel") && this.resultado.equals("piedra")){
			mostrarGanador.setText(" CPU WIN! ");
			++puntajeCpu;
			cpuMarcador.setText(String.valueOf(puntajeCpu));
			
			Cpu_win cpu1 = new Cpu_win();
			cpu1.setVisible(true);
			}
			
		//Tijera
		if(this.resultado.equals("tijera") && this.cpu_resultado.equals("papel")){
			mostrarGanador.setText("Player 1 Win");
			++puntaje;
			marcador.setText(String.valueOf(puntaje));
			
			Player1_win jugador1 = new Player1_win();
			jugador1.setVisible(true);
			}
		
		else if(this.cpu_resultado.equals("tijera") && this.resultado.equals("papel")){
			mostrarGanador.setText(" CPU WIN! ");
			++puntajeCpu;
			cpuMarcador.setText(String.valueOf(puntajeCpu));
			
			Cpu_win cpu1 = new Cpu_win();
			cpu1.setVisible(true);
			}
	}	
}
