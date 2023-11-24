package umc.coffeein;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.web.multipart.MultipartFile;
import umc.coffeein.domain.HashTag;
import umc.coffeein.service.PostService.PostService;
import umc.coffeein.web.dto.PostImgUpload;
import umc.coffeein.web.dto.PostRequest;
import umc.coffeein.web.dto.PostResponse;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CoffeeinApplicationTests {
	@Autowired
	PostService postService;

	@Test
	void contextLoads() throws Exception {

		MockMultipartFile multipartFile= new MockMultipartFile("file", "test.txt", "text/plain", "test file".getBytes(StandardCharsets.UTF_8));
		MockMultipartFile multipartFile2= new MockMultipartFile("file2", "test2.txt", "text/plain", "test file2".getBytes(StandardCharsets.UTF_8));
		List<MultipartFile> list = new ArrayList<>(Arrays.asList(multipartFile, multipartFile2));

		PostRequest.PostRequestDTO pd = PostRequest.PostRequestDTO.builder()
				.body("body")
				.title("title")
				.hashTags(new ArrayList<>(Arrays.asList((long)1, (long)2)))
				.build();
		PostResponse p = postService.createPost(pd, new PostImgUpload(list));




	}

}
