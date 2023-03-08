package tn.esprit.pidev.bns.service.wassim;

import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.wassim.Chat;
import tn.esprit.pidev.bns.repository.wassim.ChatRepository;
import tn.esprit.pidev.bns.serviceInterface.wassim.ChatService;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat addChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Optional<Chat> getChatById(int id) {
        return chatRepository.findById(id);
    }

    @Override
    public Chat updateChat(Chat chat) {
        Optional<Chat> chatOptional = chatRepository.findById(chat.getId());
        if (chatOptional.isPresent()) {
            Chat existingChat = chatOptional.get();
            existingChat.setMessage(chat.getMessage());
            existingChat.setSentAt(chat.getSentAt());
            existingChat.setSender(chat.getSender());
            existingChat.setRecipient(chat.getRecipient());

            return chatRepository.save(existingChat);

        } return null;
    }


    @Override
    public String deleteChat(int id) {
        chatRepository.deleteById(id);
        return "Request supprimer";

    }

    @Override
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}

