package com.test



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DataController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Data.list(params), model:[dataInstanceCount: Data.count()]
    }

    def show(Data dataInstance) {
        respond dataInstance
    }

    def create() {
        respond new Data(params)
    }

    @Transactional
    def save(Data dataInstance) {
        if (dataInstance == null) {
            notFound()
            return
        }

        if (dataInstance.hasErrors()) {
            respond dataInstance.errors, view:'create'
            return
        }

        dataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'data.label', default: 'Data'), dataInstance.id])
                redirect dataInstance
            }
            '*' { respond dataInstance, [status: CREATED] }
        }
    }

    def edit(Data dataInstance) {
        respond dataInstance
    }

    @Transactional
    def update(Data dataInstance) {
        if (dataInstance == null) {
            notFound()
            return
        }

        if (dataInstance.hasErrors()) {
            respond dataInstance.errors, view:'edit'
            return
        }

        dataInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Data.label', default: 'Data'), dataInstance.id])
                redirect dataInstance
            }
            '*'{ respond dataInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Data dataInstance) {

        if (dataInstance == null) {
            notFound()
            return
        }

        dataInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Data.label', default: 'Data'), dataInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'data.label', default: 'Data'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
