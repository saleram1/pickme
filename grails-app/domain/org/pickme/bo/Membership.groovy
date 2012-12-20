package org.pickme.bo

/**
 * Association class for the many-to-many relationship
 *
 */
class Membership implements Serializable {
	Student student
	Course course
	Semester semester
	
	static constraints = {
		student()
		course()
		semester(nullable: true)
	}
	
	def static Membership link(aStudent, aCourse) {
		def m = Membership.findByStudentAndCourse(aStudent, aCourse)
		if (!m) {
			m = new Membership()
			aStudent?.addToMemberships(m)
			aCourse?.addToMemberships(m)
			m.validate()
			m.save(flush: true)
		}
		return m
	}

	String toString() {
        return "${student} enrolled in ${course}"
	}
}

public enum Semester {
	WINTER, 
	SPRING,
	SUMMER,
	AUTUMN
}