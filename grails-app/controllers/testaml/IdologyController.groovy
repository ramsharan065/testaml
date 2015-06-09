package testaml



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IdologyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Idology.list(params), model:[idologyInstanceCount: Idology.count()]
    }

    def show(Idology idologyInstance) {
        respond idologyInstance
    }

    def create() {
        respond new Idology(params)
    }

    @Transactional
    def save(Idology idologyInstance) {
        if (idologyInstance == null) {
            notFound()
            return
        }

        if (idologyInstance.hasErrors()) {
            respond idologyInstance.errors, view:'create'
            return
        }

        idologyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idology.label', default: 'Idology'), idologyInstance.id])
                redirect idologyInstance
            }
            '*' { respond idologyInstance, [status: CREATED] }
        }
    }

    def edit(Idology idologyInstance) {
        respond idologyInstance
    }

    @Transactional
    def update(Idology idologyInstance) {
        if (idologyInstance == null) {
            notFound()
            return
        }

        if (idologyInstance.hasErrors()) {
            respond idologyInstance.errors, view:'edit'
            return
        }

        idologyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Idology.label', default: 'Idology'), idologyInstance.id])
                redirect idologyInstance
            }
            '*'{ respond idologyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Idology idologyInstance) {

        if (idologyInstance == null) {
            notFound()
            return
        }

        idologyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Idology.label', default: 'Idology'), idologyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idology.label', default: 'Idology'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
