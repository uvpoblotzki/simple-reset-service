package io.github.uvpoblotzki.service;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.ServletRequest;

public class GreetingParamWebArgumentResolver implements WebArgumentResolver {

  @Override
  public Object resolveArgument(final MethodParameter methodParameter, final NativeWebRequest nativeWebRequest)
      throws Exception
  {
    final GreetingParam greetingParam = methodParameter.getParameterAnnotation(GreetingParam.class);

    if (greetingParam != null) {
      if (nativeWebRequest.getNativeRequest() instanceof ServletRequest) {
        final ServletRequest request = (ServletRequest) nativeWebRequest.getNativeRequest();
        return request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
      }
    }
    return UNRESOLVED;
  }

}
