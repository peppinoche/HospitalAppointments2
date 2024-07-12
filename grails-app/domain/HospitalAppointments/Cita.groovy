package HospitalAppointments

class Cita {

    Consultorio consultorio
    Doctor doctor
    Date horarioConsulta
    String nombrePaciente

    static constraints = {
        consultorio nullable: false
        doctor nullable: false
        horarioConsulta nullable: false,  validator: { val, obj ->
        }
        nombrePaciente blank: false
    }

    static beforeInsert = { cita ->
        validateBusinessRules(cita)
    }

    static beforeUpdate = { cita ->
        validateBusinessRules(cita)
    }

    private static void validateBusinessRules(Cita cita) {
    }
}