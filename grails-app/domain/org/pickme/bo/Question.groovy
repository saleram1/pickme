package org.pickme.bo

class Question {
	String code
	String text
	Boolean isRating = false
	Integer minimum = 0
	Integer maximum = 1
	
    static constraints = {
		code()
		text()
    }
}
