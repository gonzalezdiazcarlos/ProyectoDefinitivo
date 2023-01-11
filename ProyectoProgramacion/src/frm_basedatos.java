import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class frm_basedatos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_basedatos frame = new frm_basedatos();
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
	public frm_basedatos() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_visualizacionUsuarios ventana = new frm_visualizacionUsuarios();
				ventana.setVisible(true);
				dispose();
				}
		});
		btnNewButton.setBounds(60, 26, 107, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver Administradores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_visualizacionAdmins ventana = new frm_visualizacionAdmins();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(229, 26, 144, 23);
		contentPane.add(btnNewButton_1);
		
		JList list = new JList();
		list.setBounds(373, 221, -282, -101);
		contentPane.add(list);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin ventana = new VentanaAdmin();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(284, 221, 89, 23);
		contentPane.add(btnRegresar);
	}
	
	private Connection conn;
	private Connection conectar() {
		Connection conn = null;
		String url = "jdbc:sqlite.BDproyecto.db";
		try {
			
			conn = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return conn;
	}
}
