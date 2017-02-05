package co.inventorsoft.spring.data.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author anatolii vakaliuk
 */
@Slf4j
public class QueryExecutionPrinterInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startExecution = System.currentTimeMillis();
        Object result = invocation.proceed();
        long endExecution = System.currentTimeMillis();

        logExecutionTime(startExecution, endExecution);
        return result;
    }

    private void logExecutionTime(final long startExecution, final long endExecution) {
        log.info("Query took {} milliseconds to execute", endExecution - startExecution);
    }
}
