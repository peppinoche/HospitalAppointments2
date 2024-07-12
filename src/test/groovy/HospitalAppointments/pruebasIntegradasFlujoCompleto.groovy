
package hospitalappointments

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification

@Integration
@Rollback
class CitaIntegrationSpec extends Specification {

    def citaService

    def setup() {
    }

    def cleanup() {
    }

    void "test create and retrieve cita"() {
        when: "a new cita is created"
        def consultorio = new Consultorio(numeroConsultorio: "101", piso: 1).save(flush: true)
        def doctor = new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology").save(flush: true)
        def cita = new Cita(consultorio: consultorio, doctor: doctor, horarioConsulta: new Date(), nombrePaciente: "Jane Doe")
        citaService.save(cita)

        then: "the cita can be retrieved successfully"
        Cita retrievedCita = Cita.get(cita.id)
        retrievedCita.nombrePaciente == "Jane Doe"
    }

    void "test update cita"() {
        given: "an existing cita"
        def consultorio = new Consultorio(numeroConsultorio: "101", piso: 1).save(flush: true)
        def doctor = new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology").save(flush: true)
        def cita = new Cita(consultorio: consultorio, doctor: doctor, horarioConsulta: new Date(), nombrePaciente: "Jane Doe").save(flush: true)

        when: "the cita is updated"
        cita.nombrePaciente = "John Doe"
        citaService.save(cita)

        then: "the changes are persisted"
        Cita updatedCita = Cita.get(cita.id)
        updatedCita.nombrePaciente == "John Doe"
    }

    void "test delete cita"() {
        given: "an existing cita"
        def consultorio = new Consultorio(numeroConsultorio: "101", piso: 1).save(flush: true)
        def doctor = new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology").save(flush: true)
        def cita = new Cita(consultorio: consultorio, doctor: doctor, horarioConsulta: new Date(), nombrePaciente: "Jane Doe").save(flush: true)

        when: "the cita is deleted"
        citaService.delete(cita.id)

        then: "the cita is no longer available"
        Cita deletedCita = Cita.get(cita.id)
        deletedCita == null
    }
}