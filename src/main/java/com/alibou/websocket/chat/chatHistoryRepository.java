package com.alibou.websocket.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;

@Repository
public interface chatHistoryRepository extends JpaRepository <chatHistory, Long>{ 
    List<chatHistory> findByUsername(String username);

    
}
