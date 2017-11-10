package fr.exia.ChatProsit.Server;

import java.io.IOException;
import java.lang.reflect.Method;
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
			System.out.println("[Server] Listening at" + this.port);
		}
		
		public void run() {
			while(true) {
				try {
					//cette methode seert a atteindre la connection d'un nouveau client
					// elle renvoie le socket de connection
					Socket s = socket.accept();
					//ici une connection a ete reçu sur le port du serveur 
					System.out.println("[Server] Connection received from " + s.getInetAddress());
					
					Client c = new Client(this, s);
					//
					c.startPollingThread();
					synchronized (connectedClients) {
						//sauvegarde du client bien initialise
						this.connectedClients.add(c);
					}
				}
				catch (IOException e) {
					System.err.println("[Server] Client initialization error");
					e.printStackTrace();
				}
			}
		}

		public void onClientDisconnected(Client client) {
			//message de deconnection
			System.out.println("[Server][" + client.getSocket().getInetAddress() + "] Client has just been disconnected");
			
			synchronized (this.connectedClients) {
				//retirer le client de la liste des clients connectés
				this.connectedClients.remove(client);
			}
			
		
		}
		
		public void onClientMessage(Client client, String message) {
			//message de deconnection
			System.out.println("[Server][" + client.getSocket().getInetAddress() + "] Received message " + message);
			//propager le message à tous les clients
			broadcastMessage(client,message);
		
		}

		private void broadcastMessage(Client client, String message) {
			//Protocole
			String data = "MSG;";
			data += client.getNickname();
			data += ";";
			data += (long)(System.currentTimeMillis() / 1000);
			data += ";";
			data += client.getSocket().getInetAddress();
			data += ";";
			data += message;
			// Broadcast
			broadcast(data);
		}
		private void broadcast(String message) {
			//on fait une copie de la liste
			ArrayList<Client> copy;
			synchronized (this.connectedClients) {
				copy = new ArrayList<>(this.connectedClients);				
			}
			
			for (Client client : copy) {
				client.write(message);
			}
			
		}



}
