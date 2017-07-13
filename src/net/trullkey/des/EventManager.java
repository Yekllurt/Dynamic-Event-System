package net.trullkey.des;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The managing class which handles the event calls and notifies the listeners 
 *
 */
public class EventManager {

	private List<EventListener> eventListeners = new ArrayList<>();
	
	/**
	 * Register an EventListener
	 */
	public void register(EventListener eventListener){
		if(eventListeners.contains(eventListener)) return;
		eventListeners.add(eventListener);
	}
	
	/**
	 * Unregister an EventListener
	 */
	public void unregister(EventListener eventListener){
		eventListeners.remove(eventListener);
	}
	
	/**
	 * Call an event
	 */
	public void callEvent(Event event){
		for(EventListener eventListener : eventListeners){
			for(Method method : eventListener.getClass().getMethods()){
				for(Annotation annotation : method.getAnnotations()){
					if(!annotation.annotationType().equals(EventHandler.class)) continue;
					if(method.getParameters().length != 1) continue;
					if(method.getParameterTypes()[0] != Event.class && !method.getParameterTypes()[0].isAssignableFrom(event.getClass()) && method.getParameterTypes()[0] != event.getClass()) continue;
					try {
						method.invoke(eventListener, event);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
