package com.buxi.gameoflife.jmx;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ConfigurationProperties("com.buxi.gameoflife.jmx.ConfigJmxBean")
@Component
@ManagedResource(objectName = "bean:name=ConfigJMX", description = "My Managed Bean", log = true, logFile = "jmx.log", currencyTimeLimit = 15, persistPolicy = "OnUpdate", persistPeriod = 200, persistLocation = "foo", persistName = "bar")
public class ConfigJmxBean implements IConfigJmxBean {
	private int threadSleepInMillis;

	@ManagedAttribute(persistPeriod = 300)
	public int getThreadSleepInMillis() {
		return threadSleepInMillis;
	}

	@ManagedAttribute(description = "Thread sleep value in millis", currencyTimeLimit = 20, defaultValue = "10", persistPolicy = "OnUpdate")
	public void setThreadSleepInMillis(int threadSleepInMillis) {
		this.threadSleepInMillis = threadSleepInMillis;
	}
}
