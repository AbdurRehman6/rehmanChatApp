package com.alibou.websocket.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chatHistoyService {
    @Autowired
    private chatHistoryRepository ChatHistoryRepository;
    public void chatHistorySave (chatHistory chat) {
        ChatHistoryRepository.save(chat);
    } 
}
