package dwfsd.tps.controllers;

import dwfsd.tps.dtos.StudentDTO;
import dwfsd.tps.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService IStudentService;

    @PostMapping
    public StudentDTO save(StudentDTO dto) {
        return IStudentService.save(dto);
    }

    @PutMapping
    public StudentDTO update(StudentDTO dto) {
        return IStudentService.update(dto);
    }

    @DeleteMapping
    public boolean delete(Long id) {
        return IStudentService.delete(id);
    }

    @GetMapping
    public List<StudentDTO> selectAll() {
        return IStudentService.selectAll();
    }
}
