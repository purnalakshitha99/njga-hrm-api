package lk.zerocode.api.exceptions;

public class CannotCreateLeaveException extends AllNotFoundException{
    public CannotCreateLeaveException(String message) {
        super(message);
    }
}
