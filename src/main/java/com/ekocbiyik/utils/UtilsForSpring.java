package com.ekocbiyik.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by enbiya on 02.05.2017.
 */
@Component
public class UtilsForSpring implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T getSingleBeanOfType(Class<T> beanClass) {
        return context.getBeansOfType(beanClass).values().iterator().next();
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        UtilsForSpring.context = context;
    }
}
