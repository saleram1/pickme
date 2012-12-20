package org.pickme.bo

/**
 * Student is enrolled in one or more Courses
 *
 */
class Student implements Comparable, Serializable {
	String firstName
	String middleInitial	
	String lastName
	String studentIdentifier
	String emailAddress
	Date dateOfBirth
	PermanentAddress permanentAddress
	
	
	static constraints = {
		id(display:false, attributes:[listable:false]) // do not show id anywhere
		firstName(blank: false, maxSize: 100)
		middleInitial(nullable: true, blank: true, maxSize: 30)
		lastName(blank: false, maxSize: 100)
		studentIdentifier(blank: false, unique: true)
		dateOfBirth()
		emailAddress(blank: false, email: true)
		permanentAddress(nullable: true)
	}
	static hasMany = [memberships: Membership]
	static mapping = {
		table 'student'
		cache true
	}
	
	static transients = ['age',"compositeId"]

	//METHODS	
	
	/**
	 * Read-only property - if dateOfBirth must be set then this always should be non-zero
	 *
	 */
	def Integer getAge() {
		if (dateOfBirth)
		  ((new Date()) - this.dateOfBirth) / 365 as Integer
		else 
		  0
	}
	
	//glossy template METHODS
	static Student getComposite(String compositeId) {
		// change this only, if your domain class has a composite key
		return Student.get(compositeId)
	}
	
	public String getCompositeId() {
		// change this only, if your domain class has a composite key
		return this.id
	}
	
	public void deleteAndClearReferences() {
		// OPTIONAL TODO: add code if needed, to break references before deletion		
		// and finally do what we really want
		this.delete(flush:true)
	}
	
	public int compareTo(Object o) {
		// TODO: change id to fitting order property
		return (id.compareTo(o.id))
	}
	
	String toString() {
		"${firstName} ${lastName}"
	}	


/*
 Can delegate to the service or handle within the class itself
auditLogService.audit(auditEvent);*/
def transient auditLoggerService

    def audit(eventName, className, persistedObjectId, oldeState, newState) { 
      auditLoggerService.recordLogEvent(eventName, className, persistedObjectId, oldeState, newState)
    }
}