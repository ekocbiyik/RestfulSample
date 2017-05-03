package com.ekocbiyik.exception;

import com.ekocbiyik.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by enbiya on 02.05.2017.
 */
//@Provider
public class AuthExceptionMapper implements ExceptionMapper<AuthException> {

    @Override
    public Response toResponse(AuthException e) {

        ErrorMessage msg = new ErrorMessage(e.getMessage(), 401);
        return Response.status(Status.UNAUTHORIZED).entity(msg).build();
    }
}
