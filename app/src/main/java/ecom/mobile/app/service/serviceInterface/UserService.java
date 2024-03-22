package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.User;

public interface UserService {
    User findByAccountEmail(String accountEmail);

    User saveOrUpdate(User user);
}
