package org.pickme.bo

class PermanentAddressController {
	def regionDataService
    def scaffold = true			// use defaults - add one action for remoteFunction

	def regionSelected = {
		def cities = []
		if (params.region) {
			cities = regionDataService.findAllCitiesInState(params.region)
		}
		render(g.select(name: "city", from: cities))
	}
}
