package example;

import net.trullkey.des.Event;
import net.trullkey.des.EventHandler;
import net.trullkey.des.EventListener;

//Implementing the EventListener interface
public class EventListenerImplementation implements EventListener{

	//This method listens to when the AlphaEvent is called (All event listening methods must have the EventHandler annotation)
	//The structure of an event listening method is
	//
	// @EventHandler
	// public void methodName(EventClass paramaterName){
	//		Do stuff
	// }
	//
	@EventHandler
	public void onAlphaEvent(AlphaEvent alphaEvent){
		System.out.println("AlphaEvent was called");
	}
	
	//This method listens to when the BetaEvent is called
	@EventHandler
	public void onBetaEvent(BetaEvent betaEvent){
		System.out.println("BetaEvent was called. '" + betaEvent.getName() + "' was passed as argument.");
	}
	
	//This method listens to when the GammaEvent is called and cancels it
	@EventHandler
	public void onGammeEvent(GammaEvent gammaEvent){
		gammaEvent.setCanceled(true);
	}
	
	//It is also possible to listen to an event parent
	//Event -> UIEvent -> UIAlphaEvent
	@EventHandler
	public void onUIEvent(UIEvent uiEvent){
		System.out.println("The UIEvent '" + uiEvent.getClass().getSimpleName() + "' was called");
	}

	//This method listens to all event calls this is possible by simple writing the Event class as parameter instead of a specific event
	@EventHandler
	public void onEvent(Event event){
		System.out.println("The event '" + event.getClass().getSimpleName() + "' was called");
	}
	
	//It is also possible to add methods into this class which don't listen to any event and serve another purpose (All these methods don't have the EventHandler annotation)
	public void test(){
		System.out.println("test");
	}
	
}
