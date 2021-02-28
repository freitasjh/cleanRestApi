package br.com.systec.config;

public class ConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConfigException(String msg) {
		super(msg);
	}

	public ConfigException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
