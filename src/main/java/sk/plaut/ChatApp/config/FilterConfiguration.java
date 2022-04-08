package sk.plaut.ChatApp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.plaut.ChatApp.filters.LoginFilter;


@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<LoginFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        LoginFilter loginFilter = new LoginFilter();

        registrationBean.setFilter(loginFilter);
        registrationBean.addUrlPatterns("/message");

        return registrationBean;
    }


}
