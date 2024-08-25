package com.ghtjr.microservices.notification.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MailAspect {
    private final ObservationRegistry observationRegistry;

    @Around("execution(* org.springframework.mail.javamail.JavaMailSender+.send(..))")
    public Object observeMailSending(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Observation observation = Observation.start("mail.send." + methodName, observationRegistry);
        try {
            return observation.observe(() -> {
                try {
                    return joinPoint.proceed();
                } catch (Throwable throwable) {
                    observation.error(new RuntimeException(throwable));
                    throw new RuntimeException(throwable);
                }
            });
        } finally {
            observation.stop();
        }
    }
}
