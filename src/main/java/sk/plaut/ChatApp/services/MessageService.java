package sk.plaut.ChatApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import sk.plaut.ChatApp.data.Messages;
import sk.plaut.ChatApp.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Messages> getMessages(Long userId){
        return messageRepository.findByUserId(userId);
    }

    public void addMessage(Messages message){
        messageRepository.save(message);
    }
}
