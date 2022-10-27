package ua.lviv.lgs;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.InformationRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Information;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.InformationService;
import ua.lviv.lgs.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class ApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private InformationService informationService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private InformationRepository informationRepository;

	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(3));

		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setRole(UserRole.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(3));

		User userFromDb = users.get(9);
		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}

	@Test
	public void testFindByEmail() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}

	@Test
	public void testSaveFaculty(){
		List<Faculty> faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(0));

		Faculty faculty=new Faculty();
		faculty.setName("1");
		faculty.setGpa(1);
		facultyService.save(faculty);

		faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(1));

		Faculty facultyFromDb=faculties.get(0);
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getGpa()==(faculty.getGpa()));
	}

	@Test
	public void testFindById(){
		List<Faculty> faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(0));

		Faculty faculty=new Faculty();
		faculty.setName("1");
		faculty.setGpa(1);
		facultyService.save(faculty);

		faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(1));

		Faculty facultyFromDb=facultyService.findById(faculties.get(0).getId()).get();

		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getGpa()==(faculty.getGpa()));

	}

	@Test
	public void testGetAllFaculty(){
		List<Faculty> faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(0));

		Faculty faculty=new Faculty();
		faculty.setName("1");
		faculty.setGpa(1);
		facultyService.save(faculty);

		Faculty faculty2=new Faculty();
		faculty.setName("2");
		faculty.setGpa(2);
		facultyService.save(faculty2);

		faculties=facultyRepository.findAll();
		assertThat(faculties,hasSize(2));

		List<Faculty> facultiesfromDb=facultyService.getAllMembers();

		assertTrue(facultiesfromDb.get(0).getName().equals(faculty.getName()));
		assertTrue(facultiesfromDb.get(0).getGpa()==(faculty.getGpa()));

		assertTrue(facultiesfromDb.get(1).getName().equals(faculty2.getName()));
		assertTrue(facultiesfromDb.get(1).getGpa()==(faculty2.getGpa()));
	}

	@Test
	public void testSaveToBucket(){
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		User userFromDb=userRepository.findAll().stream().findFirst().get();

		List<Faculty> faculties=facultyRepository.findAll();

		Faculty faculty=new Faculty();
		faculty.setName("1");
		faculty.setGpa(1);
		facultyService.save(faculty);

		Faculty facultyFromDb=facultyRepository.findAll().stream().findFirst().get();
		assertThat(faculties,hasSize(0));

		Information information=new Information();

		information.setUser(userFromDb);
		information.setFaculty(facultyFromDb);
		information.setMathScore(1);
		information.setEnglishScore(1);
		information.setHistoryScore(1);
		information.setScore(1);

		List<Information> informations=informationRepository.findAll();
		assertThat(informations,hasSize(0));

		informationService.save(information);

		informations=informationRepository.findAll();

		assertThat(informations,hasSize(1));

		Information informationFromDb=informations.get(0);

		assertTrue(informationFromDb.getUser().equals(userFromDb));
		assertTrue(informationFromDb.getFaculty().equals(facultyFromDb));
		assertTrue(informationFromDb.getEnglishScore()==information.getEnglishScore());
		assertTrue(informationFromDb.getHistoryScore()==information.getHistoryScore());
		assertTrue(informationFromDb.getMathScore()==information.getMathScore());


	}

	@Test
	public void testGetAllInfo(){
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		User userFromDb=userRepository.findAll().stream().findFirst().get();

		List<Faculty> faculties=facultyRepository.findAll();

		Faculty faculty=new Faculty();
		faculty.setName("1");
		faculty.setGpa(1);

		Faculty faculty2=new Faculty();
		faculty2.setName("2");
		faculty2.setGpa(2);
		facultyRepository.saveAll(Arrays.asList(faculty,faculty2) );
		List<Faculty>  facultyFromDb=facultyRepository.findAll().stream().toList();

		Information information=new Information();
		assertThat(faculties,hasSize(0));

		information.setUser(userFromDb);
		information.setFaculty(facultyFromDb.get(0));
		information.setMathScore(1);
		information.setEnglishScore(1);
		information.setHistoryScore(1);
		information.setScore(1);

		Information information1=new Information();


		information1.setUser(userFromDb);
		information1.setFaculty(facultyFromDb.get(1));
		information1.setMathScore(1);
		information1.setEnglishScore(1);
		information1.setHistoryScore(1);
		information1.setScore(1);
		List<Information> informations=informationRepository.findAll();
		assertThat(informations,hasSize(0));

		informationRepository.saveAll(Arrays.asList(information,information1));

		List<Information> infoFromDb=informationService.findAll();

		assertThat(infoFromDb, hasSize(2));
	}
}
