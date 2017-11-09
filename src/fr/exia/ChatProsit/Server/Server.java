package fr.exia.ChatProsit.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import fr.exia.ChatProsit.Client.ModelListener;

public class Server implements Runnable{
	
	private static int port;
	private ServerSocket socket;
	private Thread acceptThread;
	private List<Client> connectedClients;
		
		public Server(int port) {
			if (port <1 || port > 65535) {
				throw new IllegalArgumentException("Invalid port");
			}
			this.port = port;
			this.connectedClients = new ArrayList<>();
		}
		
		public void start() throws IOException {
			//on ouvre le socket sur le port donnee
			this.socket = new ServerSocket(this.port);
			//le thread en boucle qui ouvre les nouvelles connections
			this.acceptThread = new Thread(this);
			this.acceptThread.start();
			System.out.println("[Server] Connection received from" + this.port);
		}
		
		public void run() {
			while(true) {
				try {
					//cette methode seert a atteindre la connection d'un nouveau client
					// elle renvoie le socket de connection
					Socket s = socket.accept();
					//ici une connection a ete reçu sur le port du serveur 
					System.out.println("[Server] Connection received from " + s.getInetAddress());
					
					Client c = new Client(s);
					this.connectedClients.add(c);
				}
				catch (IOException e) {
					System.out.println("[Server] Accept error");
					e.printStackTrace();
				}
			}
		}

}
