package me.lavecoral.elk.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.lavecoral.elk.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lave
 * @date 2021/4/1 03:59
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final Logger log = LoggerFactory.getLogger(ResponseAdvice.class);
    private static final String ACTUATOR_CONTENT_TYPE = "application/vnd.spring-boot.actuator.v3+json";

    /**
     * Whether this component supports the given controller method return type
     * and the selected {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Class<?> clazz = returnType.getContainingClass();
        return clazz.isAnnotationPresent(RestController.class)
                || clazz.isAnnotationPresent(ResponseBody.class)
                || returnType.getMethodAnnotation(ResponseBody.class) != null;
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (ACTUATOR_CONTENT_TYPE.equals(selectedContentType.toString())) {
            return body;
        }
        if (request.getHeaders().containsKey(Constant.Feign.FLAG)) {
            return body;
        }

        if (!(body instanceof Result)) {
            Result<Object> result = Result.of(body);
            //因为handler处理类的返回类型是String，为了保证一致性，这里需要将ResponseResult转回去
            if (body instanceof String) {
                try {
                    return new ObjectMapper().writeValueAsString(result);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return body;
                }
            }
            return result;
        }
        return body;
    }
}
