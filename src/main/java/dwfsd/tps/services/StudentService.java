package dwfsd.tps.services;



import dwfsd.tps.dtos.StudentDTO;
import dwfsd.tps.mappers.StudentMapper;
import dwfsd.tps.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository IStudentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDTO save(StudentDTO dto) {
        return studentMapper.convertEntityToDto(IStudentRepository.save(studentMapper.convertDtoToEntity(dto)));
    }

    @Override
    public StudentDTO update(StudentDTO dto) {
        return studentMapper.convertEntityToDto(IStudentRepository.update(studentMapper.convertDtoToEntity(dto)));
    }

    @Override
    public boolean delete(Long id) {
        return IStudentRepository.delete(id);
    }

    @Override
    public List<StudentDTO> selectAll() {
        return studentMapper.convertEntityToDto(IStudentRepository.selectAll());
    }
}
