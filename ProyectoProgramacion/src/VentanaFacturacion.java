import java.awt.EventQueue;
import java.awt.Font;
import Utilidades.*;
import basesdedatos.MetodosUsuario_sql;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VentanaFacturacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws  
	 */
	public VentanaFacturacion()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel labelFact;
		try {
			labelFact = new JLabel("Clientes,  Facturacion");
			labelFact.setFont(new Font("Tahoma", Font.BOLD, 15));
			labelFact.setBounds(20, 20, 200, 350);
			contentPane.add(labelFact);
			labelFact = new JLabel(MetodosUsuario_sql.fact().toString());
			labelFact.setFont(new Font("Tahoma", Font.BOLD, 20));
			labelFact.setBounds(50, 50, 200, 350);
			contentPane.add(labelFact);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								dispose();
				
			}
		});
		btnNewButton.setBounds(250, 200, 100,50 );
		contentPane.add(btnNewButton);
		
	
	
	
	}
}

