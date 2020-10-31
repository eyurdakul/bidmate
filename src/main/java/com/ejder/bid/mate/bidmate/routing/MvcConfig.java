package com.ejder.bid.mate.bidmate.routing;

import com.ejder.bid.mate.bidmate.constants.Common;
import com.ejder.bid.mate.bidmate.constants.Paths;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Common.DEFAULT_LANG);
        return cookieLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(Common.LANG_PARAM);
        return localeChangeInterceptor;
    }
}
