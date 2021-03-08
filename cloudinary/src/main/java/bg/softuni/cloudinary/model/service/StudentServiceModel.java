package bg.softuni.cloudinary.model.service;

import org.springframework.web.multipart.MultipartFile;

public class StudentServiceModel {

    private String id;
    private String name;
    private MultipartFile img;

    public StudentServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
