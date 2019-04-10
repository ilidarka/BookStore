package BookStore.kursach.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import BookStore.kursach.entity.Order;

public class OrdersTable extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private List<Order> orders;
	
	public OrdersTable(List<Order> orders) {
		super();
		this.orders = orders;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}
	
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "Order Number";
                break;
            case 1:
                result = "Book Name";
                break;
            case 2:
                result = "Customer Name";
                break;
            case 3:
                result = "Customer Surname";
                break;
            case 4:
                result = "Customer adres";
                break;
            case 5:
                result = "Customer phone";
                break;
        }
        return result;
    }

        @Override
        public Object getValueAt(int r, int c) {
            switch (c) {
                case 0:
                    return orders.get(r).getOrderNumber();
                case 1:
                    return orders.get(r).getBookToOrder();
                case 2:
                    return orders.get(r).getCustomerName();
                case 3:
                    return orders.get(r).getCustomerSurname();
                case 4:
                    return orders.get(r).getCustomerAdres();
                case 5:
                    return orders.get(r).getCustomerPhone();
                default:
                    return "";
            }
        }

}
