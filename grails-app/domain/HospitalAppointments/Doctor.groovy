package HospitalAppointments

class Doctor {

    String nombre
    String apellidoPaterno
    String apellidoMaterno
    String especialidad

    static constraints = {
        nombre blank: false
        apellidoPaterno blank: false
        apellidoMaterno blank: false
        especialidad blank: false
    }
}