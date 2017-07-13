package net.trullkey.des;

/**
 * 
 *	A standardized class every event must extend
 *
 */
public abstract class Event {

	protected boolean canceled;

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
}
