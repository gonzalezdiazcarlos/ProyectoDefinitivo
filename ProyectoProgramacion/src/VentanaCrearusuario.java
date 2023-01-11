import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utilidades.Newsletter;
import basesdedatos.MetodosUsuario_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaCrearusuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearusuario frame = new VentanaCrearusuario();
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
	public VentanaCrearusuario() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(63, 97, 78, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CORREO:");
		lblNewLabel_1.setBounds(63, 168, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setBounds(63, 231, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("ALTA USUARIO");
		lblNewLabel_4.setBounds(323, 42, 119, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(151, 103, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(151, 165, 96, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(151, 228, 96, 20);
		contentPane.add(txtContraseña);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = metodos.guardar(txtNombre.getText(),txtCorreo.getText(),txtContraseña.getText());
				
				if( i > 0 ) {
					JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
					Newsletter newsletter = null;
					try {
						newsletter = new Newsletter("proyectodefinitivoprogram@gmail.com");
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					try {newsletter.signUpMail(txtCorreo.getText());
					} catch (MessagingException e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"no se pudo guardar los datos");
				}
				
			}
		});
		btnGuardar.setBounds(251, 352, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu ventana = new VentanaMenu ();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(385, 352, 89, 23);
		contentPane.add(btnRegresar);
	}

}
