package hospitalappointments

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DoctorControllerSpec extends Specification implements ControllerUnitTest<DoctorController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action returns correct model"() {
        given:
        controller.doctorService = Mock(DoctorService) {
            1 * list(_) >> [new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology")]
            1 * count() >> 1
        }

        when: "the index action is executed"
        controller.index()

        then: "the model is correct"
        model.doctorInstanceList.size() == 1
        model.doctorInstanceCount == 1
    }

    void "test save action correctly persists an instance"() {
        given:
        controller.doctorService = Mock(DoctorService) {
            1 * save(_ as Doctor) >> { Doctor doctor -> doctor.id = 1; doctor }
        }

        when: "the save action is executed with a valid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def doctor = new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology")
        controller.save(doctor)

        then: "a redirect is issued to the show action"
        response.redirectedUrl == '/doctor/show/1'
        controller.flash.message != null
    }

    void "test update action correctly updates an instance"() {
        given:
        controller.doctorService = Mock(DoctorService) {
            1 * save(_ as Doctor) >> { Doctor doctor -> doctor }
        }

        when: "the update action is executed with a valid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        def doctor = new Doctor(id: 1, nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology")
        controller.update(doctor)

        then: "a redirect is issued to the show action"
        response.redirectedUrl == '/doctor/show/1'
        controller.flash.message != null
    }
}