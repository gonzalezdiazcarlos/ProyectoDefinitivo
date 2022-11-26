import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_loginusuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtContraseña;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_loginusuario frame = new frm_loginusuario();
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
	public frm_loginusuario() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicia Sesión");
		lblNewLabel.setBounds(329, 47, 93, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA:");
		lblNewLabel_2.setBounds(101, 210, 80, 31);
		contentPane.add(lblNewLabel_2);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(268, 215, 193, 20);
		contentPane.add(txtContraseña);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busqueda_usuario = metodos.buscarUsuarioRegistrado(txtCorreo.getText(),txtContraseña.getText());
				
				if(busqueda_usuario.equals("usuario encontrado")) {
					String busqueda_nombre = metodos.buscarNombre(txtCorreo.getText());
					JOptionPane.showMessageDialog(null, "Bienvenido" + busqueda_nombre);
					frm_usuariomain ventana = new frm_usuariomain();
					ventana.setVisible(true);
					dispose();
				}
			} 
		});
		btnEntrar.setBounds(268, 300, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_menu ventana = new frm_menu ();
				ventana.setVisible(true);
				dispose();

			}
		});
		btnRegresar.setBounds(372, 300, 89, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel_1 = new JLabel("CORREO:");
		lblNewLabel_1.setBounds(101, 144, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(268, 141, 193, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
	}
}
