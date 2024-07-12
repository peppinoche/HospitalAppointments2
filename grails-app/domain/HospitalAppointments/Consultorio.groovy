package HospitalAppointments

class Consultorio {

    String numeroConsultorio
    int piso

    static constraints = {
        numeroConsultorio blank: false
        piso min: 1
    }
}