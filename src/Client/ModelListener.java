package Client;

public interface ModelListener {
	
	//Quand on est connecté/deconnecte du serveur
	public void onServerConnectionChanged(boolean status);
	
	// Quand un utilisateur se connecte
	public void onUserConnected(String nickname, String ip, boolean newConnection);
    
	//Quand un utilisateur se deconnecte
	public void onUserDisconnected(String nickname, String ip);
	
	// Quand message est reçu
	public void onMessageReceived(String nickname, String ip, String message);
	
	
	

}
