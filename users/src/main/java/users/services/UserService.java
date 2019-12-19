package users.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import users.DAO.UserDao;
import users.models.User;

import java.util.List;

@Service
@Primary
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    public void add(User entity) {
        userDao.add(entity);
    }

    @Transactional
    public User getById(int id) {
        return (User) userDao.getById(id);
    }

    @Transactional
    public void update(User entity) {
        userDao.update(entity);
    }

    @Transactional
    public void deleteById(int id) {
        User res = (User) userDao.getById(id);
        userDao.delete(res);
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

}
