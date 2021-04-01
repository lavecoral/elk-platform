package me.lavecoral.elk.starter.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import me.lavecoral.elk.common.Constant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author lave
 * @date 2021/4/1 09:41
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    /**
     * Called for every request. Add data using methods on the supplied {@link RequestTemplate}.
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header(Constant.Feign.FLAG, Boolean.TRUE.toString());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.nonNull(attributes)) {
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (Objects.nonNull(headerNames)) {
                //处理上游请求头信息，传递时继续携带
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    template.header(name, values);
                }
            }
        }

    }
}
