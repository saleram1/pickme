package org.pickme.bo

class Evaluation implements Comparable, Serializable {
	Course course
	String semester
	String rating
	String comments  
	Date dateCreated

	static auditable = true
		
	static constraints = {
		id(display:false, attributes:[listable:false]) // do not show id anywhere
		rating(inList: ['Excellent', 'Good', 'Fair', 'Room for Improvement'])
		semester(inList: ['Autumn', 'Spring', 'Summer'])
		comments(nullable: true, blank: true, widget: 'textarea')
	}

	static hasMany = [questions: QuestionAnswer]

	static transients = ['compositeId']


	//METHODS	
	static Evaluation getComposite(String compositeId) {
		// change this only, if your domain class has a composite key
		return Evaluation.get(compositeId)
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
	
	String toString() {
		// TODO: change id to human readable identity string
		// this output will be used in many places as a default
		// so it should really be a little bit more than just the id
		return id;
	}	


/*
 Can delegate to the service or handle within the class itself
auditLogService.audit(auditEvent);*/
def transient auditLoggerService

    def audit(auditEvent) { 
      auditLoggerService.recordLogEvent(auditEvent)
    }
}