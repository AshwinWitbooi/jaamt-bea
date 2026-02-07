package za.co.ashtech.jaatm.bea.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest =
                new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(response);
        
        //Ensure traceId has been set
        final String traceId = Optional.ofNullable(wrappedRequest.getHeader("traceId")).orElseThrow(() -> new NullPointerException("Missing HTTP header: traceId"));

        MDC.put("traceId", traceId);
        
        long startTime = System.currentTimeMillis();

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        long duration = System.currentTimeMillis() - startTime;

        String requestBody = new String(wrappedRequest.getContentAsByteArray(),
                StandardCharsets.UTF_8);
        String responseBody = new String(wrappedResponse.getContentAsByteArray(),
                StandardCharsets.UTF_8);
        
        String httpMethod = request.getMethod();
        
        log.info("PATH: {} HTTP: {} STATUS: {} DURATION: {}ms",request.getRequestURI(), httpMethod, response.getStatus(),duration);
        if(!httpMethod.equalsIgnoreCase("GET") && !httpMethod.equalsIgnoreCase("DELETE")) {
            log.info("REQUEST BODY: {}", requestBody);
        }
        log.info("RESPONSE BODY: {}", responseBody);


        wrappedResponse.copyBodyToResponse(); // IMPORTANT
        
        MDC.clear();
    }

}
