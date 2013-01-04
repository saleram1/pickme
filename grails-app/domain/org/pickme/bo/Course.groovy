package org.pickme.bo

class Course implements Comparable, Serializable {
	String name
	String location
	Integer courseUnits = 4
	Integer capacity			// total number of students who can register in a given semester
	String semester				// this needs to be an enum
	String webSite
	Date startDate
	Date endDate
	
	static auditable = true

	static belongsTo = [faculty: Faculty]

	static constraints = {
		capacity(min: 2, max: 400)
		courseUnits(min: 0, max: 10)
		endDate(nullable: true)
		faculty(nullable: false)
		location(nullable: false, blank: false, maxSize:30) 
		name(nullable: false, blank: false, maxSize:100)
		semester(nullable: true, blank: false, inList: ['Autumn', 'Spring', 'Summer'])
		startDate(nullable: true)
		webSite(nullable:true)
	}

	static hasMany = [memberships: Membership]

	static transients = ['compositeId']

	//METHODS
	static Course getComposite(String compositeId) {
		// change this only, if your domain class has a composite key
		return Course.get(compositeId)
	}
	
	public String getCompositeId() {
		// change this only, if your domain class has a composite key
		return this.id
	}

	// TODO: change id to fitting order property
	public int compareTo(Object o) {
		return (id.compareTo(o.id))
	}

	// TODO: change id to human readable identity string
	// this output will be used in many places as a default
	// so it should really be a little bit more than just the id	
	String toString() {		
		return name;
	}
}
