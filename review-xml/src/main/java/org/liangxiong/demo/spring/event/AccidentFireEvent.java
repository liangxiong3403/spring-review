package org.liangxiong.demo.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author liangxiong
 * @Date:2019-05-15
 * @Time:15:51
 * @Description 自定义事件
 */
@Slf4j
public class AccidentFireEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AccidentFireEvent(Object source) {
        super(source);
        log.info("diy event: {}", source);
    }
}
