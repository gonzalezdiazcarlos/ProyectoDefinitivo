import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Administrador;
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

public class frm_visualizacionAdmins extends JFrame {

	private JPanel contentPane;
	private JTextField DireccionFichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_visualizacionAdmins frame = new frm_visualizacionAdmins();
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
	public frm_visualizacionAdmins() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Los usuarios administradores son los siguientes:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo.setBounds(10, 47, 380, 14);
		contentPane.add(lblTitulo);
		
		DefaultListModel modelo = new DefaultListModel();
		
		JList ListaAdmins = new JList();
		ListaAdmins.setBounds(10, 87, 698, 214);
		ListaAdmins.setModel(modelo);
		contentPane.add(ListaAdmins);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Datos = ListaAdmins.getSelectedValue().toString();
				//dividir los 3 elementos por las comas, coger el elemento del medio.
				String [] Codigo = Datos.split(",");
				int i = metodos.EliminarAdmin(Codigo[0]);
				if( i > 0 ) {
					JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"no se pudo eliminar los datos");
				}
				
				
			}
		});
		btnEliminar.setBounds(440, 352, 122, 58);
		contentPane.add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Administrador> admins = metodos.getAdmins();
				modelo.clear();
				if(admins!= null) {
					for(Administrador a : admins) {
						String Codigo = a.getCodigo();
						String Nombre = a.getNombre();
						String Contraseña = a.getContraseña();
						String Final =  Codigo + "," + Nombre + "," + Contraseña;
						modelo.addElement(Final);
					}
				}else {
					JOptionPane.showMessageDialog(null, "No hay ningun admin que cargar");
				}
			}
		});
		btnMostrar.setBounds(586, 352, 122, 58);
		contentPane.add(btnMostrar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_admin ventana = new frm_admin();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(586, 435, 122, 58);
		contentPane.add(btnRegresar);
		
		JLabel lblTitulo2 = new JLabel("Introduce la direccion de fichero donde quieres guardar los datos:");
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo2.setBounds(10, 352, 387, 14);
		contentPane.add(lblTitulo2);
		
		DireccionFichero = new JTextField();
		DireccionFichero.setBounds(10, 377, 361, 20);
		contentPane.add(DireccionFichero);
		DireccionFichero.setColumns(10);
		
		JButton btnMostrarFichero = new JButton("Mandar a fichero");
		btnMostrarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList <Administrador> admins = metodos.getAdmins();
				if(admins!=null) {
						try(FileWriter writer = new FileWriter(DireccionFichero.getSelectedText())) {
							for(Administrador a :  admins) {
								writer.nullWriter();
								String Usuario = a.getCodigo() + "," + a.getNombre() + "," + a.getContraseña();
								writer.write(Usuario);
								writer.write("\n");
							}
						}catch (IOException e3) {
							System.out.println("Error");
						}
						JOptionPane.showMessageDialog(null, "Datos escritos correctamente");
				}
			}
		});
		btnMostrarFichero.setBounds(247, 408, 122, 23);
		contentPane.add(btnMostrarFichero);
		
		JButton btnNewButton = new JButton("Ordenar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortAdmins(ListaAdmins);
			}
			
			private void sortAdmins(JList ListaAdmins) {
				List<Administrador> admins = MetodosUsuario_sql.ordenarAdmin();
				 DefaultListModel model = (DefaultListModel)ListaAdmins.getModel();
				  model.clear();
				  for (Administrador admin : admins) {
				    model.addElement(admin);
				    
				  }
				  
			}
		});
		btnNewButton.setBounds(611, 53, 89, 23);
		contentPane.add(btnNewButton);
	}
}
