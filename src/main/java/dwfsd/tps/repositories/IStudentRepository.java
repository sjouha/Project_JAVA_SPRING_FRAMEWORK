package dwfsd.tps.repositories;



import dwfsd.tps.entities.StudentEntity;

import java.util.List;

public interface IStudentRepository {

    StudentEntity save(StudentEntity entity);

    StudentEntity update(StudentEntity entity);

    boolean delete(Long id);

    List<StudentEntity> selectAll();
}
