package ua.lviv.lgs.controller;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Information;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserDtoHelper;
import ua.lviv.lgs.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FacultyService facultyService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@RequestParam MultipartFile image,
                                     @RequestParam String email,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String password
                                     ) throws IOException {

        userService.save(UserDtoHelper.createUser(image,email,firstName,lastName,password));

        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView map = new ModelAndView("home");
        map.addObject("faculties", facultyService.getAllMembers());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        User user = userService.findByEmail(userEmail);
        map.addObject("user" , user);
        return map;
    }
    @RequestMapping(value = "/informationReg", method = RequestMethod.POST)
    public ModelAndView registerToFaculty(@RequestParam Integer facultyId){
        String str="redirect:/registerToFaculty?id="+facultyId;
        ModelAndView map = new ModelAndView(str);
        return map;
    }
    @RequestMapping(value ="/registerToFaculty", method = RequestMethod.GET)
    public ModelAndView addNewInformation() {


        return new ModelAndView("registerToFaculty", "info", new Information());
    }

    @RequestMapping(value ="/faculty-registration", method = RequestMethod.GET)
    public ModelAndView createPeriodical() {

        return new ModelAndView("facultyRegistration", "faculty", new Faculty());
    }
}