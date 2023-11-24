package umc.coffeein.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostImgUpload {
    private List<MultipartFile> files;

    public PostImgUpload(List<MultipartFile> files){
        this.files = files;
    }
}
