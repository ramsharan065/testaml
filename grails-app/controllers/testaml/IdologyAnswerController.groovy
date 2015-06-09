package testaml



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IdologyAnswerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond IdologyAnswer.list(params), model:[idologyAnswerInstanceCount: IdologyAnswer.count()]
    }

    def show(IdologyAnswer idologyAnswerInstance) {
        respond idologyAnswerInstance
    }

    def create() {
        respond new IdologyAnswer(params)
    }

    @Transactional
    def save(IdologyAnswer idologyAnswerInstance) {
        if (idologyAnswerInstance == null) {
            notFound()
            return
        }

        if (idologyAnswerInstance.hasErrors()) {
            respond idologyAnswerInstance.errors, view:'create'
            return
        }

        idologyAnswerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'idologyAnswer.label', default: 'IdologyAnswer'), idologyAnswerInstance.id])
                redirect idologyAnswerInstance
            }
            '*' { respond idologyAnswerInstance, [status: CREATED] }
        }
    }

    def edit(IdologyAnswer idologyAnswerInstance) {
        respond idologyAnswerInstance
    }

    @Transactional
    def update(IdologyAnswer idologyAnswerInstance) {
        if (idologyAnswerInstance == null) {
            notFound()
            return
        }

        if (idologyAnswerInstance.hasErrors()) {
            respond idologyAnswerInstance.errors, view:'edit'
            return
        }

        idologyAnswerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IdologyAnswer.label', default: 'IdologyAnswer'), idologyAnswerInstance.id])
                redirect idologyAnswerInstance
            }
            '*'{ respond idologyAnswerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IdologyAnswer idologyAnswerInstance) {

        if (idologyAnswerInstance == null) {
            notFound()
            return
        }

        idologyAnswerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IdologyAnswer.label', default: 'IdologyAnswer'), idologyAnswerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'idologyAnswer.label', default: 'IdologyAnswer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
