package com.ozkaraca.rabbitmqdemo.listener;

import com.ozkaraca.rabbitmqdemo.model.CallerPerson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CallerPersonListener {

    @RabbitListener(queues = "oguz-queue") //message'ı bu kuyruktan dinleyecek
    public void handleMessage(CallerPerson callerPerson) { //çağrıyı alıp process eder
        System.out.println("call received..");
        System.out.println(callerPerson.toString()); //aldıgı her msjı ekrana yazacak

    }
}
