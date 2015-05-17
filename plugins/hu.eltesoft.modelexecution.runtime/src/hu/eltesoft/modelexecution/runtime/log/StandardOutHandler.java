package hu.eltesoft.modelexecution.runtime.log;

import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;


public class StandardOutHandler extends Handler {

	private StreamHandler out = new StreamHandler();
	private StreamHandler error = new StreamHandler();
	
	public StandardOutHandler() {
        configure();
        setOutputStream(System.err);
	}
	
	private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();

        setLevel(getLevelProperty(manager, cname));
        setFilter(getFilterProperty(manager, cname));
        setFormatter(getFormatterProperty(manager, cname));
        try {
            setEncoding(manager.getProperty(cname +".encoding"));
        } catch (Exception ex) {
            try {
                setEncoding(null);
            } catch (Exception ex2) {
                // doing a setEncoding with null should always work.
            }
        }
	}

	private Formatter getFormatterProperty(LogManager manager, String cname) {
		String formatterName = manager.getProperty(cname +".formatter");
		if (formatterName != null) {
			try {
				return (Formatter) Class.forName(formatterName).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// fall through
			}
		}
		return new SimpleFormatter();
	}

	private Filter getFilterProperty(LogManager manager, String cname) {
		return manager.getFilterProperty(cname +".filter", null);
	}

	private Level getLevelProperty(LogManager manager, String cname) {
		return manager.getLevelProperty(cname +".level", Level.INFO);
	}

	@Override
	public void publish(LogRecord record) {
		if (record.getLevel().intValue() >= Level.SEVERE.intValue()) {
			error.publish(record);
		} else {
			out.publish(record);
		}
	}

	@Override
	public void flush() {
		out.flush();
		error.flush();
	}

	@Override
	public void close() throws SecurityException {
		out.close();
		error.close();
	}

}
