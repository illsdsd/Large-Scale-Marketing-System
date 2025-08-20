package cn.bugstack;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configurable
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {
    @Bean
    public MessageConverter messageConverter(){
        SimpleMessageConverter  simpleMessageConverter = new SimpleMessageConverter();
        simpleMessageConverter.setCreateMessageIds(true);
        return simpleMessageConverter;
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }



}
