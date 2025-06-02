package com.design.rate_limiter;

public interface RateLimiter {
    boolean allowRequest(String clientId);
}
