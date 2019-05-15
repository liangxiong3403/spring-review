package org.liangxiong.demo.spring.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

/**
 * @author liangxiong
 * @Date:2019-05-15
 * @Time:11:21
 * @Description 获取LoadTimeWeaverAware实例
 */
@Slf4j
public class LoadTimeWeaverHelper implements LoadTimeWeaverAware {

    private LoadTimeWeaver loadTimeWeaver;

    private MessageSource messageSource;

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        this.loadTimeWeaver = loadTimeWeaver;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void execute() {
        String message = this.messageSource.getMessage("argument.required", new String[]{"userDAO"}, "required", null);
        log.info("argument.required: {}", message);
    }
}
