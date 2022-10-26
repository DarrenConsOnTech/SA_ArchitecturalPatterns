import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BarcodeScanner extends JFrame {

	private JPanel contentPane;

/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarcodeScanner frame = new BarcodeScanner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

	public BarcodeScanner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.darkGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JButton btn = new JButton("Scan Item");		
		contentPane.add(btn);
		setContentPane(contentPane);
	}

}