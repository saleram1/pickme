package org.pickme.i18n

import com.lonecyprus.grails.test.Expectations
import grails.test.*

class MessageTests extends GrailsUnitTestCase {
	def static messageInstances = [new Message(code: "foo.bar", text: "Message goes right here")]

    protected void setUp() {
        super.setUp()
		if (!System.properties['runningAsIntegrationTest']) {
	      mockDomain(Message, messageInstances)
	    }
		Expectations.applyTo(Message)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testMessageHasToStringMethod() {
		def message = new Message(code: "fred.msg.code", text: "Fred decode message here")
		println message
		assertNotNull(message)
	}

    void testCodeAndTextMustBeNonNullable() {
		def message = new Message(code: "barney.msg.code", text: "Barney decode message here")

		message.expectCodeIsNotNullable()
		message.expectTextIsNotNullable()
		message.expectLocaleIsNotNullable()
    }

    void testCodeAndTextMustNotBeBlank() {
		def message = new Message(code: "barney.msg.code", text: "Barney decode message here")

		message.expectCodeIsNotBlank()
		message.expectTextIsNotBlank()
		message.expectLocaleIsNotBlank()
    }

	void testLocaleShouldBeEnglishUSByDefault() {
		def message = new Message(code: "barney.msg.code", text: "Barney decode message here")
		assertEquals("en_US", message.locale)
	}
	
	void testOverrideLocaleIsOkay() {
		def message = new Message(code: "wilma.msg.code", locale: Locale.CANADA_FRENCH.toString(), text: "Barney decode message here")
		println message
		assertEquals("fr_CA", message.locale)
	}
	
}
