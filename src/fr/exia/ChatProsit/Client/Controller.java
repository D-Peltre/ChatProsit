package fr.exia.ChatProsit.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller implements ModelListener, ViewListener{

	
	private Model model;
	private View view;

	public  Controller(Model model, View view){
		this.model = model;
		this.view = view;
		
		model.addListener(this);
		view.addListener(this);
	}
	
	
	@Override
	public void onNicknameChanged(String newNickname) {
		// TODO Auto-generated method stub
		System.out.println("Le nouveau pseudo est :  " + newNickname);
	}

	@Override
	public void onMessageSent(String message) {
		// TODO Auto-generated method stub
		System.out.println("On envoie le message " + message);
		
		try {
			//ouverture de la connection au serveur
			Socket sock = new Socket("localhost", 500);
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			
			//receptionner le prochain message
			BufferedReader in = new BufferedReader( new InputStreamReader(sock.getInputStream()));
			//envoie du message
			out.println(message);
			String rcvd = in.readLine();
			System.out.println("[Client] Message received " + rcvd);
			// Fermeture
			out.close();
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("[Client] Impossible de se connecter");
		}
		
	}

	@Override
	public void onCypherMethodChanged(String cypherMethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerConnectionChanged(boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserConnected(String nickname, String ip, boolean newConnection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserDisconnected(String nickname, String ip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageReceived(String nickname, String ip, String message) {
		// TODO Auto-generated method stub
		
	}

}
