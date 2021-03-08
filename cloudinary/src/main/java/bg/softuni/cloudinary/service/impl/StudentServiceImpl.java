package bg.softuni.cloudinary.service.impl;

import bg.softuni.cloudinary.model.service.StudentServiceModel;
import bg.softuni.cloudinary.model.entity.StudentEntity;
import bg.softuni.cloudinary.model.view.StudentViewModel;
import bg.softuni.cloudinary.repository.StudentRepository;
import bg.softuni.cloudinary.service.CloudinaryService;
import bg.softuni.cloudinary.service.StudentService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final CloudinaryService cloudinaryService;

    public StudentServiceImpl(ModelMapper modelMapper, StudentRepository studentRepository, CloudinaryService cloudinaryService) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public void addStudent(StudentServiceModel studentServiceModel) throws IOException {
        StudentEntity student = this.modelMapper
                .map(studentServiceModel, StudentEntity.class);

        String image = this.cloudinaryService
                .uploadImage(studentServiceModel.getImg());

        student.setImgUrl(image);

        this.studentRepository.saveAndFlush(student);
    }

    @Override
    public List<StudentViewModel> findAll() {
        return this.studentRepository
                .findAll()
                .stream()
                .map(s -> modelMapper.map(s, StudentViewModel.class))
                .collect(Collectors.toList());
    }
}
