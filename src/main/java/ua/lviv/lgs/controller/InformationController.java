package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Information;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.InformationService;
import ua.lviv.lgs.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InformationController {

    @Autowired
    UserService userService;
    @Autowired
    FacultyService facultyService;

    @Autowired
    InformationService informationService;


    @RequestMapping(value = "/informations", method = RequestMethod.GET)
    public ModelAndView getAllItems() {
        return getInformation();
    }
    @RequestMapping(value = "information", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Integer facultyId) {
        Faculty faculty = facultyService.findById(facultyId).get();


        return getInformation();
    }

    private ModelAndView getInformation() {
        ModelAndView map = new ModelAndView("rating");
        map.addObject("infoItems", informationService.findAll());
        return map;
    }

    @RequestMapping(value = "InformationRegister", method = RequestMethod.POST)
    public ModelAndView addInfo(@RequestParam int mathScore, @RequestParam int historyScore, @RequestParam int englishScore, HttpServletRequest request){
        String str = request.getHeader("referer");
        char [] chars = str.toCharArray();
        String result="";
        int index=1;
        for (int i=0; i<chars.length;i++){
            if(chars[i]=='='){
                index=i;
            }

        }
        result=str.substring(index+1,str.length());
        Faculty faculty= facultyService.findById(Integer.parseInt(result)).get();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        User user = userService.findByEmail(userEmail);

        Information information=new Information();
        information.setMathScore(mathScore);
        information.setHistoryScore(historyScore);
        information.setEnglishScore(englishScore);
        information.setUser(user);
        information.setFaculty(faculty);
        int score=(mathScore+historyScore+englishScore)/3;
        information.setScore(score);
        informationService.save(information);
        ModelAndView map=new ModelAndView("redirect:/home");
        return map;
    }
}
