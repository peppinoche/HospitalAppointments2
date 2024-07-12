package HospitalAppointments


import grails.transaction.Transactional

@Transactional(readOnly = true)
class CitaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cita.list(params), model: [citaInstanceCount: Cita.count()]
    }

    def show(Long id) {
        respond Cita.get(id)
    }

    def create() {
        respond new Cita(params)
    }

    @Transactional
    def save(Cita citaInstance) {
        if (citaInstance == null) {
            notFound()
            return
        }

        if (citaInstance.hasErrors()) {
            respond citaInstance.errors, view: 'create'
            return
        }

        citaInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cita.label', default: 'Cita'), citaInstance.id])
                redirect citaInstance
            }
            '*' { respond citaInstance, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond Cita.get(id)
    }

    @Transactional
    def update(Cita citaInstance) {
        if (citaInstance == null) {
            notFound()
            return
        }

        if (citaInstance.hasErrors()) {
            respond citaInstance.errors, view: 'edit'
            return
        }

        citaInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Cita.label', default: 'Cita'), citaInstance.id])
                redirect citaInstance
            }
            '*' { respond citaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Long id) {
        Cita citaInstance = Cita.get(id)
        if (citaInstance == null) {
            notFound()
            return
        }

        citaInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Cita.label', default: 'Cita'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cita.label', default: 'Cita'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}