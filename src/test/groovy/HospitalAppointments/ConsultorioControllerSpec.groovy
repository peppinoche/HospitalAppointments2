package HospitalAppointments

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ConsultorioControllerSpec extends Specification implements ControllerUnitTest<ConsultorioController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
