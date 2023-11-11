package com.billionairestore.apigateway.config;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthenticationFilter implements GlobalFilter {
    private final RouterValidator routerValidator;
    private final JwtUtil jwtutil;

    public AuthenticationFilter(RouterValidator routerValidator, JwtUtil jwtutil) {
        this.routerValidator = routerValidator;
        this.jwtutil = jwtutil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        if (routerValidator.isSecured.test(request)) {
            if (this.isAuthMissing(request))
                return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);

            final String header = this.getAuthHeader(request);
            if (!header.startsWith("Bearer "))
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

            final String token = header.substring("Bearer ".length());
            if (jwtutil.isInvalid(token))
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

            this.populateRequestWithHeaders(exchange, token);
        }
        return chain.filter(exchange);
    }
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }
    private String getAuthHeader(ServerHttpRequest request){
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }
    private boolean isAuthMissing(ServerHttpRequest request){
        return !request.getHeaders().containsKey("Authorization");
    }
    private void populateRequestWithHeaders(ServerWebExchange exchange, String token){
        Claims claims = jwtutil.getAllClaimsFromToken(token);
        exchange.getRequest()
                .mutate()
                .header("userId", String.valueOf(claims.get("UserId")))
                .header("role", String.valueOf(claims.get("role")))
                .build();
    }
}
