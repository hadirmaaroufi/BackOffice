package tn.esprit.pidev.bns.service.omar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.omar.User;
import tn.esprit.pidev.bns.repository.omar.IUserRepo;
import tn.esprit.pidev.bns.serviceInterface.omar.IUserService;
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;
    @Override
    public User getById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }
}
