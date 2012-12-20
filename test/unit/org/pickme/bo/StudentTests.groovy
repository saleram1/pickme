package org.pickme.bo

import com.lonecyprus.grails.test.Expectations
import grails.test.*

/**
 * Student is enrolled in a course or seminar
 *
 */
class StudentTests extends GrailsUnitTestCase {
	
    protected void setUp() {
        super.setUp()
		if (!System.properties['runningAsIntegrationTest']) {
	      mockDomain(Student)
	    }
		Expectations.applyTo(Student)
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testBlankStudentNotOkay() {
		mockDomain(Student)
		def student = new Student()
		println(student)

		assert student.save()
	}

    void testNewStudentMustHaveFirstLastAndDOB() {
		def student = new Student(firstName: "Joseph", lastName: "Bloggs")
		student.expectFirstNameIsNotNullable()
		student.expectMiddleInitialIsNullable()
		student.expectLastNameIsNotNullable()
		student.expectDateOfBirthIsNotNullable()
    }

	void testStudentIdsMustBeUnique() {
		def fullStudent2 = new Student(firstName: "Wilma", lastName: "Bloggs", dateOfBirth: Date.parse("yyyy-MM-dd", "2000-09-01"), 
			  studentIdentifier: "123456789", emailAddress: "joe#foo.bar")
		fullStudent2.save()
		fullStudent2.expectStudentIdentifierIsUnique()
	}

	void testEmailIsRequiredToo() {
		def student = new Student(emailAddress: "")
		student.expectEmailAddressIsNotBlank()	
	}

	void testEmailIsValid() {
		def student = new Student()
		student.expectEmailAddressIsAnEmailAddress()	
	}
	
	void testEmailValidatorShouldDetectInvalidEmail()  {
		def fullStudent = new Student(firstName: "Joseph", lastName: "Bloggs", dateOfBirth: Date.parse("yyyy-MM-dd", "2000-09-01"), 
			  studentIdentifier: "123456789", emailAddress: "joe#foo.bar")
		fullStudent.validate()
		fullStudent.errors.each { err -> println err }
		
		assertEquals("Only emailAddress should be in error", 1, fullStudent.errors.allErrors.size())
	}

	void testStudentAgeIsAReadonlyProperty() {
		def student = new Student() 
		shouldFail {
			s.age = 55
		}
	}
}