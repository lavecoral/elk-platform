package me.lavecoral.elk.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import me.lavecoral.elk.common.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author lave
 * @date 2021/4/1 10:23
 */
public class BusinessExceptionDecoder implements ErrorDecoder {
    private static final Logger log = LoggerFactory.getLogger(BusinessExceptionDecoder.class);

    /**
     * Implement this method in order to decode an HTTP {@link Response} when
     * {@link Response#status()} is not in the 2xx range. Please raise application-specific exceptions
     * where possible. If your exception is retryable, wrap or subclass {@link RetryableException}
     *
     * @param methodKey {@link Feign#configKey} of the java method that invoked the request. ex.
     *                  {@code IAM#getUser()}
     * @param response  HTTP response where {@link Response#status() status} is greater than or equal
     *                  to {@code 300}.
     * @return Exception IOException, if there was a network error reading the response or an
     * application-specific exception decoded by the implementation. If the throwable is
     * retryable, it should be wrapped, or a subtype of {@link RetryableException}
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
            exception = new RuntimeException(json);
            if (Objects.isNull(json)) {
                return null;
            }
            Result<?> result = mapper.readValue(json, Result.class);
            // 业务异常包装成自定义异常类MyException
            if ("failed".equals(result.getStatus())) {
                exception = new BusinessException(result.getCode(), result.getMessage());
            }
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
        return exception;
    }
}
