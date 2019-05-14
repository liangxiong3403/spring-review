package org.liangxiong.demo.spring.component;

import org.springframework.core.env.PropertySource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangxiong
 * @Date:2019-05-14
 * @Time:14:03
 * @Description 自定义PropertySource;simply implement and instantiate your own
 * PropertySource and add it to the set of PropertySources for the current Environment
 */
public class DiyPropertySource extends PropertySource<String> {

    private Map<String, Object> data = new ConcurrentHashMap<>(8);

    public DiyPropertySource(String name, String source) {
        super(name, source);
        data.put(name, source);
    }

    @Override
    public Object getProperty(String name) {
        return data.get(name);
    }
}
