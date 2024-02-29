package lk.zerocode.api.exceptions;

public class EmployeeLateException extends AllNotFoundException {
    public EmployeeLateException(String message) {
        super(message);
    }
}
