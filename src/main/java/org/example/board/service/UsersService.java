package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Users;
import org.example.board.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public void addUsers(String username, String password, String email){
        Users users = new Users();
        users.setUsername(username);
        String hash = passwordEncoder.encode(password);
        users.setPassword(hash);
        users.setEmail(email);
        usersRepository.save(users);

    }


}
