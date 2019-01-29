package com.bonolex.JavaBasic.lesson_10;

import java.time.LocalDateTime;

public class LogToken {
    private LocalDateTime time;
    private String message;
    private HttpMethod method;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}
