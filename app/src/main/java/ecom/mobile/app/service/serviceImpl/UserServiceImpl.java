package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.User;
import ecom.mobile.app.repository.UserRepository;
import ecom.mobile.app.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByAccountEmail(String accountEmail) {
        return userRepository.findByAccountEmail(accountEmail);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
