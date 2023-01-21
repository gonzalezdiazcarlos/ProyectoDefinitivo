import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Calzado;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaCalzadoDeportivo extends JFrame {

	private JPanel contentPane;
	public String DatoCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalzadoDeportivo frame = new VentanaCalzadoDeportivo();
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
	public VentanaCalzadoDeportivo() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCestaCompra = new JButton("Cesta");
		btnCestaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCestaCompra ventana = new VentanaCestaCompra();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		JLabel lblTitulo1 = new JLabel("Adidas Spezial:");
		lblTitulo1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo1.setBounds(23, 44, 204, 25);
		contentPane.add(lblTitulo1);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTalla.setBounds(23, 186, 59, 25);
		contentPane.add(lblTalla);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidad.setBounds(23, 222, 91, 25);
		contentPane.add(lblCantidad);
		
		JComboBox comboBoxTalla1 = new JComboBox();
		comboBoxTalla1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxTalla1.setModel(new DefaultComboBoxModel(new String[] {"39", "40", "41", "42", "43", "44", "45", "46"}));
		comboBoxTalla1.setBounds(92, 190, 51, 22);
		contentPane.add(comboBoxTalla1);
		
		JComboBox comboBoxCantidad1 = new JComboBox();
		comboBoxCantidad1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxCantidad1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBoxCantidad1.setBounds(113, 226, 51, 22);
		contentPane.add(comboBoxCantidad1);
		
		JLabel lblTitulo2 = new JLabel("Adidas Busenitz:");
		lblTitulo2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo2.setBounds(343, 44, 204, 25);
		contentPane.add(lblTitulo2);
		
		JLabel lblTalla_1 = new JLabel("Talla:");
		lblTalla_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTalla_1.setBounds(343, 186, 59, 25);
		contentPane.add(lblTalla_1);
		
		JComboBox comboBoxTalla2 = new JComboBox();
		comboBoxTalla2.setModel(new DefaultComboBoxModel(new String[] {"39", "40", "41", "42", "43", "44", "45", "46"}));
		comboBoxTalla2.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxTalla2.setBounds(412, 190, 51, 22);
		contentPane.add(comboBoxTalla2);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidad_1.setBounds(343, 222, 91, 25);
		contentPane.add(lblCantidad_1);
		
		JComboBox comboBoxCantidad2 = new JComboBox();
		comboBoxCantidad2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBoxCantidad2.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxCantidad2.setBounds(433, 226, 51, 22);
		contentPane.add(comboBoxCantidad2);
		
		VentanaLoginusuario frm = new VentanaLoginusuario();
		DatoCorreo = frm.DatoCorreo;
		
		JButton btnCesta1 = new JButton("Añadir a cesta");
		btnCesta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object cantidad = comboBoxCantidad1.getSelectedItem();
				String Cantidad = String.valueOf(cantidad);
				
				Object talla = comboBoxTalla1.getSelectedItem();
				String Talla = String.valueOf(talla);
				
				
				ArrayList<Calzado>calzado = metodos.getCalzado("Adidas Spezial");
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
		btnCesta1.setBounds(23, 277, 141, 23);
		contentPane.add(btnCesta1);
		
		JButton btnCesta2 = new JButton("Añadir a cesta");
		btnCesta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object cantidad = comboBoxCantidad2.getSelectedItem();
				String Cantidad = String.valueOf(cantidad);
				
				Object talla = comboBoxTalla2.getSelectedItem();
				String Talla = String.valueOf(talla);
				
				
				ArrayList<Calzado>calzado = metodos.getCalzado("Adidas Busenitz");
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
		btnCesta2.setBounds(343, 277, 141, 23);
		contentPane.add(btnCesta2);
		
		JLabel lblPrecio = new JLabel("90 $");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio.setBounds(23, 154, 49, 25);
		contentPane.add(lblPrecio);
		
		JLabel lblPrecio_1 = new JLabel("95 $");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio_1.setBounds(343, 150, 49, 25);
		contentPane.add(lblPrecio_1);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCalzadoHombre frm = new VentanaCalzadoHombre();
				frm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(704, 420, 89, 23);
		contentPane.add(btnNewButton);
	}
}
