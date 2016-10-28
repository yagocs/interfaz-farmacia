package EjercicioRepaso1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana01 window = new Ventana01();
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
	public Ventana01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton altas = new JButton("Altas");
		altas.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent arg0) {
				long SS = Long.parseLong(JOptionPane.showInputDialog("Introduzca el número de la SS"));
				String nombre = JOptionPane.showInputDialog("Introduzca el número de la SS");
				
			}
		});
		frame.getContentPane().add(altas, BorderLayout.NORTH);
		
		JButton modificaciones = new JButton("Modificaciones");
		modificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.getContentPane().add(modificaciones, BorderLayout.WEST);
		
		JButton consultaSS = new JButton("Consulta por SS");
		consultaSS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.getContentPane().add(consultaSS, BorderLayout.CENTER);
		
		JButton listadoSexo = new JButton("Listado por Sexo");
		listadoSexo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showInputDialog(listadoSexo);
			}
		});
		frame.getContentPane().add(listadoSexo, BorderLayout.SOUTH);
		
		JButton listadocompleto = new JButton("Listado Completo");
		listadocompleto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.getContentPane().add(listadocompleto, BorderLayout.EAST);
	}

}
