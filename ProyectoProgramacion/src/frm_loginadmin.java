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

public class frm_loginadmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCODIGO;
	private JPasswordField txtCONTRASEÑA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_loginadmin frame = new frm_loginadmin();
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
	public frm_loginadmin() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setBounds(72, 97, 80, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA:");
		lblNewLabel_1.setBounds(72, 197, 80, 25);
		contentPane.add(lblNewLabel_1);
		
		txtCODIGO = new JTextField();
		txtCODIGO.setBounds(138, 99, 96, 20);
		contentPane.add(txtCODIGO);
		txtCODIGO.setColumns(10);
		
		txtCONTRASEÑA = new JPasswordField();
		txtCONTRASEÑA.setBounds(162, 199, 96, 20);
		contentPane.add(txtCONTRASEÑA);
		
		JLabel lblNewLabel_2 = new JLabel("INICIAR SESION");
		lblNewLabel_2.setBounds(336, 27, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busqueda_usuario = metodos.buscarAdminRegistrado(txtCODIGO.getText(),txtCONTRASEÑA.getText());
				
				if(busqueda_usuario.equals("usuario encontrado")) {
					String busqueda_nombre = metodos.buscarNombreAdmin(txtCODIGO.getText());
					JOptionPane.showMessageDialog(null, "Bienvenido" + busqueda_nombre);
					frm_admin ventana = new frm_admin();
					ventana.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(262, 297, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_menu ventana = new frm_menu();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(381, 297, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
