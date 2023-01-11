import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
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
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Cuenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearadmin ventana = new VentanaCrearadmin();
				ventana.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(302, 205, 124, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BaseDatos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaBasedatos ventana = new VentanaBasedatos();
				ventana.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(172, 209, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cerrar sesión");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLoginadmin ventana = new VentanaLoginadmin();
				ventana.setVisible(true);
				dispose();
			}
		});
		JButton btnNewButton_x = new JButton("Ver clientes y facturacion");
		btnNewButton_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaFacturacion ventana = new VentanaFacturacion();
				ventana.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_x.setBounds(172, 209, 89, 23);
		contentPane.add(btnNewButton_x);
		
		
		
		btnNewButton_2.setBounds(29, 209, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Bienvenido, has iniciado sesión como ADMINISTRADOR");
		lblNewLabel.setBounds(89, 44, 294, 104);
		contentPane.add(lblNewLabel);
	}
}
