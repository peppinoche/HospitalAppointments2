package custom.plugin

import grails.plugins.*

class CustomPluginGrailsPlugin extends Plugin {

    def grailsVersion = "6.2.0 > *"
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Custom-plugin"
    def author = "Your name"
    def authorEmail = ""
    def description = '''\
Brief summary/description of the plugin.
'''
    def documentation = "https://grails.github.io/CustomPlugin/"

    Closure doWithSpring() { {->
        // Registrar el comando personalizado
        customCommand(CustomCommand)
    }}

    void doWithDynamicMethods() {
    }

    void doWithApplicationContext() {
    }

    void onChange(Map<String, Object> event) {
    }

    void onConfigChange(Map<String, Object> event) {
    }

    void onShutdown(Map<String, Object> event) {
    }
}
