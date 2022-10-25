package ua.lviv.lgs.service;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;

import java.io.IOException;
import java.util.Base64;

public class UserDtoHelper {
    public static User createUser(MultipartFile file, String email, String firstname, String lastname, String password) throws IOException {
        User  user=new User();
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPassword(password);
        user.setRole(UserRole.ROLE_USER);
        user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return user;
    }

}
