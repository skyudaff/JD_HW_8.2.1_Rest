package com.example.rest.repository;

import com.example.rest.model.Authorities;
import com.example.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<User, List<Authorities>> userList = new ConcurrentHashMap<>();

    {
        userList.put(new User("user1", "12345"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        userList.put(new User("Ivan", "qwe123"), List.of(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        var checkUser = new User(user, password);
        for (Map.Entry<User, List<Authorities>> entry : userList.entrySet()) {
            if (checkUser.equals(entry.getKey())) return entry.getValue();
        }
        return null;
    }
}
