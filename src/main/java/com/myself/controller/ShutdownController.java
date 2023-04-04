package com.myself.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoying@talkweb.com.cn
 * @date 2023/4/4
 * @apiNote
 */
@RestController
@Slf4j
public class ShutdownController implements ApplicationContextAware {

    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 业务名称
     *
     * @param 参数
     * @apiNote 逻辑描述
     */
    @GetMapping("/shutdown")
    public void shutdownContext(){
        log.info("调用了关闭程序！");
        ((ConfigurableApplicationContext) context).close();
    }
}
