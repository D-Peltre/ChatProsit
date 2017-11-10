package fr.exia.ChatProsit.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.scene.Parent;

public class Client implements Runnable {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Thread thread;
	private Server parent;
	private String nickname = "anonymous";

	public Client(Server parent, Socket socket) throws IOException {
		this.socket = socket;
		this.parent = parent;
		//init du flux de sortie (write)
		
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.in= new BufferedReader( new InputStreamReader(socket.getInputStream()));
	}

	public Socket getSocket() {
		return socket;
	}

	public void startPollingThread() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public void run() {
		while(true) {
			// Lire this.in
			String message;
			try { 
				message = this.in.readLine();
				//le client vient de se deconnecter !
				if(message == null) {
					//fermer le socket et le thread de polling
					close();
					parent.onClientDisconnected(this);
					//sortir de la methode
					return;
				}

				parent.onClientMessage(this, message);
				
			}
			catch (IOException e) {
				System.err.println("[Server][" + socket.getInetAddress() + "] Error while received message ");
			}
		}
		
	}
	
	public boolean write(String data) {
		try {			
			this.out.println(data);
			return true;
		}
		catch(Exception ex) {
			return false;			
		}
		
	}
	
	public boolean close() {
		try {
			// arrete le thread
			thread.interrupt();
			//fermer les flux
			this.out.close();
			this.out.close();
			//fermer le ssocket
			this.socket.close();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	public String getNickname() {
		return this.nickname ;
	}


}