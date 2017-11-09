package fr.exia.ChatProsit;


import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UIManager;

import fr.exia.ChatProsit.Client.Controller;
import fr.exia.ChatProsit.Client.Model;
import fr.exia.ChatProsit.Client.View;
import fr.exia.ChatProsit.Server.Server;



public class Main {
	
	
	
	
	//Lancement du client
	public static void main(String[] args) throws IOException {
		//Lancement du serveur
		Server srv = new Server(500);
		srv.start();
		// Permet de lancer dans l'IHM
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
