package hu.eltesoft.modelexecution.runtime.log;

import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * <p>
 * This handler logs info messages to the standard output stream and logs error
 * messages to the standard error stream.
 * </p>
 * 
 * <b>Configuration:</b> By default each <tt>ConsoleHandler</tt> is initialized
 * using the following <tt>LogManager</tt> configuration properties where
 * {@code <handler-name>} refers to the fully-qualified class name of the
 * handler. If properties are not defined (or have invalid values) then the
 * specified default values are used.
 * <ul>
 * <li>&lt;handler-name&gt;.level specifies the default level for the
 * <tt>Handler</tt> (defaults to <tt>Level.INFO</tt>).</li>
 * <li>&lt;handler-name&gt;.filter specifies the name of a <tt>Filter</tt> class
 * to use (defaults to no <tt>Filter</tt>).</li>
 * <li>&lt;handler-name&gt;.formatter specifies the name of a <tt>Formatter</tt>
 * class to use (defaults to <tt>java.util.logging.SimpleFormatter</tt>).</li>
 * <li>&lt;handler-name&gt;.encoding the name of the character set encoding to
 * use (defaults to the default platform encoding).</li>
 * </ul>
 */
public class StandardOutHandler extends Handler {

	private final StreamHandler out = new StreamHandler() {
		{
			setOutputStream(System.out);
		}
	};
	private final StreamHandler err = new StreamHandler() {
		{
			setOutputStream(System.err);
		}
	};

	public StandardOutHandler() {
		configure();
	}

	/**
	 * Loads properties for this handler from the properties map. Have to
	 * reimplement this because StandardOutHandler does not inherit from
	 * {@linkplain StreamHandler}.
	 */
	private void configure() {
		LogManager manager = LogManager.getLogManager();
		String cname = getClass().getName();

		setLevel(getLevelProperty(manager, cname));
		setFilter(getFilterProperty(manager, cname));
		setFormatter(getFormatterProperty(manager, cname));
		try {
			setEncoding(manager.getProperty(cname + ".encoding"));
		} catch (Exception ex) {
			try {
				setEncoding(null);
			} catch (Exception ex2) {
				// doing a setEncoding with null should always work.
			}
		}
	}

	private Formatter getFormatterProperty(LogManager manager, String cname) {
		String formatterName = manager.getProperty(cname + ".formatter");
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
		String filterName = manager.getProperty(cname + ".filter");
		if (filterName != null) {
			try {
				return (Filter) Class.forName(filterName).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// fall through
			}
		}
		return null;
	}

	private Level getLevelProperty(LogManager manager, String cname) {
		String levelName = manager.getProperty(cname + ".level");
		if (levelName != null) {
			try {
				return Level.parse(levelName);
			} catch (IllegalArgumentException e) {
				// fall through
			}
		}
		return Level.INFO;
	}

	@Override
	public void publish(LogRecord record) {
		if (record.getLevel().intValue() >= Level.SEVERE.intValue()) {
			err.publish(record);
		} else {
			out.publish(record);
		}
	}

	@Override
	public void flush() {
		out.flush();
		err.flush();
	}

	@Override
	public void close() throws SecurityException {
		out.close();
		err.close();
	}

}
