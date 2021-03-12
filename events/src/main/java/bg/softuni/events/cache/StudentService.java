package bg.softuni.events.cache;

import bg.softuni.events.beans.AnnotatedComponent;
import java.util.List;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private static Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

  @Cacheable("students")
  public List<Student> findAllStudents() {
    LOGGER.info("Making complicated student calculations...");
    // lots of calculations
    return getDummyStudents();
  }

  @CacheEvict(cacheNames = "students",allEntries = true)
  public void purgeCache() {
    LOGGER.info("Purging cache...");
  }

  private List<Student> getDummyStudents() {
    return List.of(new Student("Pesho", 20),
        new Student("Ana", 23));
  }
}
