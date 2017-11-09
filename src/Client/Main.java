package Client;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//avoir look windows normal
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception e) {}
					
					//Creer la fentre
					View window = new View();
					//creer le model
					Model model = new Model();
					//creer le controller
					Controller ctrl = new Controller(model, window);
					//creer la fenetre
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
