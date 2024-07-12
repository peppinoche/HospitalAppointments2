package hospitalappointments

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DoctorSpec extends Specification implements DomainUnitTest<Doctor> {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid Doctor"() {
        when: "a valid Doctor instance is created"
        def doctor = new Doctor(nombre: "John", apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology")

        then: "the instance should validate successfully"
        doctor.validate()
    }

    void "test invalid Doctor without nombre"() {
        when: "a Doctor instance is created without a nombre"
        def doctor = new Doctor(apellidoPaterno: "Doe", apellidoMaterno: "Smith", especialidad: "Cardiology")

        then: "the instance should fail validation"
        !doctor.validate()
    }
}
