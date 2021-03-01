package bg.softuni.hateoas.repository;

import bg.softuni.hateoas.model.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT o from Order o where o.student.id = :studentId")
  List<Order> findAllByStudentId(Long studentId);

}
