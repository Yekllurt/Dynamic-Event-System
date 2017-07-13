package net.trullkey.des;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * 
 * An annotation every method must have when wanting to listen to events (The method must be in a class which implements the EventListener class, the class must also be registered in the EventManager)
 *
 */
@Retention(RUNTIME)
public @interface EventHandler {

}
