package com.sv.articulos.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.sv.articulos.models.ItemModel;

@Controller
public class ItemWebSocketController {
    @MessageMapping("/items")
    @SendTo("/topic/items")
    public ItemModel handleItem(ItemModel itemRequest) {
        // Procesar el item
        return new ItemModel();
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Método para notificar a los clientes cuando hay un nuevo item
    public void notifyItemCreated(ItemModel item) {
        messagingTemplate.convertAndSend("/topic/items", item);
    }
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) {
        return "Hello, " + message + "!";
    }
}
