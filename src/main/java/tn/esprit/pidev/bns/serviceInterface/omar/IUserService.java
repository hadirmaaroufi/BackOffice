package tn.esprit.pidev.bns.serviceInterface.omar;

import tn.esprit.pidev.bns.entity.omar.User;

public interface IUserService {
    public User getById(int id) ;

    public User addUser(User user);
}
