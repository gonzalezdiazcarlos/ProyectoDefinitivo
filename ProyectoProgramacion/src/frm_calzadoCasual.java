import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class frm_calzadoCasual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_calzadoCasual frame = new frm_calzadoCasual();
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
	public frm_calzadoCasual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCestaCompra = new JButton("Cesta");
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(690, 431, 103, 23);
		contentPane.add(btnRegresar);
		
		JLabel lblCasual1 = new JLabel("");
		lblCasual1.setIcon(new ImageIcon("C:\\Users\\Alumno\\Desktop\\Casual1.jpg"));
		lblCasual1.setBounds(53, 50, 203, 169);
		contentPane.add(lblCasual1);
		
		JButton btnAñadirCesta = new JButton("Añadir Cesta");
		btnAñadirCesta.setBounds(153, 230, 103, 23);
		contentPane.add(btnAñadirCesta);
		
		JLabel lblPrecio = new JLabel("100 $");
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrecio.setBounds(75, 230, 77, 23);
		contentPane.add(lblPrecio);
		
		JLabel lblNombreZapato = new JLabel("Bratton Lace");
		lblNombreZapato.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombreZapato.setBounds(53, 15, 141, 31);
		contentPane.add(lblNombreZapato);
	}
}
