package example;

import net.trullkey.des.EventManager;

public class Main {
	
	public static void main(String[] args) {
		
		//Creating a new EventManager
		EventManager eventManager = new EventManager();
		//Creating a new event listener
		EventListenerImplementation eventListenerImplementation = new EventListenerImplementation();
		
		//Registring the new event listener
		eventManager.register(eventListenerImplementation);
		
		//Creating a new instance of the AlphaEvent and calling it
		eventManager.callEvent(new AlphaEvent());
		//Creating a new instance of the BetaEvent with a parameter and calling it
		eventManager.callEvent(new BetaEvent("test"));
		//Creating a new instance of the GammaEvent
		GammaEvent gammaEvent = new GammaEvent();
		//Calling the GammaEvent
		eventManager.callEvent(gammaEvent);
		
		//Checking if an event listener canceled the GammaEvent (This can be useful if the event is called when a user is for example connecting to the server and an event is preventing the user from connecting)
		if(gammaEvent.isCanceled()){
			System.out.println("GammaEvent was canceled");
		}
		
		//Creating a new instance of the UIAlphaEvent and calling it
		eventManager.callEvent(new UIAlphaEvent());
		
		//Unregistering the event listener (This is usually done when shutting down a server)
		eventManager.unregister(eventListenerImplementation);
		
	}
	
}
