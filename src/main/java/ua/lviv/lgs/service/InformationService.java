package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.InformationRepository;
import ua.lviv.lgs.domain.Information;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    InformationRepository informationRepository;

    public void save(Information information){
        informationRepository.save(information);
    }
    public List<Information> findAll(){
        return informationRepository.findAll();
    }
}
