package org.pickme.i18n

class MessageImportController {
	
	static allowedMethods = [save: "POST", update: "POST"]
	
	def index = {
		redirect(action: "create", params: params)
	}

	def show = {
		def messageImportInstance = MessageImport.getComposite(params.id)
		if (!messageImportInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'messageImport.label', default: 'MessageImport'), params.id])}"
			redirect(action: "list")
		}
		else {
			[messageImportInstance: messageImportInstance]
		}
	}
	
	def create = {
		def messageImportInstance = new MessageImport()
		messageImportInstance.properties = params
		return [messageImportInstance: messageImportInstance]
	}
	
	def saveMessages = {
		println "saveMessages:"
		
		params.each { param -> 
			println param
		}
	}
	
	def errorWithSave = {
		println "errorWithSave"
	}
	
	def save = {
		def messageImportInstance = new MessageImport(params)
		if (messageImportInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'messageImport.label', default: 'MessageImport'), messageImportInstance])}"
			
			// during association, the callback must be executed
			if (params.source != null && params.source != "") {
				def linkClass = grailsApplication.getClassForName(params.class)
				def theLink = linkClass.getComposite(params.source_id)
				def d = params.dest
				theLink."addTo${d[0].toUpperCase()+d.substring(1)}"( messageImportInstance );
				
				def rd = params.refDest
				// set just if not unidirectional
				if (rd && rd != "") {
					if (java.util.Set.isAssignableFrom(org.codehaus.groovy.grails.commons.GrailsClassUtils.getPropertyType(MessageImport.class, rd))) {
						messageImportInstance."addTo${rd[0].toUpperCase()+rd.substring(1)}"( theLink );
					}
				}
				theLink.save()
				
				// and back to edit page of associated object
				redirect(controller:params.source, action:"edit", id:params.source_id)
			} else {
				// HK go to list instead of show
				//redirect(action: "show", id: messageImportInstance.id)
				redirect(action:list)
			}
		}
		else {
			render(view: "create", model: [messageImportInstance: messageImportInstance])
		}
	}
		
}