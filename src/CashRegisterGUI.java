import javax.swing.*;
import java.awt.*;

public class CashRegisterGUI {
	JFrame jf;
	public CashRegisterGUI() {
		jf = new JFrame("Display");
		
		JButton btn = new JButton("Start New Session");		
		jf.add(btn);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CashRegisterGUI();
	}
}
