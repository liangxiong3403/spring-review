package org.liangxiong.demo.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.liangxiong.demo.spring.event.AccidentFireEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author liangxiong
 * @Date:2019-05-15
 * @Time:15:54
 * @Description
 */
@Slf4j
public class AccidentFireListener implements ApplicationListener<AccidentFireEvent> {

    @Override
    public void onApplicationEvent(AccidentFireEvent event) {
        log.info("listener diy event: {}", event);
    }
}
