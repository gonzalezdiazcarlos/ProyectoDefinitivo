import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Calzado;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frm_calzadoCasual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_calzadoCasual frame = new frm_calzadoCasual();
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
	public frm_calzadoCasual() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCestaCompra = new JButton("Cesta");
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(690, 431, 103, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblCasual1 = new JLabel("");
		lblCasual1.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\Casual1.jpg"));
		lblCasual1.setBounds(53, 50, 203, 169);
		contentPane.add(lblCasual1);
		
		JButton btnAñadirCesta = new JButton("Añadir Cesta");
		btnAñadirCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Calzado>calzado = metodos.getCalzado("Bratton Lace");
				
				
			}
		});
		btnAñadirCesta.setBounds(53, 353, 159, 23);
		contentPane.add(btnAñadirCesta);
		
		JLabel lblPrecio = new JLabel("100 $");
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio.setBounds(52, 230, 77, 23);
		contentPane.add(lblPrecio);
		
		JLabel lblNombreZapato = new JLabel("Bratton Lace");
		lblNombreZapato.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreZapato.setBounds(53, 15, 141, 31);
		contentPane.add(lblNombreZapato);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTalla.setBounds(53, 275, 60, 23);
		contentPane.add(lblTalla);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"39", "40", "41", "42", "43", "44", "45", "46"}));
		comboBox.setBounds(109, 276, 51, 22);
		contentPane.add(comboBox);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCantidad.setBounds(53, 309, 97, 23);
		contentPane.add(lblCantidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox_1.setBounds(143, 312, 51, 22);
		contentPane.add(comboBox_1);
	}
}
