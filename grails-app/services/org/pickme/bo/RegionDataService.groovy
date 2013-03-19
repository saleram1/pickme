package org.pickme.bo

class RegionDataService {
	def transactional = true
	
	// call out to external service or use Domain dynamic finder 
	static final states = ['CA': ['San Francisco', 'Los Angeles'],
		'IL': ['Chicago', 'Saint Charles'],
		'MA': ['Boston', 'Newtown Square', 'Cambridge'],
		'MI': ['Detroit'],
		'MN': ['Minneapolis', 'Bloomington'],
		'NY': ['New York', 'Brooklyn', 'Albany'],
		'TX': ['Dallas', 'San Antonio']
	]

	def findAllCitiesInState(aState) {
		if (states.containsKey(aState)) {
			log.warn("found: ${aState}")
			return states[aState]
		}
		else
			null
	}
}