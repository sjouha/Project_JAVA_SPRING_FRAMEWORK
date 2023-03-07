package dwfsd.tps.repositories;

import dwfsd.tps.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository(value="repoStudent")
public class StudentRepository implements IStudentRepository{
    private final static Logger LOGGER= LoggerFactory.getLogger(StudentRepository.class);

    @PersistenceContext
    EntityManager entityManager;

    public StudentRepository() {

    }
    @Override
    public StudentEntity save(StudentEntity entity) {
        LOGGER.debug("Student Respositoy : Start method Save");
        entityManager.persist(entity);
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, entity.getId());
        if(Objects.nonNull(studentEntity)) {
            return studentEntity;
        }
        return new StudentEntity();
    }

    @Override
    public StudentEntity update(StudentEntity entity) {
        LOGGER.debug("Student Respositoy : Start method Update");
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, entity.getId());
        if(Objects.nonNull(studentEntity)) {
            studentEntity.setName(entity.getName());
            entityManager.persist(studentEntity);
            return studentEntity;
        }
        return new StudentEntity();
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.debug("Student Respositoy : Start method Delete");
        StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
        if(Objects.nonNull(studentEntity)) {
            entityManager.remove(entityManager);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentEntity> selectAll() {
        LOGGER.debug("Student Respositoy : Start method SelectAll");
        Query query = entityManager.createQuery("SELECT name FROM STUDENTS");
        try {
             if(!query.getResultList().isEmpty()) {
                 return query.getResultList();
             }
        } catch (Exception exception) {
            LOGGER.warn("SELECT ALL STUDENT REPO : " + exception.getMessage());
        }
        return new ArrayList<>();
    }
}
