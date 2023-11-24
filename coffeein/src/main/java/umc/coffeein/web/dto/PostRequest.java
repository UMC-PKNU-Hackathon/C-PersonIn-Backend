package umc.coffeein.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.coffeein.domain.HashTag;
import umc.coffeein.domain.enums.HashTagEnum;

import java.util.ArrayList;
import java.util.List;

public class PostRequest {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostRequestDTO{
        String title;
        String body;
        List<Long> hashTags;
    }
}
