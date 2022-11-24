import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_login frame = new frm_login();
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
	public frm_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicia Sesión");
		lblNewLabel.setBounds(329, 47, 93, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lbl = new JLabel("USUARIO:");
		lbl.setBounds(101, 133, 80, 31);
		contentPane.add(lbl);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA:");
		lblNewLabel_2.setBounds(101, 217, 80, 31);
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(268, 138, 193, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(268, 222, 193, 20);
		contentPane.add(txtContraseña);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(275, 292, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_menu ventana = new frm_menu ();
				ventana.setVisible(true);
				dispose();

			}
		});
		btnRegresar.setBounds(380, 292, 89, 23);
		contentPane.add(btnRegresar);
	}
}
