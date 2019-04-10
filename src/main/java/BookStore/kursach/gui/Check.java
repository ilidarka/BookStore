package BookStore.kursach.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BookStore.kursach.entity.Book;


public class Check extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton okButton;
	private JLabel checkLabel;
	private JLabel nameBookLabel;
	private JLabel authorLabel;
	private JLabel publisherLabel;
	private JLabel priceLabel;
	private JLabel nameBookLabelOut;
	private JLabel authorLabelOut;
	private JLabel publisherLabelOut;
	private JLabel priceLabelOut;
	private Container container;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private Book book;

	public Check(Book book) {
		this.book = book;
		init();
	}

	private void init() {
		frame = new JFrame("Check");
		okButton = new JButton("OK");
		checkLabel = new JLabel("CHECK");
		nameBookLabel = new JLabel("Book Name:");
		authorLabel = new JLabel("Author:");
		publisherLabel = new JLabel("Publisher:");
		priceLabel = new JLabel("Price:");
		nameBookLabelOut = new JLabel(book.getBookName());
		authorLabelOut = new JLabel(book.getAuthor());
		publisherLabelOut = new JLabel(book.getPublisher());
		priceLabelOut = new JLabel(String.valueOf(book.getPrice()));
		container = new Container();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(nameBookLabel);
		leftPanel.add(authorLabel);
		leftPanel.add(publisherLabel);
		leftPanel.add(priceLabel);
		
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(nameBookLabelOut);
		rightPanel.add(authorLabelOut);
		rightPanel.add(publisherLabelOut);
		rightPanel.add(priceLabelOut);
		
		container.setLayout(new BorderLayout());
		container.add(checkLabel, BorderLayout.NORTH);
		container.add(leftPanel, BorderLayout.WEST);
		container.add(rightPanel, BorderLayout.EAST);
		container.add(okButton, BorderLayout.SOUTH);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(container);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
}
