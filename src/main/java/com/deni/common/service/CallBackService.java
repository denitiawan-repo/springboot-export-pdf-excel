package com.deni.common.service;

public interface CallBackService {

    public void http2xx(String message, Object data);

    public void http4xx(String message, Object data);

}
