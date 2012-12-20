package org.pickme.i18n

class MessageService {

    static transactional = true

    def addMessage(String code, String locale, String text) {
		if (messageExists()) {
			updateMessage()
		}
		else {
			newMessage(code, locale, text).save(failOnError: true)
		}
    }

	def Message newMessage(aCode, aLocale, aText) {
		new Message(code: aCode, locale: aLocale, text: aText)
	}

	def Boolean messageExists(String code, String locale) {
		if (Message.findByCodeAndLocale(code, locale).size() > 0) {
			true
		}
		else {
			false
		}
	}
}