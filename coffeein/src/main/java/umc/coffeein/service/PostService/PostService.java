package umc.coffeein.service.PostService;

import umc.coffeein.web.dto.*;

import java.util.List;

public interface PostService {
    public PostResponse createPost(PostRequest.PostRequestDTO requestDTO, PostImgUpload postImgUpload) throws Exception;
    public List<PostListResponse> findAllPost() throws Exception;
    public PostResponse findPost(Long id) throws Exception;

    public Integer like(Long id) throws Exception;
    public Integer ulike(Long id) throws Exception;
    public CommentResponse createComment(CommentRequest commentRequest, Long id) throws Exception;
    public List<CommentResponse> commentList(Long id) throws Exception;
    public List<PostListResponse> searchPost(Long id) throws Exception;
}
