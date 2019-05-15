package org.liangxiong.demo.spring.component;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

/**
 * @author liangxiong
 * @Date:2019-05-15
 * @Time:11:21
 * @Description 获取LoadTimeWeaverAware实例
 */
@Component
public class LoadTimeWeaverHelper implements LoadTimeWeaverAware {

    private LoadTimeWeaver loadTimeWeaver;

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        this.loadTimeWeaver = loadTimeWeaver;
    }
}
