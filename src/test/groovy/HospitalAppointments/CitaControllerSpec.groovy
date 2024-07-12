package HospitalAppointments

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CitaControllerSpec extends Specification implements ControllerUnitTest<CitaController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
