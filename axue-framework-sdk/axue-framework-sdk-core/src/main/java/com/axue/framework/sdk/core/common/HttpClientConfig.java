package com.axue.framework.sdk.core.common;

import lombok.Data;

import java.util.concurrent.ExecutorService;

/**
 * 客户端配置
 *
 * @author axue
 */
@Data
public class HttpClientConfig {

    private int maxIdleConnections = 5;

    private long maxIdleTimeMillis = 60000L;

    private long keepAliveDurationMillis = 5000L;

    private long connectionTimeoutMillis = 15000L;

    private long readTimeoutMillis = 15000L;

    private long writeTimeoutMillis = 15000L;

    private int maxRequests = 64;

    private int maxRequestsPerHost = 5;

    private Runnable idleCallback = null;

    private ExecutorService executorService = null;

}
