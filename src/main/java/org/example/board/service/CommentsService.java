package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Comments;
import org.example.board.repository.CommentsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public void addComment(Long parent, String content, Authentication auth){

        UserDetails user = (UserDetails) auth.getPrincipal();

        Comments comments = new Comments();
        comments.setParentId(parent);
        comments.setUsername(user.getUsername());
        comments.setContent(content);
        commentsRepository.save(comments);
    }
}
