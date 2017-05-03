package com.ekocbiyik.exception;

import com.ekocbiyik.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {

        ErrorMessage message = new ErrorMessage(e.getMessage(), 500);
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}