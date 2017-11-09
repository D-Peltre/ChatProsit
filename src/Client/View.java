package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JList;

public class View {

	protected JFrame frame;
	protected JPanel panelLeft;
	protected JPanel pannelBottom;
	protected JPanel panelCenter;
	protected JTextField textField;
	protected JTextField txtYourName;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1095, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelLeft = new JPanel();
		
		pannelBottom = new JPanel();
		
		panelCenter = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pannelBottom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panelLeft, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
						.addComponent(panelLeft, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pannelBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		txtYourName = new JTextField();
		txtYourName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtYourName.setText("Your NAME");
		txtYourName.setColumns(10);
		txtYourName.setBorder(null);
		txtYourName.setBackground(null);
		
		scrollPane_1 = new JScrollPane();
		
		JComboBox comboBox = new JComboBox();
		
		
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, 0, 148, Short.MAX_VALUE)
						.addComponent(txtYourName, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtYourName, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList<? extends E> list = new JList();
		scrollPane_1.setViewportView(list);
		panelLeft.setLayout(gl_panelLeft);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_pannelBottom = new GroupLayout(pannelBottom);
		gl_pannelBottom.setHorizontalGroup(
			gl_pannelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelBottom.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pannelBottom.setVerticalGroup(
			gl_pannelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pannelBottom.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		pannelBottom.setLayout(gl_pannelBottom);
		panelCenter.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane, "name_161336618528101");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
	}
}
