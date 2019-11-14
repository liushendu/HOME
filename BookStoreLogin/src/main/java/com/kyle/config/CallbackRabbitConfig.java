package com.kyle.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CallbackRabbitConfig {

        @Bean
        public Queue queueMessage(){
//        此处命名为queue名称 ：topic.message
            return new Queue("mail");
        }
        //创建topic类型的交换机
        @Bean
        public TopicExchange  exchange(){
            //        此处命名为TopicExcahnge名称 ：topicExchange
            return new TopicExchange("topicExchange");
        }
        //    将交换机绑定到队列topic.message上；
        @Bean
        public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
            return BindingBuilder.bind(queueMessage).to(exchange).with("topic.me");
        }
    }


