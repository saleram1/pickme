package org.pickme.bo

class FacultyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 25, 100)
        [facultyInstanceList: Faculty.list(params), facultyInstanceTotal: Faculty.count()]
    }

    def create = {
        def facultyInstance = new Faculty()
        facultyInstance.properties = params
        return [facultyInstance: facultyInstance]
    }

    def save = {
        def facultyInstance = new Faculty(params)
        if (facultyInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'faculty.label', default: 'Faculty'), facultyInstance.id])}"
            redirect(action: "show", id: facultyInstance.id)
        }
        else {
            render(view: "create", model: [facultyInstance: facultyInstance])
        }
    }

    def show = {
        def facultyInstance = Faculty.get(params.id)
        if (!facultyInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
            redirect(action: "list")
        }
        else {
            [facultyInstance: facultyInstance]
        }
    }

    def edit = {
        def facultyInstance = Faculty.get(params.id)
        if (!facultyInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [facultyInstance: facultyInstance]
        }
    }

    def update = {
        def facultyInstance = Faculty.get(params.id)
        if (facultyInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (facultyInstance.version > version) {
                    
                    facultyInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'faculty.label', default: 'Faculty')] as Object[], "Another user has updated this Faculty while you were editing")
                    render(view: "edit", model: [facultyInstance: facultyInstance])
                    return
                }
            }
            facultyInstance.properties = params
            if (!facultyInstance.hasErrors() && facultyInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'faculty.label', default: 'Faculty'), facultyInstance.id])}"
                redirect(action: "show", id: facultyInstance.id)
            }
            else {
                render(view: "edit", model: [facultyInstance: facultyInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
            redirect(action: "list")
        }
    }

	//generated delete
    def delete = {
        def facultyInstance = Faculty.get(params.id)

/*		Faculty.withNewSession {
		  if ( isTeachingCourses(facultyInstance) ) {
		    unlinkFromCourse(facultyInstance)
		  }
		}
*/
        if (facultyInstance) {
            try {
                facultyInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'faculty.label', default: 'Faculty'), params.id])}"
            redirect(action: "list")
        }
}

  def isTeachingCourses(facultyInstance) {
    println "Fac ${facultyInstance} teaching ${Course.findAllByFaculty(facultyInstance).size()} courses"
    Course.findAllByFaculty(facultyInstance).size() > 0
  }

  def unlinkFromCourse(facultyInstance) {
    Course.findAllByFaculty(facultyInstance).each { Course course ->
      course.faculty = null
      course.save(failOnError: true)
    }
  }
}