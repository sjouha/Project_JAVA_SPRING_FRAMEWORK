package dwfsd.tps.repositories;



import dwfsd.tps.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository {

    StudentEntity save(StudentEntity entity);

    StudentEntity update(StudentEntity entity);

    boolean delete(Long id);

    List<StudentEntity> selectAll();
}
