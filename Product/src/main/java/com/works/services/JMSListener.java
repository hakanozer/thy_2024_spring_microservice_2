package com.works.services;

import com.works.entities.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JMSListener {


    @JmsListener(containerFactory = "productContainerFactory", destination = "q1")
    public void jsmListener(Product product) {
        System.out.println("Jms - " + product);
    }

}
