package dwfsd.tps.services;

import dwfsd.tps.dtos.StudentDTO;

import java.util.List;

public interface IStudentService {

    StudentDTO save(StudentDTO dto);

    StudentDTO update(StudentDTO dto);

    boolean delete(Long id);

    List<StudentDTO> selectAll();
}
