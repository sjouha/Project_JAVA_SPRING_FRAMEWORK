package dwfsd.tps.repositories;

import dwfsd.tps.entities.StudentEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository implements IStudentRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public StudentEntity save(StudentEntity entity) {
        return null;
    }

    @Override
    public StudentEntity update(StudentEntity entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<StudentEntity> selectAll() {
        return null;
    }
}
