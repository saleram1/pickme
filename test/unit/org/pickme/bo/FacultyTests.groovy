package org.pickme.bo

import com.lonecyprus.grails.test.Expectations
import grails.test.*

class FacultyTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		if (!System.properties['runningAsIntegrationTest']) {
	      mockDomain(Faculty)
	    }
		Expectations.applyTo(Faculty)
    }

    protected void tearDown() {
        super.tearDown()
    }

	void testBlankFacultyNotOkay() {
		def faculty = new Faculty( )
		faculty.expectFirstNameIsNotBlank()
		faculty.expectLastNameIsNotBlank()
		faculty.expectTitleIsNotBlank()
		faculty.expectIdentifierIsNotBlank()
	}

	void testEmailIsRequiredToo() {
		def faculty = new Faculty(emailAddress: "")
		faculty.expectEmailAddressIsNotBlank()	
	}
}