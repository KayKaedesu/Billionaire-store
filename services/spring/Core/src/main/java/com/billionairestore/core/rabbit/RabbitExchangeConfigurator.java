package com.billionairestore.core.rabbit;

import com.rabbitmq.client.*;

public class RabbitExchangeConfigurator {
    public static void initialize(RabbitServiceRegistration registration) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        try {
            Connection connection = factory.newConnection();
            Channel channel =  connection.createChannel();
            channel.exchangeDeclare(registration.getExchangeName(), BuiltinExchangeType.DIRECT, true);
            for (RabbitQueue queue : registration.getQueues()) {
                channel.queueDeclare(queue.getQueueName(), true, false, false, null);
                AMQP.Queue.BindOk queueOk = channel.queueBind(queue.getQueueName(), registration.getExchangeName(), queue.getRoutingKey());
            }
        } catch (Exception e) {
            System.out.println("RabbitMQ is not running");
            System.exit(1);
        }

    }
}
