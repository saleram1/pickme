package org.pickme.bo

class QuestionAnswer {
	Question question
	Object   answer

    static constraints = {
		question()
		answer(nullable: true)
    }
}
