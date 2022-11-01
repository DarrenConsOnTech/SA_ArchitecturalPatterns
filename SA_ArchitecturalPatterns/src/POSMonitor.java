import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class POSMonitor extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup inputType = new ButtonGroup();
	private DefaultTableModel model;
	private JTable table;
	private JTextField barcode;
	public String[][] data;
	private final ButtonGroup paymentType = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public POSMonitor() {
		
		final CashRegister register = new CashRegister();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton cancelSession = new JButton("Cancel Session");
		cancelSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SessionPage start = new SessionPage();
				start.setVisible(true);
			}
		});
		cancelSession.setBounds(474, 377, 150, 23);
		contentPane.add(cancelSession);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(null, "Input Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		inputPanel.setBounds(6, 355, 184, 45);
		contentPane.add(inputPanel);
		inputPanel.setLayout(null);
		
		JRadioButton scanner = new JRadioButton("Scanner");
		scanner.setBounds(6, 16, 85, 23);
		inputPanel.add(scanner);
		scanner.setSelected(true);
		inputType.add(scanner);
		
		JRadioButton keyboard = new JRadioButton("Keyboard");
		keyboard.setBounds(93, 16, 85, 23);
		inputPanel.add(keyboard);
		inputType.add(keyboard);
	
		final JLabel total = new JLabel("Total: $0.00");
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        total.setBounds(474, 110, 150, 23);
        contentPane.add(total);
		
        // Column Names
        String[] columnNames = { "ID", "Product", "Price"};
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 11, 460, 300);
        contentPane.add(scrollPane);
        
        // Initializing the JTable
        final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        final JTable table = new JTable(tableModel);
        
        scrollPane.setViewportView(table);
        
        JButton addItem = new JButton("Add Item");
        addItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(barcode.getText().length() >= 4 && !barcode.getText().equals("")) {
        			if(register.addItem(barcode.getText())) {
            			updateWindow(register, table, total);
            		}
        			else {
            			JOptionPane.showMessageDialog(null, "Unknown Product", "Barcode Error", JOptionPane.INFORMATION_MESSAGE);
            		}
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Unknown Product", "Barcode Error", JOptionPane.INFORMATION_MESSAGE);
        		}
        		
        		// Updates the current window
        		SwingUtilities.updateComponentTreeUI(contentPane);
        	}
        });
        addItem.setBounds(474, 42, 150, 23);
        contentPane.add(addItem);
        
        JButton removeItem = new JButton("Remove Item");
        removeItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(barcode.getText().length() >= 4 && !barcode.getText().equals("")) {
        			if(register.removeItem(barcode.getText())) {
            			updateWindow(register, table, total);
            		}
        			else {
            			JOptionPane.showMessageDialog(null, "Unknown Product", "Barcode Error", JOptionPane.INFORMATION_MESSAGE);
            		}
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Unknown Product", "Barcode Error", JOptionPane.INFORMATION_MESSAGE);
        		}
        		
        		// Updates the current window
        		SwingUtilities.updateComponentTreeUI(contentPane);
        	}
        });
        removeItem.setBounds(474, 76, 150, 23);
        contentPane.add(removeItem);
        
        barcode = new JTextField();
        barcode.setBounds(474, 11, 150, 20);
        contentPane.add(barcode);
        barcode.setColumns(10);
        
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBorder(new TitledBorder(null, "Payment Option", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        paymentPanel.setBounds(474, 180, 150, 97);
        contentPane.add(paymentPanel);
        paymentPanel.setLayout(null);
        
        JRadioButton cash = new JRadioButton("Cash");
        cash.setBounds(6, 16, 109, 23);
        cash.setSelected(true);
        paymentPanel.add(cash);
        paymentType.add(cash);
        
        JRadioButton debit = new JRadioButton("Debit");
        debit.setBounds(6, 42, 109, 23);
        paymentPanel.add(debit);
        paymentType.add(debit);
        
        JRadioButton credit = new JRadioButton("Credit Card");
        credit.setBounds(6, 68, 109, 23);
        paymentPanel.add(credit);
        paymentType.add(credit);
        
        JButton checkout = new JButton("Checkout");
        checkout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int size = ((ArrayList<Product>) register.getProducts()).size();
        		if(size != 0) {
        			dispose();
        			Receipt receipt = new Receipt(register);
        			receipt.setVisible(true);
        		}
        	}
        });
        checkout.setBounds(474, 288, 150, 23);
        contentPane.add(checkout);
        
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.lightGray);
		
	}
	
	public void updateWindow(CashRegister register, JTable table, JLabel total) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Product> productList = (ArrayList<Product>) register.getProducts();
		Object rowData[] = new Object[3];
		for(int i = 0; i < productList.size(); i++) {
			rowData[0] = productList.get(i).getId();
			rowData[1] = productList.get(i).getName();
			rowData[2] = productList.get(i).getPrice();
			model.addRow(rowData);
		}
		
		total.setText("Total: $"+String.format("%.2f", register.getTotal()));
		
		
		
		
	}
}
