package ch04.ude;

public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	Integer id;
	
	public RecordNotFoundException(Integer id) {
		this.id = id;
	}

	public RecordNotFoundException() {
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(Throwable cause) {
		super(cause);
	}

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Integer getId() {
		return id;
	}

}
