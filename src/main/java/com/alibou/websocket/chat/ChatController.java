package com.alibou.websocket.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private chatHistoryRepository chatHistoryRepository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        // Save the message to the database
        chatHistory chatHistory = new chatHistory();
        chatHistory.setUsername(chatMessage.getSender());
        chatHistory.setChat(chatMessage.getContent());
    
        
        chatHistoryRepository.save(chatHistory);

        return chatMessage; // Broadcast to all clients
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        
        return chatMessage; // Notify all clients that a user joined
    }
}
