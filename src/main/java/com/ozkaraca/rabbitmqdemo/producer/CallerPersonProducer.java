package com.ozkaraca.rabbitmqdemo.producer;

import com.ozkaraca.rabbitmqdemo.model.CallerPerson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class CallerPersonProducer {
    //kuyruga message gonderen kisi

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate; //rabbitmq'nun connection nesnesi gibi bunun üzerinden gidiyoruz sunucuya

    @PostConstruct
    public void init() { //prodece edilecek nesne dogru bir sekilde initialize olduktan sonra message'ı gondersin
        runSomething();
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void runSomething() {

        CallerPerson callerPerson = new CallerPerson();
        callerPerson.setcallerPersonId(UUID.randomUUID().toString());
        callerPerson.setCreatedAt(new Date());
        callerPerson.setMessage("WELCOME TO RABBITMQ");
        callerPerson.setSeen(Boolean.FALSE);
        sendToQueue(callerPerson);//producer, şu message imi queue'ye yolla
    }

    public void sendToQueue(CallerPerson callerPerson) {
        System.out.println("CallerPerson Sent ID : " + callerPerson.getcallerPersonId());
        // her mssage gonderdiginde gonderdigi messageın id'sini ekrana yazsın

        rabbitTemplate.convertAndSend(exchangeName, routingName, callerPerson);
        //istedigimiz routinge message'ımızı atıcak
    }
}