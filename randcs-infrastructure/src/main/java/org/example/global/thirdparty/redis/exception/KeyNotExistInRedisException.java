package org.example.global.thirdparty.redis.exception;

import org.example.common.error.RandcsException;
import org.example.global.thirdparty.redis.exception.errorCode.RedisErrorCode;

public class KeyNotExistInRedisException extends RandcsException {
    public static final KeyNotExistInRedisException EXCEPTION = new KeyNotExistInRedisException();
    public KeyNotExistInRedisException() { super(RedisErrorCode.KEY_NOT_EXIST_IN_REDIS); }
}
