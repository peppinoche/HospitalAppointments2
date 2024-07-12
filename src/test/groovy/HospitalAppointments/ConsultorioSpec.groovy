package HospitalAppointments

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ConsultorioSpec extends Specification implements DomainUnitTest<Consultorio> {

     void "test domain constraints"() {
        when:
        Consultorio domain = new Consultorio()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
