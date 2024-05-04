package com.whatsapp.spring.swagger.service;

import java.util.ArrayList;
import java.util.List;

import com.whatsapp.spring.swagger.model.ChatRoom;
import com.whatsapp.spring.swagger.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
  @Autowired
  private ChatRoomRepository chatRoomRepository;

  public ChatRoom findById(Long id) {
    return chatRoomRepository.findById(id).orElse(null);
  }

}
