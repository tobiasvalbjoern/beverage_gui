package beverage_gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class Beverage_gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username_input;
	private JTextField beverage_input;
	private JTable table;

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
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel input_panel = new JPanel();
		panel.add(input_panel);
		
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
		
		JPanel table_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) table_panel.getLayout();
		flowLayout.setVgap(70);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(table_panel);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table_panel.add(table);
		model.addColumn("name\\beverage");
		table.setCellSelectionEnabled(true);  
        ListSelectionModel select= table.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        
        select.addListSelectionListener(new ListSelectionListener() {  
          public void valueChanged(ListSelectionEvent e) {  
        	//Only one event per click
        	  if (! e.getValueIsAdjusting())
  			{
        		  
        		  String Data = null;  
        		  int[] row = table.getSelectedRows();  
                  int[] columns = table.getSelectedColumns();  
                  for (int i = 0; i < row.length; i++) {  
                    for (int j = 0; j < columns.length; j++) {  
                      Data = (String) table.getValueAt(row[i], columns[j]);
                      if(Data == null) { 
                      	table.setValueAt("1", row[i], columns[j]);
                      	
                      	//clear selection again, so a new click can be registered
                      	select.clearSelection();
                      }
                      
                      if(isNumeric(Data)) {
                      	
                    	int value=Integer.parseInt(Data);
                    	value++;
                      	table.setValueAt(Integer.toString(value), row[i], columns[j]);
                        //clear selection again, so a new click can be registered
                      	select.clearSelection();
                      	}
                      //the selection is a text field.
                      else {
                    	//clear selection again, so a new click can be registered
                        	select.clearSelection();
                      }
                      }
                      
                    }  
                  
  			}
        	  
        	  
        	
            
          } }       
        );  
        JScrollPane sp=new JScrollPane(table);    
        table_panel.add(sp);  
        table_panel.setSize(300, 200);  
        table_panel.setVisible(true);  
      
        btnNewButton.addActionListener(new ActionListener() {
			
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
		});
	}
}


