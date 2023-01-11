import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCalzadoMujer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalzadoMujer frame = new VentanaCalzadoMujer();
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
	public VentanaCalzadoMujer() {
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
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuariomain frm = new VentanaUsuariomain();
				frm.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(690, 434, 103, 20);
		contentPane.add(btnRegresar);
		
		JButton btnDeportivas = new JButton("Botas");
		btnDeportivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCalzadoBotas ventana = new VentanaCalzadoBotas();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnDeportivas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDeportivas.setBounds(244, 268, 273, 143);
		contentPane.add(btnDeportivas);
		
		JButton btnCasual = new JButton("Tacones");
		btnCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCalzadoTacones ventana  = new VentanaCalzadoTacones();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCasual.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCasual.setBounds(244, 58, 273, 143);
		contentPane.add(btnCasual);
	}

}
