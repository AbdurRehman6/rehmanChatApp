package com.alibou.websocket.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;

@Repository
public interface chatHistoryRepository extends JpaRepository <chatHistory, Long>{ 


    
}
