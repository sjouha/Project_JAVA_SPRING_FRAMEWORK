package dwfsd.tps.services;



import dwfsd.tps.dtos.StudentDTO;
import dwfsd.tps.mappers.StudentMapper;
import dwfsd.tps.repositories.IStudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("serviceStudent")
@Transactional
public class StudentService implements IStudentService {

    private final static Logger LOGGER= LoggerFactory.getLogger(StudentService.class);


    private IStudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(@Qualifier("repoStudent") IStudentRepository studentRepository, @Qualifier("mapperStudent") StudentMapper studentMapper) {
              this.studentRepository = studentRepository;
              this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO save(StudentDTO dto) {
        LOGGER.debug("Student Service: start method save");
        return studentMapper.convertEntityToDto(studentRepository.save(studentMapper.convertDtoToEntity(dto)));
    }

    @Override
    public StudentDTO update(StudentDTO dto) {
        LOGGER.debug("Student Service: start method update");
        return studentMapper.convertEntityToDto(studentRepository.update(studentMapper.convertDtoToEntity(dto)));
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.debug("Student Service: start method delete");
        return studentRepository.delete(id);
    }

    @Override
    public List<StudentDTO> selectAll() {
        LOGGER.debug("Student Service: start method selectAll");
        return studentMapper.convertEntityToDto(studentRepository.selectAll());
    }
}
