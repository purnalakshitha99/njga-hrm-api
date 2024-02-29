package lk.zerocode.api.exceptions;

public class EmployeeNotFoundException extends AllNotFoundException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
