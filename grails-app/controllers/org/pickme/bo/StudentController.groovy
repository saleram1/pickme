package org.pickme.bo


import grails.orm.HibernateCriteriaBuilder

class StudentController {
    def scaffold = true

	static allowedMethods = ['search': 'POST']

	def startSearch() {
	}

	def search(SearchCommand cmd) {
		
		if ( request.method ==  "POST" ) {
			def results = Student.findAllByFirstNameLike(cmd.firstName + "%")
			if (results.size() < 1) {
				flash.message = "No search results found."
				response.status = 404
				render ""
			} else {
				render(template: "searchResults", model: [studentInstanceList: results])
			}
		}
	}

	def findStudentsBy(SearchCommand aSearchCommand) {		
		def criteriaBuilder = Student.createCriteria()
		def results = criteriaBuilder.list() {
			aSearchCommand.addCriteria(criteriaBuilder)
		}
		results
	}
}


/** 
 * Used to encapsulate params from search form
 *
 */
class SearchCommand implements Serializable {
	String firstName
	String lastName
	String studentIdentifier
	String emailAddress
	Date dateOfBirth
	
	void addCriteria(HibernateCriteriaBuilder crit) {
		if (this.firstName?.trim() != "") {crit.ilike('firstName', firstName.replace('*', '%'))}
		if (this.lastName?.trim() != "")  {crit.ilike('lastName',  lastName.replace('*', '%'))}
		if (this.studentIdentifier?.trim() != "")  {crit.ilike('studentIdentifier',  studentIdentifier.replace('*', '%'))}
		if (this.emailAddress?.trim() != "") {crit.ilike('emailAddress', emailAddress.replace('*', '%'))}
	}
}