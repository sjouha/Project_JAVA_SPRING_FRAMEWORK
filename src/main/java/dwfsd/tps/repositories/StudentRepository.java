package dwfsd.tps.repositories;

import dwfsd.tps.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="repoStudent")
public class StudentRepository implements IStudentRepository{
    private final static Logger LOGGER= LoggerFactory.getLogger(StudentRepository.class);

    public StudentRepository() {

    }
    @Override
    public StudentEntity save(StudentEntity dto) {
        LOGGER.debug("Student Respositoy : Start method Save");
        return null;
    }

    @Override
    public StudentEntity update(StudentEntity dto) {
        LOGGER.debug("Student Respositoy : Start method Update");
        return null;
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.debug("Student Respositoy : Start method Delete");
        return false;
    }

    @Override
    public List<StudentEntity> selectAll() {
        LOGGER.debug("Student Respositoy : Start method SelectAll");
        return null;
    }
}
