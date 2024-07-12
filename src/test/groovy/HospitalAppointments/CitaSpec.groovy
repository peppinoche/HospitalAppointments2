package HospitalAppointments

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CitaSpec extends Specification implements DomainUnitTest<Cita> {

     void "test domain constraints"() {
        when:
        Cita domain = new Cita()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
