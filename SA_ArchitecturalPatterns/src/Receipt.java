import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class Receipt extends JFrame {

	/**
	 * Create the frame.
	 */
	public Receipt(CashRegister register) {
		
		String[][] data = new String[register.products.size()][3];
		
		for (int i = 0; i < register.products.size(); i++) {
		    Product currentProduct = register.products.get(i);
		    data[i][0] = currentProduct.getId();
		    data[i][1] = currentProduct.getName();
		    data[i][2] = String.valueOf(currentProduct.getPrice());
		}

		
		String[][] receipt = new String[data.length][5];
		
		int index = 0;
  
        for (int i = 0; i < data.length; i++) {   
            int flag = 0;  
            for (int j = 0; j < i; j++){  
                if (data[i][0].equals(data[j][0])){   
                    flag = 1;  
                    break;   
                }  
            }    
            if (flag == 0){   
            	receipt[index][0] = data[i][0];
            	receipt[index][1] = data[i][1];
            	receipt[index][3] = data[i][2];
                index++;  
            }  
        }  
        
        int counter = 0;
        
//        System.out.println(receipt.length);
        
        for(int i = 0; i < index; i++) {
        	for(int j = 0; j < data.length; j++) {
        		if(receipt[i][0].equals(data[j][0])) {
        			counter++;
        			receipt[i][2] = Integer.toString(counter);
        		}
        	}
        	counter = 0;
        }
        
        for(int i = 0 ; i < index; i++) {
        	int qty = Integer.parseInt(receipt[i][2]);
        	double unitPrice = Double.parseDouble(receipt[i][3]);
        	double totalPrice = qty * unitPrice;
        	receipt[i][4] = String.format("%.2f", totalPrice);
        }
        
        String finalReceipt = "";
        finalReceipt += ("ID\tName\tQty.\tUnit Price\tTotal Price\n");
        for(int i = 0; i < index; i++) {
        	finalReceipt += (receipt[i][0] + "\t" + receipt[i][1] + "\t" + receipt[i][2] + "\t$" + receipt[i][3] + "\t$" + receipt[i][4] + "\n");
        }
        finalReceipt += ("\nSubtotal:\t$" + String.format("%.2f", register.getTotal()) + "\n");
        finalReceipt += ("Hst:\t$" + String.format("%.2f", register.getTotal()*0.13) + "\n");
        finalReceipt += ("Total:\t$" + String.format("%.2f", register.getTotal()*1.13) + "\n");
        
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(null);
		
		JTextPane receiptOutput = new JTextPane();
		receiptOutput.setBounds(10, 11, 614, 355);
		getContentPane().add(receiptOutput);
		
		receiptOutput.setText(finalReceipt);
		
		JButton closeSession = new JButton("Start New Session");
		closeSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SessionPage session = new SessionPage();
				session.setVisible(true);
			}
		});
		closeSession.setBounds(474, 377, 150, 23);
		getContentPane().add(closeSession);
       
	}
}
