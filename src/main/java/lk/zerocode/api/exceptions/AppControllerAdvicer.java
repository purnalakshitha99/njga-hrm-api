package lk.zerocode.api.exceptions;

import lk.zerocode.api.controller.response.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppControllerAdvicer {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({AllNotFoundException.class})
    public ErrorResponse handleNFException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());

        return errorResponse;
    }


}
