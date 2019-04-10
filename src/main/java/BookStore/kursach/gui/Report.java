package BookStore.kursach.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BookStore.kursach.entity.Book;
import BookStore.kursach.entity.BookManager;

public class Report extends JFrame{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Container container;
	private JPanel panel;
	private JButton okButton;
	private JLabel mostBuyingBookLabel;
	private JLabel mostBuyingBookCountLabel;
	private JLabel soldedCountLabel;
	private JLabel onStoreLabel;
	private JLabel moneyGainedLabel;
	private BookManager manager = new BookManager();
	private List<Book> books;
	
	public Report(List<Book> books) {
		this.books = books;
		init();
	}
	
	private void init() {
		manager.setup();
		
		frame = new JFrame("Report");
		container = new Container();
		panel = new JPanel();
		okButton = new JButton("Ok");
		
		for (Book book : books) {
			if(book.getPopularity() == Float.valueOf(manager.getCount("SELECT MAX(popularity) FROM Book"))) {
				mostBuyingBookLabel = new JLabel("Most buying book: " + book.getBookName());
				mostBuyingBookCountLabel = new JLabel("Most buying book count: " + String.valueOf(book.getOnStore()));
			}
		}
		
		soldedCountLabel = new JLabel("Books solded: " + manager.getCount("SELECT SUM(solded) FROM Book"));
		
		onStoreLabel = new JLabel("On Store: " + manager.getCount("SELECT SUM(onStore) FROM Book"));
		
		moneyGainedLabel = new JLabel("Money gained: " + manager.getCount("SELECT SUM(amount) FROM Book"));
		
		manager.exit();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(mostBuyingBookLabel);
		panel.add(mostBuyingBookCountLabel);
		panel.add(soldedCountLabel);
		panel.add(onStoreLabel);
		panel.add(moneyGainedLabel);
		
		container.setLayout(new BorderLayout());
		container.add(panel, BorderLayout.WEST);
		container.add(okButton, BorderLayout.SOUTH);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(container);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();	

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
	}
}
