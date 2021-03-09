package bg.softuni.cloudinary.service.impl;

import bg.softuni.cloudinary.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

  private static final String TEMP_FILE = "temp-file";
  private static final String URL = "url";

  private final Cloudinary cloudinary;

  public CloudinaryServiceImpl(Cloudinary cloudinary) {
    this.cloudinary = cloudinary;
  }

  @Override
  public String uploadImage(MultipartFile multipartFile) throws IOException {
    File file = File.createTempFile(TEMP_FILE, multipartFile.getOriginalFilename());
    multipartFile.transferTo(file);

    return this.cloudinary
        .uploader()
        .upload(file, Collections.emptyMap())
        .get(URL)
        .toString();
  }
}
