import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Calzado;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaCalzadoBotas extends JFrame {

	private JPanel contentPane;
	public String DatoCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalzadoBotas frame = new VentanaCalzadoBotas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCalzadoBotas() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCestaCompra = new JButton("Cesta");
		btnCestaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCesta ventana = new VentanaCesta();
				ventana.setVisible(true);
				dispose();
				
			}
		});
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		VentanaLoginusuario frm = new VentanaLoginusuario();
		DatoCorreo = frm.DatoCorreo;
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCalzadoMujer frm = new VentanaCalzadoMujer();
				frm.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(690, 431, 103, 23);
		contentPane.add(btnRegresar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox_1.setBounds(143, 312, 51, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"35", "36", "37", "38", "39", "40", "41"}));
		comboBox.setBounds(109, 276, 51, 22);
		contentPane.add(comboBox);
		
		JButton btnAñadirCesta = new JButton("Añadir Cesta");
		btnAñadirCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object cantidad = comboBox_1.getSelectedItem();
				String Cantidad = String.valueOf(cantidad);
				
				Object talla = comboBox.getSelectedItem();
				String Talla = String.valueOf(talla);
				
				
				ArrayList<Calzado>calzado = metodos.getCalzado("Botas Chelsea");
				for(Calzado c : calzado) {
					String Codigo = c.getCodigo();
					String Nombre = c.getNombre();
					String Tipo = c.getTipo();
					//cantidad
					String Precio = c.getPrecio();
					String Color = c.getColor();
					//talla
					String Genero = c.getGenero();
					
					int i= metodos.guardarPedidos(DatoCorreo,Codigo,Nombre,Tipo,Cantidad,Precio,Color,Talla,Genero);
					if( i > 0 ) {
						JOptionPane.showMessageDialog(null, "Datos añadidos a la cesta correctamente");
					}else {
						JOptionPane.showMessageDialog(null,"no se pudo añadir los datos a la cesta");
					}
				}
				
			}
		});
		btnAñadirCesta.setBounds(53, 353, 159, 23);
		contentPane.add(btnAñadirCesta);
		
		JLabel lblPrecio = new JLabel("100 $");
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio.setBounds(52, 230, 77, 23);
		contentPane.add(lblPrecio);
		
		JLabel lblNombreZapato = new JLabel("Botas Chelsea");
		lblNombreZapato.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreZapato.setBounds(53, 15, 141, 31);
		contentPane.add(lblNombreZapato);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTalla.setBounds(53, 275, 60, 23);
		contentPane.add(lblTalla);
		
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidad.setBounds(53, 309, 97, 23);
		contentPane.add(lblCantidad);
		
		JLabel lblHanfordLauren = new JLabel("Plumers 9314");
		lblHanfordLauren.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHanfordLauren.setBounds(349, 15, 186, 31);
		contentPane.add(lblHanfordLauren);
		
		JLabel lblPrecio_1 = new JLabel("150 $");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio_1.setBounds(349, 230, 77, 23);
		contentPane.add(lblPrecio_1);
		
		JLabel lblTalla_1 = new JLabel("Talla:");
		lblTalla_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTalla_1.setBounds(349, 275, 60, 23);
		contentPane.add(lblTalla_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"35", "36", "37", "38", "39", "40", "41"}));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox_2.setBounds(405, 276, 51, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidad_1.setBounds(349, 309, 97, 23);
		contentPane.add(lblCantidad_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1_1.setBounds(439, 312, 51, 22);
		contentPane.add(comboBox_1_1);
		
		JButton btnAñadirCesta_1 = new JButton("Añadir Cesta");
		btnAñadirCesta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object cantidad = comboBox_1_1.getSelectedItem();
				String Cantidad = String.valueOf(cantidad);
				
				Object talla = comboBox_2.getSelectedItem();
				String Talla = String.valueOf(talla);
				
				
				ArrayList<Calzado>calzado = metodos.getCalzado("Plumers 9314");
				for(Calzado c : calzado) {
					String Codigo = c.getCodigo();
					String Nombre = c.getNombre();
					String Tipo = c.getTipo();
					//cantidad
					String Precio = c.getPrecio();
					String Color = c.getColor();
					//talla
					String Genero = c.getGenero();
					
					int i= metodos.guardarPedidos(DatoCorreo,Codigo,Nombre,Tipo,Cantidad,Precio,Color,Talla,Genero);
					if( i > 0 ) {
						JOptionPane.showMessageDialog(null, "Datos añadidos a la cesta correctamente");
					}else {
						JOptionPane.showMessageDialog(null,"no se pudo añadir los datos a la cesta");
					}
				}
			}
		});
		btnAñadirCesta_1.setBounds(349, 353, 159, 23);
		contentPane.add(btnAñadirCesta_1);
		
	
		
	}
}
