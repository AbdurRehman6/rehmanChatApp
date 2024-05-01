package com.alibou.websocket.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class chatHistory {
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatHistory_sequence")
	@SequenceGenerator(name = "chatHistory_sequence", sequenceName = "chatHistory_sequence", allocationSize = 1)
    private long Id;
    private String username;
    private String chat;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getChat() {
        return chat;
    }
    public void setChat(String chat) {
        this.chat = chat;
    }
}
