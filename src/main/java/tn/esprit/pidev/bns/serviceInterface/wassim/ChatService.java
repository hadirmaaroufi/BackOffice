package tn.esprit.pidev.bns.serviceInterface.wassim;

import tn.esprit.pidev.bns.entity.wassim.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    Chat addChat(Chat chat);

    Optional<Chat> getChatById(int id);

    Chat updateChat(Chat chat);

    String deleteChat(int id);

    List<Chat> getAllChats();
}






