package software.coley.recaf.launcher.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jspecify.annotations.NonNull;

public class Loggers {
	// TODO: Listener registration to intercept logger calls and show in UI
	@NonNull
	public static Logger newLogger() {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		StackTraceElement element = trace[trace.length - 1];
		return LoggerFactory.getLogger(element.getClassName());
	}
}
