package org.pickme.i18n

import com.lonecyprus.grails.test.Expectations
import grails.test.*

/**
 *  Record number of message objects imported and give a descriptive name
 */
class MessageImportTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		if (!System.properties['runningAsIntegrationTest']) {
	      mockDomain(MessageImport)
	    }
		Expectations.applyTo(MessageImport)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testNameMustBeNonNullableAndNonBlank() {
		def messageImport = new MessageImport(name: "foo")
		messageImport.expectNameIsNotNullable()
		messageImport.expectNameIsNotBlank()
    }

	void testNumberOfInsertsShouldBeZero() {
		def messageImport = new MessageImport(name: "bar")
		messageImport.expectNumInsertsIsNotNullable()
		assertEquals(0, messageImport.numInserts)
	}

	void testNumberOfUpdatesShouldBeZero() {
		def messageImport = new MessageImport(name: "baz")
		messageImport.expectNumUpdatesIsNotNullable()
		assertEquals(0, messageImport.numUpdates)
	}	
}