package at.bitmedia.schoolreader.exceptions;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String s, Exception ex) {
        super(s, ex);
    }

    public FileStorageException(String message) {
        super(message);
    }

}
