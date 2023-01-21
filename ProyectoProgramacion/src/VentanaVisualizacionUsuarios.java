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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaVisualizacionUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField DireccionFichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVisualizacionUsuarios frame = new VentanaVisualizacionUsuarios();
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
	public VentanaVisualizacionUsuarios() {
		
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
		btnEliminar.setBounds(492, 318, 119, 43);
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
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin ventana = new VentanaAdmin();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(621, 382, 119, 43);
		contentPane.add(btnRegresar);
		
		JButton btnFichero = new JButton("Mandar a fichero");
		btnFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList <Usuario> usuarios = metodos.getUsuarios();
				if(usuarios!=null) {
						try(FileWriter writer = new FileWriter(DireccionFichero.getText()+"\\usuarios.txt")) {
							for(Usuario u :  usuarios) {
								writer.nullWriter();
								String Usuario = u.getNombre() + "," + u.getCorreo() + "," + u.getContraseña();
								writer.write(Usuario);
								writer.write("\n");
							}
							writer.close();
						}catch (IOException e3) {
							System.out.println("Error");
						}
						JOptionPane.showMessageDialog(null, "Datos escritos correctamente");
				}
			}
		});
		btnFichero.setBounds(227, 392, 151, 23);
		contentPane.add(btnFichero);
		
		JLabel lblTitulo2 = new JLabel("Introduce la direccion del fichero donde quieres guardar los datos:");
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo2.setBounds(10, 319, 361, 14);
		contentPane.add(lblTitulo2);
		
		DireccionFichero = new JTextField();
		DireccionFichero.setBounds(10, 352, 368, 20);
		contentPane.add(DireccionFichero);
		DireccionFichero.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Ordenar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortUsuarios(listaClientes);
			}
			private void sortUsuarios(JList listaClientes) {
				List<Usuario> usuarios = MetodosUsuario_sql.ordenarUsuarios();
				 DefaultListModel model = (DefaultListModel)listaClientes.getModel();
				  model.clear();
				  for (Usuario usuario : usuarios) {
				    model.addElement(usuario);
				    
				  }

			}
		});
		btnNewButton.setBounds(649, 55, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(DireccionFichero.getText());
			}
		});
		btnNewButton_1.setBounds(270, 426, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
