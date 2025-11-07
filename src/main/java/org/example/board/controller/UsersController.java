package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Users;
import org.example.board.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final UsersRepository usersRepository;

    //회원 가입
    @GetMapping("/register")
    public String register(){
        return "/board/register";
    }
    @PostMapping("/addUsers")
    public String addUsers(@ModelAttribute Users users){
        usersRepository.save(users);
        return "redirect:/list";
    }

}
