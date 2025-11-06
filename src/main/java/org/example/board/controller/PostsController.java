package org.example.board.controller;

import org.example.board.domain.Posts;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.example.board.repository.PostsRepository;
import org.example.board.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class PostsController {

    private final PostsRepository postsRepository;
    private final PostsService postsService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("posts", postsService.findAll());
        return "/board/list";
    }

    //게시글 작성
    @GetMapping("/write")
    public String write(Model model) {
        return "/board/write";
    }
    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String content) {
        postsService.savePosts(title, content);
        return "redirect:/list";
    }

    //게시글 상세보기
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Posts> result = postsRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "/board/detail";
        } else {
            return "redirect:/list";
        }
    }

    //게시글 수정
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Posts> result = postsRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "/board/edit";
        }else {
            return "redirect:/list";
        }
    }
    @PostMapping("/edit")
    public String edit(Long id, String title, String content){
        postsService.updatePosts(id, title, content);
        return "redirect:/list";
    }

    //게시글 삭제
    /*
    * 1. 게시글 삭제
    * 2. 회원 가입 및 로그인
    * 3. 회원 삭제
    * 4. 댓글 등록
    * 5. 댓글 목록 조회
    * 6. 댓글 삭제
    * 7. 시간 나면 full text index 사용해서 검색기능 만들기
    * 8. 테스트 코드도 작성해보기
    * */


}
