package BookStore.kursach.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import BookStore.kursach.entity.Book;

public class MyTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private List<Book> books;
	
	public MyTable(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public int getColumnCount() {
		return 11;
	}

	@Override
	public int getRowCount() {
		return books.size();
	}
	
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "bookName";
                break;
            case 1:
                result = "Author";
                break;
            case 2:
                result = "Category";
                break;
            case 3:
                result = "Genre";
                break;
            case 4:
                result = "Price";
                break;
            case 5:
                result = "Amount";
                break;
            case 6:
                result = "Popularity";
                break;
            case 7:
                result = "Publisher";
                break;
            case 8:
                result = "Graduate";
                break;
            case 9:
                result = "OnStore";
                break;
            case 10:
                result = "Solded";
                break;
        }
        return result;
    }

        @Override
        public Object getValueAt(int r, int c) {
            switch (c) {
                case 0:
                    return books.get(r).getBookName();
                case 1:
                    return books.get(r).getAuthor();
                case 2:
                    return books.get(r).getCategory();
                case 3:
                    return books.get(r).getGenre();
                case 4:
                    return books.get(r).getPrice();
                case 5:
                    return books.get(r).getAmount();
                case 6:
                    return books.get(r).getPopularity();
                case 7:
                    return books.get(r).getPublisher();
                case 8:
                    return books.get(r).getGraduate();
                case 9:
                    return books.get(r).getOnStore();
                case 10:
                    return books.get(r).getSolded();
                default:
                    return "";
            }
        }
}
