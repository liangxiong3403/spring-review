package org.liangxiong.demo.spring.util;

import org.springframework.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * @author liangxiong
 * @Date:2019-05-16
 * @Time:16:47
 * @Description JVM参数帮助类,用于开启支持<context:load-time-weaver/>
 */
public class SystemPropertiesHelper implements ServletContextListener {

    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();
        Enumeration<String> params = context.getInitParameterNames();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            String value = context.getInitParameter(param);
            if (param.startsWith("JVM.")) {
                System.setProperty(StringUtils.getFilenameExtension(param), value);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}
