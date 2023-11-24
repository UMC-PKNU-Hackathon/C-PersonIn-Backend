package umc.coffeein.service.PostService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import umc.coffeein.domain.Comment;
import umc.coffeein.domain.HashTag;
import umc.coffeein.domain.Post;
import umc.coffeein.domain.PostImg;
import umc.coffeein.domain.enums.HashTagEnum;
import umc.coffeein.domain.mapping.PostTag;
import umc.coffeein.repository.*;
import umc.coffeein.web.dto.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostImgRepository postImgRepository;
    private final CommentRepository commentRepository;
    private final PostTagRepository postTagRepository;
    private final HashTagRepository hashTagRepository;

    @Value("${file.postImgPath}")
    private static String uploadFolder;

    // post 생성
    @Override
    @Transactional
    public PostResponse createPost(PostRequest.PostRequestDTO requestDTO, PostImgUpload postImgUpload) throws Exception{
        Post post = new Post(requestDTO);


        for(Long h : requestDTO.getHashTags()) {
            HashTag hashTag = hashTagRepository.findById(h).orElseThrow(
                    () -> new IllegalArgumentException("존재하지 않는 해시태그")
            );
            ;
            PostTag postTag = PostTag.builder()
                    .hashTag(hashTag)
                    .post(post)
                    .build();

            hashTagRepository.save(hashTag);
            postTagRepository.save(postTag);

        }

        List<PostImg> pi = new ArrayList<>();

        if(postImgUpload != null && !postImgUpload.getFiles().isEmpty()){
            for(MultipartFile file : postImgUpload.getFiles()){
                UUID uuid = UUID.randomUUID();
                String imageFileName = uuid + "_" + file.getOriginalFilename();

                File destinationFile = new File(uploadFolder + imageFileName);

                try {
                    file.transferTo(destinationFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                PostImg postImg = PostImg.builder()
                        .imgUrl("/postImg/" + imageFileName)
                        .post(post)
                        .build();

                pi.add(postImg);
            }
        }

        post.setPostImgs(pi);

        //for(PostImg postlmg : pi) {
          //  postlmg.
        //}

        postRepository.save(post);

        return new PostResponse(post);
    }

    // 모든 post 가져오기
    @Override
    public List<PostListResponse> findAllPost() throws Exception{
        List<Post> postList = postRepository.findAll();
        List<PostListResponse> postResponseList = new ArrayList<>();

        for(Post post : postList){
            postResponseList.add(new PostListResponse(post));
        }

        return postResponseList;
    }


    // post 한 개 가져오기
    @Override
    public PostResponse findPost(Long id) throws Exception{ // post id
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return new PostResponse(post);
    }

    // 좋아요
    public Integer like(Long id) throws Exception{ // post id
        Post post = postRepository.findById(id).orElseThrow();
        post.setLikeCount(post.getLikeCount()+1);

        postRepository.save(post);

        return post.getLikeCount();
    }

    // 좋아요 취소
    public Integer ulike(Long id) throws Exception{ // post id
        Post post = postRepository.findById(id).orElseThrow();
        post.setLikeCount(post.getLikeCount()-1);

        postRepository.save(post);

        return post.getLikeCount();
    }

    // 댓글 달기
    public CommentResponse createComment(CommentRequest commentRequest, Long id) throws Exception{
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .comment(commentRequest.getComment())
                .post(post)
                .build();

        commentRepository.save(comment);

        return new CommentResponse(comment);
    }

    // post 당 댓글 조회
    public List<CommentResponse> commentList(Long id) throws Exception{
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));

        List<Comment> comments = commentRepository.findByPost(post);


        return comments.stream()
                .map(comment -> CommentResponse.builder()
                        .comment(comment)
                        .build())
                .collect(Collectors.toList());
    }

    // 해시태그에 해당되는 post 조회
    public List<PostListResponse> searchPost(Long id) throws Exception{ // 해시태그 id
        List<PostTag> postTags = postTagRepository.findAll();
        List<PostListResponse> postResponseList = new ArrayList<>();

        for(PostTag posttag : postTags){
            if(posttag.getHashTag().getId() == id) {
                postResponseList.add(new PostListResponse(posttag.getPost()));
            }
        }

        return postResponseList;
    }

    // 댓글 개수
    public Integer countComment(Long id) throws Exception{ // post id
        List<Comment> comments = commentRepository.findAll();
        int cnt = 0;

        for(Comment c : comments){
            if(c.getPost().getId() == id)
                cnt++;
        }

        return cnt;
    }

    // 게시글 별 해시태그 조회
    public List<String> postHashTag(Long id) throws Exception { // post id
        List<PostTag> postTags = postTagRepository.findAll();
        List<String> postTagLists = new ArrayList<>();

        for(PostTag posttag : postTags){
            if(posttag.getPost().getId() == id) {
                postTagLists.add(posttag.getHashTag().getName());
            }
        }

        return postTagLists;
    }

    // tag 전체 조회
    public List<HashTag> hashTagList() throws Exception {
        return hashTagRepository.findAll();
    }

}
