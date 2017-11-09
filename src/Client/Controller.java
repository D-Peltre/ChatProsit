package Client;

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
		
	}

	@Override
	public void onMessageSent(String message) {
		// TODO Auto-generated method stub
		System.out.println("On envoie le messafe " + message);
		
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
