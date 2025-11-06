package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Posts;
import org.example.board.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public void savePosts(String title, String content) {
        Posts posts = new Posts();
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }

    public void updatePosts(Long id, String title, String content) {
        Posts posts = new Posts();
        posts.setId(id);
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }

}
