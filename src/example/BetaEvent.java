package example;

import net.trullkey.des.Event;

public class BetaEvent extends Event{

	//It is also possible to add variables to the event
	private String name;
	
	//,as well as custom constructors
	public BetaEvent(String name){
		this.name = name;
	}
	
	//and methods
	public String getName() {
		return name;
	}
	
}
