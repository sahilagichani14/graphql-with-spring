package graphqlwithspring;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType type;
        if (ex instanceof DataIntegrityViolationException) {
            type = ErrorType.OperationNotSupported;
        } else {
            type = ErrorType.InvalidSyntax;
        }
        return GraphqlErrorBuilder.newError(env)
                .message("Received Messsage: " + ex.getMessage())
                .errorType(type)
                .build();
    }
}
