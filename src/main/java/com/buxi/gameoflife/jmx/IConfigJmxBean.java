package com.buxi.gameoflife.jmx;

/**
 * Interface for JMX Managed parameters
 * 
 * @author buxi
 *
 */
public interface IConfigJmxBean {
	public int getThreadSleepInMillis();

	public void setThreadSleepInMillis(int millis);
}
