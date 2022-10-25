package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty save(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllMembers(){
        return facultyRepository.findAll();
    }
    public Optional<Faculty> findById(Integer id){
       return facultyRepository.findById(id);
    }
}
