package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Comments;
import org.example.board.repository.CommentsRepository;
import org.example.board.service.CommentsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsRepository commentsRepository;
    private final CommentsService commentsService;

    //댓글 달기
    @PostMapping("/comment")
    public String comment(@RequestParam Long parent, @RequestParam String content, Authentication auth) {
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            System.out.println("로그인하세요.");
            return "redirect:/login";
        }
        commentsService.addComment(parent, content, auth);
        return "redirect:/list";
    }

}
