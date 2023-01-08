import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesdedatos.MetodosUsuario_sql;
import clases.Pedidos;
import clases.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_cesta extends JFrame {

	private JPanel contentPane;
	public String DatoCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_cesta frame = new frm_cesta();
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
	public frm_cesta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frm_loginusuario frm = new frm_loginusuario();
		DatoCorreo = frm.DatoCorreo;
		
		JLabel lblTitulo = new JLabel("Bienvenido " + DatoCorreo + " esta es tu cesta de la compra:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(10, 29, 746, 49);
		contentPane.add(lblTitulo);
		
		DefaultListModel modelo = new DefaultListModel();
		
		JList list = new JList();
		list.setBounds(20, 89, 589, 252);
		list.setModel(modelo);
		contentPane.add(list);
		
		ArrayList<Pedidos> Pedidos = metodos.getPedidos(DatoCorreo);
		modelo.clear();
		if (Pedidos != null) {
			for (Pedidos p : Pedidos) {
				String Codigo = p.getCodigo();
				String Nombre = p.getNombre();
				String Tipo = p.getTipo();
				String Cantidad = p.getCantidad();
				String precio = p.getPrecio();
				String color = p.getColor();
				String Talla = p.getTalla();
				String Genero = p.getGenero();
				String Final = Codigo + "," + Nombre + "," + Tipo + "," + Cantidad + "," + precio + "," + color + "," + Talla + "," + Genero;
				modelo.addElement(Final);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "La cesta esta vacia");
		}
		
		
		JButton btnMostrar = new JButton("Recargar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pedidos> Pedidos = metodos.getPedidos(DatoCorreo);
				modelo.clear();
				if (Pedidos != null) {
					for (Pedidos p : Pedidos) {
						String Codigo = p.getCodigo();
						String Nombre = p.getNombre();
						String Tipo = p.getTipo();
						String Cantidad = p.getCantidad();
						String precio = p.getPrecio();
						String color = p.getColor();
						String Talla = p.getTalla();
						String Genero = p.getGenero();
						String Final = Codigo + "," + Nombre + "," + Tipo + "," + Cantidad + "," + precio + "," + color + "," + Talla + "," + Genero;
						modelo.addElement(Final);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "La cesta esta vacia");
				}			
			}
		});
		btnMostrar.setBounds(30, 353, 97, 33);
		contentPane.add(btnMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Datos = list.getSelectedValue().toString();
				String [] DatosIndividuales = Datos.split(",");
				String Codigo = DatosIndividuales[0];
				String Nombre = DatosIndividuales[1];
				String Tipo = DatosIndividuales[2];
				String Cantidad = DatosIndividuales[3];
				String Precio = DatosIndividuales[4];
				String Color = DatosIndividuales[5];
				String Talla = DatosIndividuales[6];
				String Genero = DatosIndividuales[7];
				
				int i = metodos.EliminarPedido(DatoCorreo, Codigo, Nombre, Tipo, Cantidad, Precio, Color, Talla, Genero);
				if( i > 0 ) {
					JOptionPane.showMessageDialog(null, "Pedido eliminado Correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"no se pudo eliminar el pedido");
				}
			}
		});
		btnEliminar.setBounds(30, 397, 97, 33);
		contentPane.add(btnEliminar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int PrecioTotal = 0;
				ArrayList<Pedidos> Pedidos = metodos.getPedidos(DatoCorreo);
				modelo.clear();
				if (Pedidos != null) {
					for (Pedidos p : Pedidos) {
						int Cantidad = Integer.parseInt(p.getCantidad());
						int Precio = Integer.parseInt(p.getPrecio());
						PrecioTotal = PrecioTotal + Cantidad*Precio;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "La cesta esta vacia");
				}
				
				JOptionPane.showMessageDialog(null, " Gracias por contar con nosotros, tu pedido total es de: " + PrecioTotal);
				
				
				
			}
		});
		btnComprar.setBounds(520, 352, 89, 34);
		contentPane.add(btnComprar);
		
		
	}
}
