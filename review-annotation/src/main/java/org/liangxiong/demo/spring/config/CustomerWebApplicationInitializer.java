package org.liangxiong.demo.spring.config;

import org.liangxiong.demo.spring.component.DiyPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author liangxiong
 * @Date:2019-05-20
 * @Time:17:15
 * @Description 自定义web应用初始化类;通过web.xml的配置完成上下文的初始化
 */
public class CustomerWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 初始化上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 获取environment
        ConfigurableEnvironment environment = context.getEnvironment();
        // 设置激活配置项
        environment.setActiveProfiles("development", "test");
        // 注册配置类
        context.register(BaseConfiguration.class);
        // 定义用于@PropertySource参数占位符的属性值
        MutablePropertySources mutablePropertySources = environment.getPropertySources();
        mutablePropertySources.addFirst(new DiyPropertySource("diy.property.source", "config"));
        // 实例化视图转发servlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        // servlet添加到servlet上下文
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", servlet);
        // 设置启动参数
        dynamic.setLoadOnStartup(1);
        // 设置映射路径
        dynamic.addMapping("/");
    }
}
