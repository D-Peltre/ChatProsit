package fr.exia.ChatProsit.Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private String nickname;
	
	private String cypherMethod;
	
	private String serverAdress;
	
	private List<String> connectedUsers;
	
	private List<ModelListener> listeners;
	
	public Model() {
		this.connectedUsers = new ArrayList<>();
		this.listeners = new ArrayList<>();
		
	}
	
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCypherMethod() {
		return cypherMethod;
	}

	public void setCypherMethod(String cypherMethod) {
		this.cypherMethod = cypherMethod;
	}

	public String getServerAdress() {
		return serverAdress;
	}

	public void setServerAdress(String serverAdress) {
		this.serverAdress = serverAdress;
	}

	public List<String> getConnectedUsers() {
		return connectedUsers;
	}

	public void addConnectedUser(String username) {
		this.connectedUsers.add(username);
	}
	
	public void removeConnectedUser(String username) {
		this.connectedUsers.remove(username);
	}
	
	
	
	
	public void addListener(ModelListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(ModelListener listener) {
		this.listeners.remove(listener);
	}

	
	
	
	public void notifyEvent(String methodName, Object... args) {
		// les trois petits points sont une elipse
		// Object... = Object [n]
		
		
		//Chercher la bonne methode
		Method methodCall = null;
		for(Method method  : ModelListener.class.getMethods()) {
			if (methodName.equals(method.getName())) {
				methodCall = method;
				break;
			}
		}
		
		if(methodCall == null) {
			throw new IllegalArgumentException("Event " + methodName + " doesn't exist");
		}
		
		
		//je parcours la liste de mes observers
		for (ModelListener listener :this.listeners) {
			try {
				//On appelle la methode qu'on a trouve avant et on lui donne 
				methodCall.invoke(listener, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				//System.err.println("Erreur lors du dispatch de l'envent "+ methodName + listener.getClass());
				e.printStackTrace();
			}
			
		}
	}

}
