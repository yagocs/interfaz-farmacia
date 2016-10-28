import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class Repaso05Farmacia {

	private JFrame frame;
	private int codigo = 0;
	static Hashtable<Integer, Medicamentos> contenedor = new Hashtable<Integer, Medicamentos>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repaso05Farmacia window = new Repaso05Farmacia();
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
	public Repaso05Farmacia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton altas = new JButton("altas");
		altas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				codigo++;
				altas();
			}

		});
		frame.getContentPane().add(altas, BorderLayout.NORTH);

		JButton modificaciones = new JButton("modificaciones");
		modificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modify();
				
			}

			
		});
		frame.getContentPane().add(modificaciones, BorderLayout.WEST);

		JButton Consultas = new JButton("Consultas");
		Consultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consultas();
			}

		});
		frame.getContentPane().add(Consultas, BorderLayout.CENTER);

		JButton listados = new JButton("Listados");
		listados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listado();

			}

		});
		listados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(listados, BorderLayout.EAST);
		
		JButton savexit = new JButton("Guardar y Salir");
		savexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				savenex();
			}
		});
		frame.getContentPane().add(savexit, BorderLayout.SOUTH);
	}

	private void altas() {
		String nombre = JOptionPane.showInputDialog("Introduzca el nombre del medicamento");
		String lote = JOptionPane.showInputDialog("Itroduzca el lote");
		String laboratorio = JOptionPane.showInputDialog("Introduzca el laboratorio");
		String caducidad = JOptionPane.showInputDialog("Introduzca la caducidad--->dd/MM/yyyy");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date caduci = null;
		try {
			caduci = df.parse(caducidad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Float precio = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio"));
		Float IVA = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el IVA"));

		Medicamentos m = new Medicamentos(nombre, lote, laboratorio, caduci, precio, IVA);
		contenedor.put(codigo, m);

	}

	private void listado() {
		Enumeration<Integer> enumeration = contenedor.keys();
		while (enumeration.hasMoreElements()) {
			int k = (Integer) enumeration.nextElement();
			double price = contenedor.get(k).getPrecio();
			double TAX=1+contenedor.get(k).getIVA()/100;
			double importe=price*TAX;
			System.out.println(contenedor.get(k)+""+importe);
			
		}

		// TODO Auto-generated method stub

	}

	private void consultas() {

		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Codigo"));
		if (contenedor.containsKey(id)) {
			
			
			String result = id + " " + contenedor.get(id);
			JOptionPane.showMessageDialog(frame, result);
		}

	}
	private void savenex(){
	     FileOutputStream fs;
	     ObjectOutputStream  os=null;
	    try {
	      fs = new FileOutputStream("Farmacia.dat",true);
	        os = new ObjectOutputStream(fs);
	    } catch (FileNotFoundException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }catch (IOException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	     
	    Enumeration<Integer> enumeration = contenedor.keys();

	    while (enumeration.hasMoreElements()) {
	      Integer k = enumeration.nextElement();
	      try {
	        os.writeObject(k);
	        os.writeObject(contenedor.get(k));

	        
	      } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	    System.exit(0);
	  }
	private void modify() {
		

		int id = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Codigo"));
		if (contenedor.containsKey(id)) {
			String nombre = JOptionPane.showInputDialog("Introduzca el nombre del medicamento");
			String lote = JOptionPane.showInputDialog("Itroduzca el lote");
			String laboratorio = JOptionPane.showInputDialog("Introduzca el laboratorio");
			String caducidad = JOptionPane.showInputDialog("Introduzca la caducidad--->dd/MM/yyyy");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			Date caduci = null;
			try {
				caduci = df.parse(caducidad);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Float precio = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio"));
			Float IVA = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el IVA"));

			Medicamentos m = new Medicamentos(nombre, lote, laboratorio, caduci, precio, IVA);
			contenedor.put(id, m);

			
			
			
		}
		
	}
	public void loadData() {
	    ObjectInputStream os=null;
	    try {
	      FileInputStream fs = new FileInputStream("Farmacia.dat");
	      os = new ObjectInputStream(fs);
	      // solo recupera un objeto
	      // os debe realizar un casting al tipo original
	      while(true){ 
	        Integer codigo = (Integer) os.readObject();
	        Medicamentos Me = (Medicamentos) os.readObject();
	        //System.out.println(dni+" " +p);
	        contenedor.put(codigo, Me);
	        }
	      
	    } catch (ClassNotFoundException cnf) {
	      System.out.println("Error la clase");
	    } catch (FileNotFoundException fnfe) {
	      System.out.println("Fichero no encontrado, escribiendo un nuevo fichero");
	    } catch (IOException ioe) {
	      System.out.println();
	    } finally{
	      //try {
	        //os.close();
	      //} catch (IOException e) {
	        // TODO Auto-generated catch block
	      //  e.printStackTrace();
	      //}
	    }
	  }
}
