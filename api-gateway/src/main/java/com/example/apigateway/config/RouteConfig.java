package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

  @Bean
  public RouteLocator createRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
      .route("products-service-route", route -> route.path("/api/products/**").uri("http://localhost:8081"))
        .route("users-service-route", route -> route.path("/api/users/**").uri("http://localhost:8082"))
      .build();
  }
}
