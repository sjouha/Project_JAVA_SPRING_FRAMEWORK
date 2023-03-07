package dwfsd.tps.controllers;

import dwfsd.tps.dtos.StudentDTO;
import dwfsd.tps.services.IStudentService;
import dwfsd.tps.services.StudentService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final static Logger LOGGER= LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(@Qualifier("serviceStudent") StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO dto) {
        LOGGER.debug("Student Controller: start method save");
        return studentService.save(dto);
    }

    @PutMapping
    public StudentDTO update(@RequestBody StudentDTO dto) {
        LOGGER.debug("Student Controller: start method update");
        return studentService.update(dto);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        LOGGER.debug("Student Controller: start method delete");
        return studentService.delete(id);
    }

    @GetMapping
    public List<StudentDTO> selectAll() {
        LOGGER.debug("Student Controller: start method selectAll");
        return studentService.selectAll();
    }
}
