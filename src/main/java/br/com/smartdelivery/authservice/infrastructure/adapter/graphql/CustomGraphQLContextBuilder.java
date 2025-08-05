package br.com.smartdelivery.authservice.infrastructure.adapter.graphql;

import graphql.GraphQLContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomGraphQLContextBuilder {

    public GraphQLContext build(HttpServletRequest request, HttpServletResponse response) {
        GraphQLContext context = GraphQLContext.newContext().build();
        context.put("request", request);
        context.put("response", response);
        return context;
    }
}

