package com.alibou.websocket.chat;

import com.alibou.websocket.chat.chatHistory;
import com.alibou.websocket.chat.chatHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private chatHistoryRepository ChatHistoryRepository;

    @GetMapping("/history")
    public List<chatHistory> getChatHistory() {
        // Retrieve all saved chat messages from the database

        System.out.println(ChatHistoryRepository.findAll());
        return ChatHistoryRepository.findAll();
    }
}
