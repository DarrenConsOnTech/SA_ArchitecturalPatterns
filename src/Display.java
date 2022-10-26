import javax.swing.*;
import java.awt.*;

public class Display {
	JFrame jf;
	public Display() {
		jf = new JFrame("Display");
		
		JButton btn = new JButton("Start New Session");		
		jf.add(btn);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Display();
	}
}
