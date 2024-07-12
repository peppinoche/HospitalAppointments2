package HospitalAppointments

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConsultorioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Consultorio.list(params), model:[consultorioInstanceCount: Consultorio.count()]
    }

    def show(Consultorio consultorioInstance) {
        respond consultorioInstance
    }

    def create() {
        respond new Consultorio(params)
    }

    @Transactional
    def save(Consultorio consultorioInstance) {
        if (consultorioInstance == null) {
            notFound()
            return
        }

        if (consultorioInstance.hasErrors()) {
            respond consultorioInstance.errors, view:'create'
            return
        }

        consultorioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consultorio.label', default: 'Consultorio'), consultorioInstance.id])
                redirect consultorioInstance
            }
            '*' { respond consultorioInstance, [status: CREATED] }
        }
    }

    def edit(Consultorio consultorioInstance) {
        respond consultorioInstance
    }

    @Transactional
    def update(Consultorio consultorioInstance) {
        if (consultorioInstance == null) {
            notFound()
            return
        }

        if (consultorioInstance.hasErrors()) {
            respond consultorioInstance.errors, view:'edit'
            return
        }

        consultorioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Consultorio.label', default: 'Consultorio'), consultorioInstance.id])
                redirect consultorioInstance
            }
            '*'{ respond consultorioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Consultorio consultorioInstance) {

        if (consultorioInstance == null) {
            notFound()
            return
        }

        consultorioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Consultorio.label', default: 'Consultorio'), consultorioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultorio.label', default: 'Consultorio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}