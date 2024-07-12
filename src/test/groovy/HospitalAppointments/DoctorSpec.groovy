package HospitalAppointments

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DoctorSpec extends Specification implements DomainUnitTest<Doctor> {

     void "test domain constraints"() {
        when:
        Doctor domain = new Doctor()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
