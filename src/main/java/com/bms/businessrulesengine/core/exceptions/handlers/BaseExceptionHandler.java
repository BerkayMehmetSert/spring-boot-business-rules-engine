package com.bms.businessrulesengine.core.exceptions.handlers;

import com.bms.businessrulesengine.core.exceptions.BusinessException;
import com.bms.businessrulesengine.core.exceptions.NotFoundException;
import org.springframework.http.ProblemDetail;


public abstract class BaseExceptionHandler {
    protected abstract ProblemDetail handleException(BusinessException exception);

    protected abstract ProblemDetail handleException(NotFoundException exception);

    protected abstract ProblemDetail handleException(Exception exception);
}
