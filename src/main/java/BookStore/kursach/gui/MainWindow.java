package BookStore.kursach.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import BookStore.kursach.entity.Book;
import BookStore.kursach.entity.BookManager;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String oldValue;
	private JFrame frame;
	private JTable table;
	private JButton addButton;
	private JButton deleteButton;
	private JButton changeButton;
	private JButton saveButton;
	private JButton exitButton;
	private JButton buyBookButton;
	private JButton reportButton;
	private JButton orderBookButton;
	private JLabel bookNameLabel;
	private JTextField bookNameTextField;	
	private JLabel authorLabel;
	private JTextField authorTextField;
	private JLabel categoryLabel;
	private JTextField categoryTextField;
	private JLabel genreLabel;
	private JTextField genreTextField;
	private JLabel priceLabel;
	private JTextField priceTextField;
	private JLabel amountLabel;
	private JTextField amountTextField;
	private JLabel popularityLabel;
	private JTextField popularityTextField;
	private JLabel publisherLabel;
	private JTextField publisherTextField;
	private JLabel graduateLabel;
	private JTextField graduateTextField;
	private JLabel onStoreLabel;
	private JTextField onStoreTextField;
	private JLabel soldedLabel;
	private JTextField soldedTextField;
	private JPanel tablePanel;
	private JPanel buttons;
	private JPanel otherButtons;
	private Container container;
	private BookManager manager = new BookManager();
	private List<Book> books;
	private MyTable tableModel;
	private JScrollPane scroll;

	public MainWindow() {
		init();
	}

	public void init() {
		manager.setup();
		books = manager.readAll();
		manager.exit();
		
		frame = new JFrame("Book Store");
		container = new Container();
		tableModel = new MyTable(books);
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
		table.setAutoCreateRowSorter(true);
		tablePanel = new JPanel();
		buttons = new JPanel();
		otherButtons = new JPanel();
		bookNameLabel = new JLabel("Book name");
		bookNameTextField = new JTextField();	
		authorLabel = new JLabel("Author");
		authorTextField = new JTextField();
		categoryLabel = new JLabel("Category");
		categoryTextField = new JTextField();
		genreLabel = new JLabel("Genre");
		genreTextField = new JTextField();
		priceLabel = new JLabel("Price");
		priceTextField = new JTextField();
		amountLabel = new JLabel("Amount");
		amountTextField = new JTextField();
		popularityLabel = new JLabel("Popularity");
		popularityTextField = new JTextField();
		publisherLabel = new JLabel("Publisher");
		publisherTextField = new JTextField();
		graduateLabel = new JLabel("Graduate");
		graduateTextField = new JTextField();
		onStoreLabel = new JLabel("On Store");
		onStoreTextField = new JTextField();
		soldedLabel = new JLabel("Solded");
		soldedTextField = new JTextField();
		addButton = new JButton("Add book");
		saveButton = new JButton("Save");
		deleteButton = new JButton("Delete book");
		exitButton = new JButton("Close Program");
		changeButton = new JButton("Change value");
		buyBookButton = new JButton("Buy Book");
		reportButton = new JButton("Report");
		orderBookButton = new JButton("Order book");
	
		tablePanel.add(scroll);
		
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		buttons.add(addButton);
		buttons.add(changeButton);
		buttons.add(saveButton);
		buttons.add(bookNameLabel);
		buttons.add(bookNameTextField);
		buttons.add(authorLabel);
		buttons.add(authorTextField);
		buttons.add(categoryLabel);
		buttons.add(categoryTextField);
		buttons.add(genreLabel);
		buttons.add(genreTextField);
		buttons.add(priceLabel);
		buttons.add(priceTextField);
		buttons.add(amountLabel);
		buttons.add(amountTextField);
		buttons.add(popularityLabel);
		buttons.add(popularityTextField);
		buttons.add(publisherLabel);
		buttons.add(publisherTextField);
		buttons.add(graduateLabel);
		buttons.add(graduateTextField);
		buttons.add(onStoreLabel);
		buttons.add(onStoreTextField);
		buttons.add(soldedLabel);
		buttons.add(soldedTextField);
		buttons.add(deleteButton);
		buttons.add(exitButton);
		
		otherButtons.setLayout(new BoxLayout(otherButtons, BoxLayout.X_AXIS));
		otherButtons.add(buyBookButton);
		otherButtons.add(reportButton);
		otherButtons.add(orderBookButton);
		
		container.setLayout(new BorderLayout());
		container.add(tablePanel, BorderLayout.WEST);
		container.add(buttons, BorderLayout.EAST);
		container.add(otherButtons, BorderLayout.SOUTH);
	
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(container);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		
		buyBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book();
				if(table.getSelectedColumn() == 0) {
					book.setBookName(table.getValueAt(table.getSelectedRow(), 0).toString());
					for(Book bookList:books) {
						if(bookList.getBookName() == book.getBookName())
						{
							book = bookList;
							book.setOnStore(book.getOnStore() - 1);
							book.setSolded(book.getSolded() + 1);
							book.setAmount(book.getAmount() + book.getPrice());
							new Check(book);
						}
					}
					manager.setup();
					manager.update(book);
					books = manager.readAll();
					MyTable myModel= new MyTable(books); 
					manager.exit();
					table.setModel(myModel);
					table.repaint();
				} else {
					JOptionPane.showMessageDialog(frame, "Choose the book name!");
				}

			}
		});
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book(bookNameTextField.getText(), 
						   authorTextField.getText(), 
						   categoryTextField.getText(), 
						   genreTextField.getText(),
						   Float.valueOf(priceTextField.getText()),
						   Float.valueOf(amountTextField.getText()),
						   Float.valueOf(popularityTextField.getText()),
						   publisherTextField.getText(),
						   Date.valueOf(graduateTextField.getText()),
						   Integer.valueOf(onStoreTextField.getText()),
						   0);
				manager.setup();
				manager.create(book);
				books = manager.readAll();
				MyTable myModel= new MyTable(books); 
				manager.exit();
				table.setModel(myModel);
				table.repaint();
			}
		});
		
		changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				if(table.getSelectedColumn() == 0) {
					book.setBookName(table.getValueAt(table.getSelectedRow(), 0).toString());
					for(Book bookList:books) {
						if(bookList.getBookName() == book.getBookName())
						{
							book = bookList;
							bookNameTextField.setText(book.getBookName());
							authorTextField.setText(book.getAuthor());
							categoryTextField.setText(book.getCategory());
							genreTextField.setText(book.getGenre());
							priceTextField.setText(String.valueOf(book.getPrice()));
							amountTextField.setText(String.valueOf(book.getAmount()));
							popularityTextField.setText(String.valueOf(book.getPopularity()));
							publisherTextField.setText(book.getPublisher());
							graduateTextField.setText(book.getGraduate().toString());
							onStoreTextField.setText(String.valueOf(book.getOnStore()));
							soldedTextField.setText(String.valueOf(book.getSolded()));
							MainWindow.oldValue = bookNameTextField.getText();
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Choose the book name!");
				}
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				for(Book bookList:books) {
					if(bookList.getBookName().equals(MainWindow.oldValue))
					{
						book = bookList;
						book.setBookName(bookNameTextField.getText());
						book.setAuthor(authorTextField.getText());
						book.setCategory(categoryTextField.getText());
						book.setGenre(genreTextField.getText());
						book.setPrice(Float.valueOf(priceTextField.getText()));
						book.setAmount(Float.valueOf(amountTextField.getText()));
						book.setPopularity(Float.valueOf(popularityTextField.getText()));
						book.setPublisher(publisherTextField.getText());
						book.setGraduate(Date.valueOf(graduateTextField.getText()));
						book.setOnStore(Integer.valueOf(onStoreTextField.getText()));
						book.setSolded(Integer.valueOf(soldedTextField.getText()));
					}
				}
				manager.setup();
				manager.update(book);
				books = manager.readAll();
				MyTable myModel= new MyTable(books); 
				manager.exit();
				table.setModel(myModel);
				table.repaint();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				book.setBookName(table.getValueAt(table.getSelectedRow(), 0).toString());
				for(Book bookList:books) {
					if(bookList.getBookName() == book.getBookName())
					{
						book = bookList;
					}
				}
				manager.setup();
				manager.delete(book);
				books = manager.readAll();
				MyTable myModel= new MyTable(books); 
				manager.exit();
				table.setModel(myModel);
				table.repaint();
			}
		});

		reportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Report(books);
			}
		});
		
		orderBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				if(table.getSelectedColumn() == 0) {
					book.setBookName(table.getValueAt(table.getSelectedRow(), 0).toString());
					for(Book bookList:books) {
						if(bookList.getBookName() == book.getBookName())
						{
							book = bookList;
							new OrderBook(book.getBookName());
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Choose the book name!");
				}

			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
