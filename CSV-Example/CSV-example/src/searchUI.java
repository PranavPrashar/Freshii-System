import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.csvreader.CsvReader;

public class searchUI implements ActionListener {

	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();

	public static JFrame frame2 = new JFrame();
	public static JPanel panel2 = new JPanel();

	public static JFrame frame3 = new JFrame();
	public static JPanel panel3 = new JPanel();

	public static JLabel label1, searchLabel;
	
	public static JTextField searchInput;

	public static JButton button1, button2, itemSearch;
	public static JComboBox combobox;



	public static String[] itemDropdown = { "Wraps", "Salad", "Drink", "Dessert", "None of the listed" };
	ArrayList<Product> products = new ArrayList<Product>();

	public static JComboBox<String> jComboBox = new JComboBox<>(itemDropdown);

	public static void main(String[] args) throws IOException {
		searchUIMain();
	}

	public void loadItems(String path) throws Exception {
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		while(reader.readRecord()) {
			
		}
	}
	
	
	

	public static void searchUIMain() {
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		frame.setTitle("searchUI");

		panel.setLayout(null);

		label1 = new JLabel("Freshii Ordering ");
		label1.setBounds(10, 20, 180, 25);
		panel.add(label1);

		button1 = new JButton("Search By Item");
		button1.setBounds(10, 80, 180, 25);
		button1.addActionListener(new searchUI());
		panel.add(button1);
		button2 = new JButton("Search by Group");
		button2.setBounds(10, 110, 180, 25);
		panel.add(button2);
		button2.addActionListener(new searchUI());

		frame.setVisible(true);

	}
	
	
	


	public static void dropDownGUI() {
		frame.setVisible(false);

		panel2 = new JPanel();
		frame2 = new JFrame();

		frame2.setSize(350, 200);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(panel2);
		frame2.setTitle("Search by Group");

		frame2.add(jComboBox);

		frame2.setVisible(true);

	}

	public static void searchByItem() {
		frame2.setVisible(false); // hiding the previous screen

		panel3 = new JPanel();
		frame3 = new JFrame();

		frame3.setSize(350, 200);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.add(panel3);
		frame3.setTitle("Search by Item");
		
		searchLabel = new JLabel("Search By Item: ");
		searchLabel.setBounds(10, 20, 80, 25);
		panel3.add(searchLabel);
		
		searchInput = new JTextField(20);
		searchInput.setBounds(100, 20, 165, 25);
		panel3.add(searchInput);
		
		itemSearch = new JButton("Search Item");
		itemSearch.setBounds(10, 80, 80, 25);
		panel3.add(itemSearch);
		itemSearch.addActionListener(new searchUI());
		
		
		
		//searchInput.getText()
		
		frame3.setVisible(true);
		
		
				

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) { // search by Item
			System.out.println("button 1 clicked--> Search by Item");
			searchByItem();
//			String selected = this.jComboBox.getItemAt(this.jComboBox.getSelectedIndex());
			//System.out.println(selected);
		} else if (e.getSource() == button2) {
			System.out.println("button 2 clicked");
		}
		
		if(e.getSource() == itemSearch) {
			// now we should take the searchInput and check the DB
			
		}
	}

}
