package com.ejder.bid.mate.bidmate.routing;

import com.ejder.bid.mate.bidmate.constants.Common;
import com.ejder.bid.mate.bidmate.constants.Paths;
import com.nimbusds.oauth2.sdk.util.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        for(Paths path : Paths.values()){
            if(StringUtils.isNotBlank(path.view)){
                registry.addViewController(path.path).setViewName(path.view);
            }
        }
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

    @Bean
    public ITemplateResolver templateResolver() {
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        return templateResolver;
    }
}
