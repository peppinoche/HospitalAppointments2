package HospitalAppointments

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DoctorControllerSpec extends Specification implements ControllerUnitTest<DoctorController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
