package org.example.auth.config;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Hidden
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
  /**
	 * 注册拦截器
	 * @param registry
	 */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //registry.addInterceptor(loginInterceptor)
    //  .addPathPatterns("/login/**")
    //  .excludePathPatterns(
    //  "swagger-ui/**",
    //  "/swagger-resources/**",
    //  "/v3/**",
    //  "/webjars/**",
    //  "/doc.html"
    //);
  }

  // 如果上面的配置仍然doc.html空白404，就用下面这个
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/systemPictures/**")
      .addResourceLocations("file:" + System.getProperty("user.dir")+ File.separator+"uploadFile"+File.separator+"systemPictures"+File.separator);
    registry.addResourceHandler("/uploadFile/pluginFiles/logo/**")
      .addResourceLocations("file:" + System.getProperty("user.dir")+ File.separator+"uploadFile"+File.separator+"pluginFiles"+File.separator+"logo"+File.separator);

    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}