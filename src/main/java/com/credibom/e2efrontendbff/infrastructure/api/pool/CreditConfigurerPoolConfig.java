package com.credibom.e2efrontendbff.infrastructure.api.pool;

import feign.Client;
import feign.Request;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class CreditConfigurerPoolConfig {

    @Value("${pool.e2e-frontend-bff.maxConn}")
    private Integer connPerRoute;

    @Value("${pool.e2e-frontend-bff.maxRoutes}")
    private Integer maxConnTotal;

    @Value("${pool.e2e-frontend-bff.connTimeout}")
    private Integer connTimeout;

    @Value("${pool.e2e-frontend-bff.readTimeout}")
    private Integer readTimeout;

    @Bean
    public Request.Options options() {
        return new Request.Options(connTimeout, readTimeout);
    }

    @Bean
    public Client poolConfig() {
        return new ApacheHttpClient(
                HttpClientBuilder.create()
                        .setMaxConnPerRoute(connPerRoute)
                        .setMaxConnTotal(maxConnTotal)
                        .build()
        );
    }

}
