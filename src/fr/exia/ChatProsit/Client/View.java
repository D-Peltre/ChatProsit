package fr.exia.ChatProsit.Client;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SwingConstants;


public class View {

	public JFrame frame;
	protected JPanel panelLeft;
	protected JPanel pannelBottom;
	protected JPanel panelCenter;
	protected JTextField messageField;
	protected JTextField txtYourName;
	private JScrollPane scrollPane_1;
	
	private List<ViewListener> listeners;


	/**
	 * Create the application.
	 */
	public View() {
		initialize();
		this.listeners = new ArrayList<>();
	}
	
	
	
	
	public void addListener(ViewListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(ViewListener listener) {
		this.listeners.remove(listener);
	}
	
	public void notifyEvent(String methodName, Object... args) {
		// les trois petits points sont une elipse
		// Object... = Object [n]
		
		
		//Chercher la bonne methode
		Method methodCall = null;
		for(Method method  : ViewListener.class.getMethods()) {
			if (methodName.equals(method.getName())) {
				methodCall = method;
				break;
			}
		}
		
		if(methodCall == null) {
			throw new IllegalArgumentException("Event " + methodName + " doesn't exist");
		}
		
		
		//je parcours la liste de mes observers
		for (ViewListener listener :this.listeners) {
			try {
				//On appelle la methode qu'on a trouve avant et on lui donne 
				methodCall.invoke(listener, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				//System.err.println("Erreur lors du dispatch de l'envent "+ methodName + listener.getClass());
				e.printStackTrace();
			}
			
		}
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
		txtYourName.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtYourName.setText("Your NAME");
		txtYourName.setColumns(10);
		txtYourName.setBorder(null);
		txtYourName.setBackground(null);
		
		scrollPane_1 = new JScrollPane();
		
		JComboBox cypherComboBox = new JComboBox();
		
		
		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(cypherComboBox, 0, 148, Short.MAX_VALUE)
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
					.addComponent(cypherComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		panelLeft.setLayout(gl_panelLeft);
		
		messageField = new JTextField();
		messageField.setColumns(10);
		GroupLayout gl_pannelBottom = new GroupLayout(pannelBottom);
		gl_pannelBottom.setHorizontalGroup(
			gl_pannelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pannelBottom.createSequentialGroup()
					.addContainerGap()
					.addComponent(messageField, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pannelBottom.setVerticalGroup(
			gl_pannelBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pannelBottom.createSequentialGroup()
					.addContainerGap()
					.addComponent(messageField, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addContainerGap())
		);
		pannelBottom.setLayout(gl_pannelBottom);
		panelCenter.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane, "name_161336618528101");
		
		JTextArea messageArea = new JTextArea();
		messageArea.setEditable(false);
		scrollPane.setViewportView(messageArea);
		frame.getContentPane().setLayout(groupLayout);
		
		messageField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//recuperer le texte saisi dans le champs texte 
			String message = messageField.getText();
			//notifier l'event
			notifyEvent("onMessageSent", message);
			//Vider le champ de formulaire
			messageField.setText("");
			}
		});
		
		txtYourName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			//recuperer le texte saisi dans le champs texte 
			String message = txtYourName.getText();
			//notifier l'event
			notifyEvent("onMessageSent", message);

			}
		});
		
		
	}
}
