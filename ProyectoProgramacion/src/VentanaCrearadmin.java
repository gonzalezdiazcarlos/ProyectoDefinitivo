import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaCrearadmin extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JButton btnNewButton_1;
	private JPasswordField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearadmin frame = new VentanaCrearadmin();
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
	public VentanaCrearadmin() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setBounds(49, 80, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setBounds(49, 118, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA:");
		lblNewLabel_2.setBounds(49, 164, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(139, 77, 96, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(139, 115, 96, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(139, 161, 96, 20);
		contentPane.add(textContraseña);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = metodos.guardarAdmin(textCodigo.getText(), textNombre.getText(), textContraseña.getText());
				
				if (i>0) {
					JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
					
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no se han podido guardar");
				}
			}
		});
		btnNewButton.setBounds(146, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu ventana = new VentanaMenu();
				ventana.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(299, 213, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
