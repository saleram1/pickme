
import grails.util.Environment
import org.pickme.bo.Course
import org.pickme.bo.Faculty
import org.pickme.bo.Membership
import org.pickme.bo.Student

class BootStrap {

    def init = { servletContext ->

		// Students
		def studentData = new File("test/data/San_Francisco_Grails_Cafe_Centro_Member_List_on_09-17-11.csv").readLines()
		def fullName =    null
		def studentCounter = 0

		studentData.each { 
		  fullName = it.split(",")[0]
		if (fullName.contains(" ")) {
		  def student = new Student(dateOfBirth: Date.parse("yyyy-MM-dd", "1982-10-01"),
				   		                  firstName: "${fullName.split(' ')[0]}", lastName: "${fullName.split(' ')[1]}", studentIdentifier: "123-45-${studentCounter}",
				                          emailAddress: "mikesalera@mac.com")
		  student.save(flush: true)
		}
		  studentCounter++
		}
		// Profs
				def fac = new Faculty(title:"Adjunct", firstName: "Michael", lastName: "Salera", identifier: "123-45-7890", emailAddress: "mikesalera@mac.com")
				if (fac.validate()) {
					fac.save(flush: true)
				} else { fac.errors.fieldErrors.each()  {
					println it
				}}

		//Courseware
				new Course(name: "Stanford Saturday University: Eight Big Questions", location:"Stanford", faculty: fac).save( )
				new Course(name: "How to Think Like a Psychologist", location:"Stanford", faculty: fac).save( )
				new Course(name: "The Heart: A Stanford Mini Med School Sequel", location:"Stanford", faculty: fac).save( )
				new Course(name: "The Contemporary American Short Story (with Michael Krasny)", location:"Stanford", faculty: fac).save( )
				new Course(name: "The History and Geography of Current Global Events", location:"Stanford", faculty: fac).save( )
				new Course(name: "The Past, Present, and Future of Design", location:"Stanford", faculty: fac).save( )
				new Course(name: "Demystifying Modern China", location:"Stanford", faculty: fac).save( )
				new Course(name: "Five Albums That Changed the Face of Jazz", location:"Stanford", faculty: fac).save( )
				new Course(name: "Surrealism in France", location:"Stanford", faculty: fac).save( )
				new Course(name: "Understanding the Science of Climate Change", location:"Stanford", faculty: fac).save( )
				new Course(name: "Creative Writing", location:"Stanford (On Campus)", faculty: fac).save( )
				new Course(name: "Introduction to Fiction", location:"Stanford", faculty: fac).save( )
				new Course(name: "Writing About Your Life", location:"Stanford", faculty: fac).save( )
				new Course(name: "Writing the Short Story", location:"Stanford", faculty: fac).save( )
				new Course(name: "Novel Writing", location:"Stanford", faculty: fac).save( )
				new Course(name: "Food Writing for Mainstream Media and Blogs", location:"Stanford", faculty: fac).save( )
				new Course(name: "Creative Writing (Online) Faculty:", location:"Stanford", faculty: fac).save( )
				new Course(name: "Conquering the Blank Page: Approaches to Creative Writing *", location:"Stanford", faculty: fac).save( )
				new Course(name: "Writing Your Debut Novel *", location:"Stanford", faculty: fac).save( )
				new Course(name: "Magazine Writing: Being Pitch Perfect *", location:"Stanford", faculty: fac).save( )
				new Course(name: "Writing 2.0: On Blogs and Blogging *", location:"Stanford", faculty: fac).save( )
				new Course(name: "Screenwriting: The Tools Instead of Rules *", location:"Stanford", faculty: fac).save( )
				new Course(name: "Personal and Professional Development Faculty:", location:"Stanford", faculty: fac).save( )
				new Course(name: "How to Start Your Business: From Idea to Business Plan", location:"Stanford", faculty: fac).save( )
				new Course(name: "The Pharmaceutical Industry: Understanding the Unique Innovation and Business Challenges", location:"Stanford", faculty: fac).save( )
				new Course(name: "Marketing and Social Media Strategy", location:"Stanford", faculty: fac).save( )
				new Course(name: "Figuring Finance", location:"Stanford", faculty: fac).save( )
				new Course(name: "Ambition by Design", location:"Stanford", faculty: fac).save( )
				new Course(name: "Negotiation Mastery", location:"Stanford", faculty: fac).save( )
				new Course(name: "Project Management: An Introductory Hands-on Course", location:"Stanford", faculty: fac).save( )
				new Course(name: "Choosing Happiness", location:"Stanford", faculty: fac).save( )
				new Course(name: "Creativity and Leadership", location:"Stanford", faculty: fac).save( )

				def aStudente = Student.get(1)
				Course.list().each { aCourse -> 
					//aCourse.addToMemberships(new Membership(student: aStudente, course: aCourse))
					if (Membership.link(aStudente, aCourse)) {
						println "registering:\t  ${aStudente} in ${aCourse}"
					}
				}

		    if (Environment.getCurrent() != Environment.TEST) {
		      println " running in ${Environment.current} mode\n\t Course count: ${Course.count()}"
		      println " Student count: ${Student.count()}"
		    }
    }

    def destroy = {
    }
}
