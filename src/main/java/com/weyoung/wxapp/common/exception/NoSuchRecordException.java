///:NoSuchRecordException.java
package com.weyoung.wxapp.common.exception;

/**
 * @author icechen1219
 * @date 2019/08/15
 */
public class NoSuchRecordException extends RuntimeException {
    public NoSuchRecordException() {
        this("没有对应的记录", null);
    }

    public NoSuchRecordException(String message) {
        this(message, null);
    }

    public NoSuchRecordException(Throwable cause) {
        this("没有对应的记录", cause);
    }

    public NoSuchRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
///:NoSuchRecordException.java
