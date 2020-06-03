package com.bishe.cloud.aspect;

import com.alibaba.fastjson.JSON;
import com.bishe.cloud.util.CloudUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by bishe.cloud on 2016/6/26.
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.bishe.cloud.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        sb.append(joinPoint.toString());
        for (Object arg : joinPoint.getArgs()) {
            sb.append(" arg:" +arg.toString() + "|");
        }
        logger.info("before method: " + JSON.toJSONString(sb));
    }
}
