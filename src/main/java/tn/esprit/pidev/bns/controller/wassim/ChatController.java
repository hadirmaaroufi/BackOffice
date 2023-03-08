package tn.esprit.pidev.bns.controller.wassim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.wassim.Chat;
import tn.esprit.pidev.bns.serviceInterface.wassim.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/creer")
    public Chat addChat(@RequestBody Chat chat) {
        return chatService.addChat(chat);
    }

    @GetMapping("/read/{id}")
    public Chat getChatById(@PathVariable int id) {
        return chatService.getChatById(id).orElseThrow(() -> new NotFoundException("Chat not found"));
    }

    @PutMapping("/update/{id}")
    public Chat updateChat(@PathVariable int id, @RequestBody Chat chat) {

        return chatService.updateChat(chat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChat(@PathVariable int id) {
        chatService.deleteChat(id);
    }
}

