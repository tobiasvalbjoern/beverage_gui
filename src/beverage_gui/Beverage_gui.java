package beverage_gui;

//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.ListSelectionModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class Beverage_gui extends JFrame implements MouseListener, ActionListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username_input;
	private JTextField beverage_input;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Beverage_gui frame = new Beverage_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean isNumeric(String strNum){
		try {
			Integer.parseInt(strNum);
		}catch(NumberFormatException | NullPointerException nfe){
			return false;
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public Beverage_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel input_panel = new JPanel();
		contentPane.add(input_panel);

		JLabel lblUsername = new JLabel("Username");
		input_panel.add(lblUsername);

		username_input = new JTextField();
		input_panel.add(username_input);
		username_input.setColumns(10);

		JLabel lblBeverage = new JLabel("Beverage");
		input_panel.add(lblBeverage);
		beverage_input = new JTextField();
		input_panel.add(beverage_input);
		beverage_input.setColumns(10);
		
		JButton btnNewButton = new JButton("Apply");
		input_panel.add(btnNewButton);
		btnNewButton.addActionListener(this);

		//use a table model to work with the tabel dynamically.
		model = new DefaultTableModel();
		//adding the first column.
		model.addColumn("name\\beverage");
		
		//create new table, that uses the model
		table = new JTable(model);
		//Add the table to a scrollpane.
		JScrollPane sp=new JScrollPane(table);
		contentPane.add(sp);
		//enabling the selection of a single cell
		table.setCellSelectionEnabled(true);  
		//add the mouselistener to the table. 
		table.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
			//System.out.println("Left button released.");
			int row = table.rowAtPoint(mouseEvent.getPoint());
			int col = table.columnAtPoint(mouseEvent.getPoint());

			//Get the value at the clicked cell.
			String s=(String)table.getValueAt(row, col);

			//When no data has been entered. The first click. 
			if(s == null) { 
				table.setValueAt("1", row, col);
			}

			//We don't want to change the name or beverage.
			if(isNumeric(s)) {
				//change string to int
				int value=Integer.parseInt(s);
				value++;
				table.setValueAt(Integer.toString(value), row, col);
			}
		}
		if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
			//System.out.println("Middle button released.");
		}
		if (SwingUtilities.isRightMouseButton(mouseEvent)) {
			//System.out.println("Right button released.");
			int row = table.rowAtPoint(mouseEvent.getPoint());
			int col = table.columnAtPoint(mouseEvent.getPoint());
			String s=(String)table.getValueAt(row, col);

			if(isNumeric(s)) {
				int value=Integer.parseInt(s);
				//no minus numbers
				if(value!=0) {
					value--;
					table.setValueAt(Integer.toString(value), row, col);
				}
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(!username_input.getText().equals("")) {
			String username=username_input.getText();
			model.addRow(new Object[] {username});
			username_input.setText("");
		}
		if(!beverage_input.getText().equals("")) {
			String beverage=beverage_input.getText();
			model.addColumn(beverage);
			beverage_input.setText("");
		}
	}
}


