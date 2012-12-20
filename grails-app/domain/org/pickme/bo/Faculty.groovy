package org.pickme.bo

/**
 *  Faculty leads one or more Courses
 * 
 */
class Faculty implements Comparable, Serializable {
	String title
	String firstName
	String middleInitial	
	String lastName
	String identifier
	String emailAddress
	
	static auditable = true
	
	static transients = ['compositeId', 'fullName']
	
	static constraints = {
		id(display:false, attributes:[listable:false]) // do not show id anywhere
		emailAddress(nullable: true, blank: false, email: true)
		firstName(nullable: false, blank: false)
		identifier(nullable: false, blank: false)
		lastName(nullable: false, blank: false)
		middleInitial(nullable: true)
		title(nullable: true, blank: false)
	}
		
	static Faculty getComposite(String compositeId) {
		// change this only, if your domain class has a composite key
		return Faculty.get(compositeId)
	}
	
	public String getCompositeId() {
		// change this only, if your domain class has a composite key
		return this.id
	}
	
	public void deleteAndClearReferences() {
		
		// and finally do what we really want
		this.delete(flush:true)
	}
	
	public int compareTo(Object o) {
		// TODO: change id to fitting order property
		return (id.compareTo(o.id))
	}
	
	String getFullName() {
		if (middleInitial) {
			"${firstName} ${middleInitial} ${lastName}"
		}
		else {
			"${firstName} ${lastName}"
		}
	}
	
	String toString() {	
		// TODO: change id to human readable identity string
		// this output will be used in many places as a default
		// so it should really be a little bit more than just the id
		return "Prof ${fullName}";
	}	

/*
 Can delegate to the service or handle within the class itself
auditLogService.audit(auditEvent);*/
def transient auditLoggerService

    def audit(eventName, className, persistedObjectId, oldeState, newState) { 
      auditLoggerService.recordLogEvent(eventName, className, persistedObjectId, oldeState, newState)
    }
}