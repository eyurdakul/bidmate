package com.ejder.bid.mate.bidmate.routing;

import com.ejder.bid.mate.bidmate.common.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        for(Paths path : Paths.values()){
            if(null != path.view){
                registry.addViewController(path.path).setViewName(path.view);
            }
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //@TODO add css js and test
        registry.addResourceHandler("/public/resources/**", "/user/resources/**", "/admin/resources/**")
                .addResourceLocations("public/resources", "user/resources", "admin/resources")
                .setCachePeriod(31556926);
    }

}
