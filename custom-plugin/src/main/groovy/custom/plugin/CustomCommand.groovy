package custom.plugin

import grails.dev.commands.*

class CustomCommand implements GrailsApplicationCommand {

    String description = "Este es un comando personalizado"

    boolean handle() {
        println "Ejecutando el comando personalizado"
        // Aquí puedes añadir la lógica que desees ejecutar con tu comando
        return true
    }
}

