package iostar.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

public class WebMvcConfig implements WebMvcConfigurer {
    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver= new CookieLocaleResolver();
        resolver.setCookieDomain("iostar");
        resolver.setDefaultLocale (Locale.ENGLISH);
        return resolver;
    }
    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
// Đọc vào file src/main/resources/i18n/messages_xxx.properties
// Ví dụ: i18n/messages_en.properties
        messageResource.setBasename("classpath: i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }
    @Override
    public void addInterceptors (InterceptorRegistry registry)
    {
    LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    localeInterceptor.setParamName("language");
    registry.addInterceptor (localeInterceptor).addPathPatterns("/*");
    }
}
