import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import basesdedatos.MetodosUsuario_sql;
import clases.Pedidos;
import clases.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaCestaCompra extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public String DatoCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCestaCompra frame = new VentanaCestaCompra();
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
	public VentanaCestaCompra() {
		
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		
		VentanaLoginusuario frm = new VentanaLoginusuario();
		DatoCorreo = frm.DatoCorreo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 757, 259);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
	
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Color");
		modelo.addColumn("Talla");
		modelo.addColumn("Genero");
		
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int SelectedRow = table.getSelectedRow();
				int SelectedColumn = table.getSelectedColumn();
				String Codigo = modelo.getValueAt(SelectedRow, SelectedColumn).toString();
				String Nombre = modelo.getValueAt(SelectedRow, SelectedColumn+1).toString();
				String Tipo = modelo.getValueAt(SelectedRow, SelectedColumn+2).toString();
				String Cantidad = modelo.getValueAt(SelectedRow, SelectedColumn+3).toString();
				String Precio = modelo.getValueAt(SelectedRow, SelectedColumn+4).toString();
				String Color = modelo.getValueAt(SelectedRow, SelectedColumn+5).toString();
				String Talla = modelo.getValueAt(SelectedRow, SelectedColumn+6).toString();
				String Genero = modelo.getValueAt(SelectedRow, SelectedColumn+7).toString();
				
				int i = metodos.EliminarPedido(DatoCorreo, Codigo, Nombre, Tipo, Cantidad, Precio, Color, Talla, Genero);
				if( i > 0 ) {
					JOptionPane.showMessageDialog(null, "Pedido eliminado Correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"no se pudo eliminar el pedido");
				}
			}
		});
		btnEliminar.setBounds(10, 302, 103, 36);
		contentPane.add(btnEliminar);
		
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setRowCount(0);
				ArrayList<Pedidos> Pedidos = metodos.getPedidos(DatoCorreo);
				if (Pedidos != null) {
					for (Pedidos p : Pedidos) {
						Object [] fila = new Object[8];
						fila[0] = p.getCodigo();
						fila[1] = p.getNombre();
						fila[2] = p.getTipo();
						fila[3] = p.getCantidad();
						fila[4] = p.getPrecio();
						fila[5] = p.getColor();
						fila[6] = p.getTalla();
						fila[7] = p.getGenero();
						modelo.addRow(fila);
					}
				}
				
			}
		});
		btnRecargar.setBounds(10, 349, 103, 36);
		contentPane.add(btnRecargar);
		
		JLabel lblNewLabel = new JLabel("(Para eliminar selecciona por favor el codigo del pedido)");
		lblNewLabel.setBounds(123, 313, 277, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int suma = 0;
				for(int i = 0; i<table.getRowCount();i++) {
					suma = suma + Integer.parseInt(table.getValueAt(i, 4).toString());
				}
				JOptionPane.showMessageDialog(null, "Pedido realizado, el importe total es de: "+suma);
			}
		});
		btnNewButton.setBounds(678, 302, 89, 36);
		contentPane.add(btnNewButton);
		
		ArrayList<Pedidos> Pedidos = metodos.getPedidos(DatoCorreo);
		if (Pedidos != null) {
			for (Pedidos p : Pedidos) {
				Object [] fila = new Object[8];
				fila[0] = p.getCodigo();
				fila[1] = p.getNombre();
				fila[2] = p.getTipo();
				fila[3] = p.getCantidad();
				fila[4] = p.getPrecio();
				fila[5] = p.getColor();
				fila[6] = p.getTalla();
				fila[7] = p.getGenero();
				modelo.addRow(fila);
			}
			
		}
		
	
		
	}
}
