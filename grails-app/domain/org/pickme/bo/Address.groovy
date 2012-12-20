package org.pickme.bo

abstract class Address {
	String address1
	String address2
	String city
	String region
	String postalCode
	String countryCode

    static constraints = {
		address1(nullable: false)
		address2(nullable: true)
		region(nullable: true, inList: ['CA', 'IL', 'MA', 'MI', 'MN', 'NY', 'TX'])
		city(nullable: false)
		postalCode(nullable: true)
		countryCode(nullable: false, blank: false)
    }
}
