package dwfsd.tps.controllers;

import dwfsd.tps.dtos.StudentDTO;
import dwfsd.tps.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
public class StudentController {

    @Autowired
    private IStudentService IStudentService;


    public StudentDTO save(StudentDTO dto) {
        return IStudentService.save(dto);
    }


    public StudentDTO update(StudentDTO dto) {
        return IStudentService.update(dto);
    }


    public boolean delete(Long id) {
        return IStudentService.delete(id);
    }


    public List<StudentDTO> selectAll() {
        return IStudentService.selectAll();
    }
}
