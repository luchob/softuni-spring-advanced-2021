package bg.softuni.cloudinary.service;

import bg.softuni.cloudinary.model.service.StudentServiceModel;
import bg.softuni.cloudinary.model.view.StudentViewModel;
import java.io.IOException;
import java.util.List;

public interface StudentService {

    void addStudent(StudentServiceModel studentServiceModel) throws IOException;

    List<StudentViewModel> findAll();
}
