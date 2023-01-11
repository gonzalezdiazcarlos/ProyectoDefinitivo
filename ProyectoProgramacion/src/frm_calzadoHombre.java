import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frm_calzadoHombre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_calzadoHombre frame = new frm_calzadoHombre();
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
	public frm_calzadoHombre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnCestaCompra = new JButton("Cesta ");
		btnCestaCompra.setBounds(690, 11, 103, 47);
		contentPane.add(btnCestaCompra);
		
		JButton btnDeportivas = new JButton("Deportivas");
		btnDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_calzadoDeportivo ventana = new frm_calzadoDeportivo();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnDeportivas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDeportivas.setBounds(244, 268, 273, 143);
		contentPane.add(btnDeportivas);
		
		JButton btnCasual = new JButton("Casual");
		btnCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_calzadoCasual ventana  = new frm_calzadoCasual();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCasual.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCasual.setBounds(244, 58, 273, 143);
		contentPane.add(btnCasual);
	}

}
