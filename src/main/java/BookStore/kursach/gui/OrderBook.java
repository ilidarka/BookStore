package BookStore.kursach.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BookStore.kursach.entity.Order;
import BookStore.kursach.entity.OrderManager;

public class OrderBook extends JFrame{

	private static final long serialVersionUID = 1L;
	private String bookName;
	private JFrame frame;
	private JButton addButton;
	private JButton deleteButton;
	private JButton closeButton;
	private JLabel orderNumberLabel;
	private JTextField orderNumberTextField;
	private JLabel bookToOrderLabel;
	private JTextField bookToOrderTextField;
	private JLabel customerNameLabel;
	private JTextField customerNameTextField;
	private JLabel customerSurnameLabel;
	private JTextField customerSurnameTextField;
	private JLabel adresLabel;
	private JTextField adresTextField;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private Container container;
	private JPanel tablePanel;
	private JPanel otherPanel;
	private OrdersTable ordersTable;
	private JTable table;
	private List<Order> orders;
	private OrderManager manager = new OrderManager();
	private JScrollPane scroll;
	
	public OrderBook(String bookName) {
		this.bookName = bookName;
		init();
	}
	
	private void init() {
		manager.setup();
		orders = manager.readAll();
		manager.exit();
		
		frame = new JFrame();
		addButton = new JButton("Add Order");
		deleteButton = new JButton("Delete Order");
		closeButton = new JButton("Close");
		container = new Container();
		tablePanel = new JPanel();
		otherPanel = new JPanel();
		ordersTable = new OrdersTable(orders);
		table = new JTable(ordersTable);
		scroll = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setAutoCreateRowSorter(true);
		orderNumberLabel = new JLabel("Order Number");
		orderNumberTextField = new JTextField();
		bookToOrderLabel = new JLabel("Book Name");
		bookToOrderTextField = new JTextField();
		bookToOrderTextField.setText(bookName);
		customerNameLabel = new JLabel("Customer Name");
		customerNameTextField = new JTextField();
		customerSurnameLabel = new JLabel("Customer Surname");
		customerSurnameTextField = new JTextField();
		adresLabel = new JLabel("Adres");
		adresTextField = new JTextField();
		phoneLabel = new JLabel("Phone");
		phoneTextField = new JTextField();
		
		tablePanel.add(scroll);

		otherPanel.setLayout(new BoxLayout(otherPanel, BoxLayout.Y_AXIS));
		otherPanel.add(addButton);
		otherPanel.add(orderNumberLabel);
		otherPanel.add(orderNumberTextField);
		otherPanel.add(bookToOrderLabel);
		otherPanel.add(bookToOrderTextField);
		otherPanel.add(customerNameLabel);
		otherPanel.add(customerNameTextField);
		otherPanel.add(customerSurnameLabel);
		otherPanel.add(customerSurnameTextField);
		otherPanel.add(adresLabel);
		otherPanel.add(adresTextField);
		otherPanel.add(phoneLabel);
		otherPanel.add(phoneTextField);
		otherPanel.add(deleteButton);
		otherPanel.add(closeButton);
		
		container.setLayout(new BorderLayout());
		container.add(tablePanel, BorderLayout.WEST);
		container.add(otherPanel, BorderLayout.EAST);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(container);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Order order = new Order(Integer.valueOf(orderNumberTextField.getText()), 
						   bookToOrderTextField.getText(), 
						   customerNameTextField.getText(), 
						   customerSurnameTextField.getText(),
						   adresTextField.getText(),
						   phoneTextField.getText());
				manager.setup();
				manager.create(order);
				orders = manager.readAll();
				OrdersTable myModel= new OrdersTable(orders); 
				manager.exit();
				table.setModel(myModel);
				table.repaint();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Order order = new Order();
				order.setBookToOrder(table.getValueAt(table.getSelectedRow(), 1).toString());
				for(Order orderList:orders) {
					if(orderList.getBookToOrder() == order.getBookToOrder())
					{
						order = orderList;
						manager.setup();
						manager.delete(order);
						orders = manager.readAll();
						OrdersTable myModel= new OrdersTable(orders); 
						manager.exit();
						table.setModel(myModel);
						table.repaint();
					}
				}
			}
		});
		
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
	
}
