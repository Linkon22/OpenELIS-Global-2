package org.openelisglobal.patient;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openelisglobal.BaseTestConfig;
import org.openelisglobal.patient.service.PatientService;
import org.openelisglobal.patient.valueholder.Patient;
import org.openelisglobal.person.service.PersonService;
import org.openelisglobal.person.valueholder.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BaseTestConfig.class, PatientTestConfig.class })
@TestPropertySource("classpath:common.properties")
@ActiveProfiles("test")
public class PatientServiceTest {

	@Autowired
	PatientService patientService;

	@Autowired
	PersonService personService;

	@Before
	public void init() throws Exception {
	}


	@Test
	public void createPatient_shouldCreateNewPatient() throws Exception {
		String firstName = "John";
		String lastname = "Doe";
		String dob = "12/12/1992";
		String gender = "M";
		Patient pat = createPatient(firstName, lastname, dob, gender);

		Assert.assertEquals(0, patientService.getAllPatients().size());
		// save patient to the DB
		String patientId = patientService.insert(pat);
		Patient savedPatient = patientService.get(patientId);

		Assert.assertEquals(1, patientService.getAllPatients().size());
		Assert.assertEquals(firstName, savedPatient.getPerson().getFirstName());
		Assert.assertEquals(lastname, savedPatient.getPerson().getLastName());
		Assert.assertEquals(gender, savedPatient.getGender());
	}

	@Test
	public void getAllPatients_shouldGetAllPatients() throws Exception {
		Assert.assertEquals(1, patientService.getAllPatients().size());
	}

	private Patient createPatient(String firstName, String LastName, String birthDate, String gender)
			throws ParseException {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(LastName);
		personService.save(person);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse(birthDate);
		long time = date.getTime();
		Timestamp dob = new Timestamp(time);

		Patient pat = new Patient();
		pat.setPerson(person);
		pat.setBirthDate(dob);
		pat.setGender(gender);

		return pat;
	}

}
