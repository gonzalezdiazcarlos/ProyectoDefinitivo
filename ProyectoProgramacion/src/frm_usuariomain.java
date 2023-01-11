import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class frm_usuariomain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_usuariomain frame = new frm_usuariomain();
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
	public frm_usuariomain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHombre = new JButton("Hombre");
		btnHombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frm_calzadoHombre ventana = new frm_calzadoHombre();
				ventana.setVisible(true);
				dispose();
				
				
			}
		});
		btnHombre.setBounds(255, 257, 261, 158);
		contentPane.add(btnHombre);
		
		JButton btnMujer = new JButton("Mujer");
		btnMujer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_calzadoMujer ventana = new frm_calzadoMujer();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnMujer.setBounds(255, 50, 261, 158);
		contentPane.add(btnMujer);
		
		JButton btnCestaCompra = new JButton("Cesta");
		btnCestaCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_cesta frm = new frm_cesta();
				frm.setVisible(true);
				dispose();
			}
		});
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegresar.setBounds(690, 431, 103, 23);
		contentPane.add(btnRegresar);
	}
}
