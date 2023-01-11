import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCalzadoHombre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalzadoHombre frame = new VentanaCalzadoHombre();
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
	public VentanaCalzadoHombre() {
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
				VentanaCalzadoDeportivo ventana = new VentanaCalzadoDeportivo();
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
				VentanaCalzadoCasual ventana  = new VentanaCalzadoCasual();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnCasual.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCasual.setBounds(244, 58, 273, 143);
		contentPane.add(btnCasual);
	}

}
