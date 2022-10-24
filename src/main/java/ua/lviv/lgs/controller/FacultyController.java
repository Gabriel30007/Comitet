package ua.lviv.lgs.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.service.FacultyService;
import javax.validation.Valid;

@Controller
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/FacultyRegister", method = RequestMethod.POST)
    public ModelAndView createPeriodical(@Valid @ModelAttribute("faculty") Faculty faculty,
                                         BindingResult bindingResult) {
        facultyService.save(faculty);
        return new ModelAndView("redirect:/home");
    }

}