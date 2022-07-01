package org.soyphea.k8s.srevice;

import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    List<User> users = Arrays.asList(new User(), new User());

    public List<User> getUser(String containName) {

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }

}
