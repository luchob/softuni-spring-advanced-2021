package bg.softuni.cloudinary.service.impl;

import bg.softuni.cloudinary.model.entity.StudentEntity;
import bg.softuni.cloudinary.model.service.StudentServiceModel;
import bg.softuni.cloudinary.model.view.StudentViewModel;
import bg.softuni.cloudinary.repository.StudentRepository;
import bg.softuni.cloudinary.service.CloudinaryService;
import bg.softuni.cloudinary.service.StudentService;
import com.cloudinary.Cloudinary;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper modelMapper;
  private final CloudinaryService cloudinaryService;

  public StudentServiceImpl(CloudinaryService cloudinaryService,
      StudentRepository studentRepository,
      ModelMapper modelMapper) {
    this.cloudinaryService = cloudinaryService;
    this.studentRepository = studentRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void addStudent(StudentServiceModel studentServiceModel) throws IOException {
    MultipartFile img = studentServiceModel.getImg();
    String imageUrl = cloudinaryService.uploadImage(img);

    StudentEntity studentEntity = new StudentEntity().
        setName(studentServiceModel.getName()).
        setImgUrl(imageUrl);

    studentRepository.save(studentEntity);
  }

  @Override
  public List<StudentViewModel> findAll() {
    return studentRepository.
        findAll().
        stream().
        map(se -> modelMapper.map(se, StudentViewModel.class)).
        collect(Collectors.toList());
  }
}
