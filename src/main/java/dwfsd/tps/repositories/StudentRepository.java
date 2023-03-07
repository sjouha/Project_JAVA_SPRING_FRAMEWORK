package dwfsd.tps.repositories;

import dwfsd.tps.entities.StudentEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository implements IStudentRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public StudentEntity save(StudentEntity entity) {
        entityManager.persist(entity);
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, entity.getId());
        if(!Objects.isNull(studentEntity)) {
            return studentEntity;
        }
        return new StudentEntity();
    }

    @Override
    public StudentEntity update(StudentEntity entity) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, entity.getId());
        if(!Objects.isNull(studentEntity)) {
            studentEntity.setName(entity.getName());
            entityManager.persist(studentEntity);
            return studentEntity;
        }
        return new StudentEntity();
    }

    @Override
    public boolean delete(Long id) {
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
        if(!Objects.isNull(studentEntity)) {
            entityManager.remove(studentEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentEntity> selectAll() {
        Query query = entityManager.createQuery("SELECT * FROM STUDENTS");
        try {
             if(!query.getResultList().isEmpty()) {
                 return query.getResultList();
             }
        } catch (Exception exception) {
            System.err.println("Error :" + exception.getMessage());
        }
        return new ArrayList<>();
    }
}
