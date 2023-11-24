package umc.coffeein.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.coffeein.api.ApiResponse;
import umc.coffeein.domain.HashTag;
import umc.coffeein.service.PostService.PostServiceImpl;
import umc.coffeein.web.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostRestController {
    private final PostServiceImpl postService;

    public PostRestController(PostServiceImpl postService){
        this.postService = postService;
    }

    // post 생성
    @PostMapping("/post")
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest.PostRequestDTO postRequest, @ModelAttribute @RequestPart PostImgUpload postImgUpload) throws Exception {
        PostResponse post = postService.createPost(postRequest, postImgUpload);

        return ApiResponse.onSuccess(post);
    }

    // 전체 post 조회
    @GetMapping("/post")
    public ApiResponse<List<PostListResponse>> getAllPost() throws Exception {
        return ApiResponse.onSuccess(postService.findAllPost());
    }

    // post 한 개 조회
    @GetMapping("/post/{id}")
    public ApiResponse<PostResponse> getOnePost(@PathVariable Long id) throws Exception{
        return ApiResponse.onSuccess(postService.findPost(id));
    }

    @PostMapping("/post/{id}/like")
    public ApiResponse<Integer> likeAdd(@PathVariable Long id) throws Exception{
        return ApiResponse.onSuccess(postService.like(id));
    }

    @DeleteMapping("/post/{id}/like")
    public ApiResponse<Integer> ulikeAdd(@PathVariable Long id) throws Exception{
        return ApiResponse.onSuccess(postService.ulike(id));
    }

    // 댓글 작성
    @PostMapping("/post/{id}/comment")
    public ApiResponse<CommentResponse> createComment(@RequestBody CommentRequest commentRequest, @PathVariable Long id) throws Exception {
        return ApiResponse.onSuccess(postService.createComment(commentRequest, id));
    }

    // 댓글 조회
    @GetMapping("/post/{id}/comment")
    public ApiResponse<List<CommentResponse>> getPostComment(@PathVariable Long id) throws Exception {
        return ApiResponse.onSuccess(postService.commentList(id));
    }

    // 해시태그 검색
    @GetMapping("/search/{id}")
    public ApiResponse<List<PostListResponse>> searchPostTagId(@PathVariable Long id) throws Exception {
        return ApiResponse.onSuccess(postService.searchPost(id));
    }

    // post 별 해시태그 조회
    @GetMapping("/post/{id}/tag")
    public ApiResponse<List<String>> postHashTag(@PathVariable Long id) throws Exception {
        return ApiResponse.onSuccess(postService.postHashTag(id));
    }

    // tag 전체 조회
    @GetMapping("/search")
    public ApiResponse<List<HashTag>> hashTagList() throws Exception{
        return ApiResponse.onSuccess(postService.hashTagList());
    }

}
