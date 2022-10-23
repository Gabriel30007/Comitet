package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.domain.Information;

public interface InformationRepository extends JpaRepository<Information,Integer> {
}
