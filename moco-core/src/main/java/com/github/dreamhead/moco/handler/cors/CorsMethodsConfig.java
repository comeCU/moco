package com.github.dreamhead.moco.handler.cors;

import com.github.dreamhead.moco.HttpMethod;
import com.github.dreamhead.moco.HttpRequest;
import com.github.dreamhead.moco.MutableHttpResponse;

import java.util.Arrays;

public class CorsMethodsConfig implements CorsConfig {
    private final String[] methods;

    public CorsMethodsConfig(final String[] methods) {
        this.methods = methods;
    }

    @Override
    public final boolean isQualified(final HttpRequest httpRequest) {
        HttpMethod method = httpRequest.getMethod();
        return method.equals(HttpMethod.OPTIONS) || Arrays.stream(methods).anyMatch(m -> method.name().equalsIgnoreCase(m));
    }

    @Override
    public final void configure(final MutableHttpResponse httpResponse) {
        httpResponse.addHeader("Access-Control-Allow-Methods", String.join(",", methods));
    }
}
