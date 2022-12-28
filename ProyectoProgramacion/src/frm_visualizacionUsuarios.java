import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frm_visualizacionUsuarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_visualizacionUsuarios frame = new frm_visualizacionUsuarios();
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
	public frm_visualizacionUsuarios() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Los clientes registrados son los siguientes:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo.setBounds(10, 35, 368, 43);
		contentPane.add(lblTitulo);
		
		DefaultListModel modelo = new DefaultListModel<>();
		
		JList listaClientes = new JList();
		listaClientes.setBounds(10, 89, 730, 198);
		listaClientes.setModel(modelo);
		contentPane.add(listaClientes);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Datos = listaClientes.getSelectedValue().toString();
				//dividir los 3 elementos por las comas, coger el elemento del medio.
				String [] Correo = Datos.split(",");
				int i = metodos.EliminarUsuario(Correo[1]);
				if( i > 0 ) {
					JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"no se pudo eliminar los datos");
				}
				
				
			}
		});
		btnEliminar.setBounds(10, 318, 119, 43);
		contentPane.add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Usuario> usuarios = metodos.getUsuarios();
				modelo.clear();
				if (usuarios != null) {
					for (Usuario u : usuarios) {
						String nombre = u.getNombre();
						String Correo = u.getCorreo();
						String contraseña = u.getContraseña();
						String Final = nombre + "," + Correo + "," + contraseña;
						modelo.addElement(Final);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "No hay ningun usuario que cargar");
				}
			}
		});
		btnMostrar.setBounds(621, 318, 119, 43);
		contentPane.add(btnMostrar);
	}
}
