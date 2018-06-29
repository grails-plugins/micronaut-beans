package micronaut.beans

import grails.plugins.Plugin
import io.micronaut.spring.beans.MicronautBeanProcessor

class MicronautBeansGrailsPlugin extends Plugin {

    def grailsVersion = '3.3.0 > *'

    def title = 'Micronaut Beans'
    def author = 'Jeff Scott Brown'
    def authorEmail = 'brownj@objectcomputing.com'
    def description = '''\
The Micronaut Beans plugin adds support for adding Micronaut beans to
the Spring ApplicationContext in a Grails application or plugin.
'''

    def documentation = 'https://grails-plugins.github.io/micronaut-beans/'

    def license = 'APACHE'

    def organization = [name: 'OCI', url: 'http://www.objectcomputing.com/']

    def issueManagement = [system: 'GitHub', url: 'https://github.com/grails-plugins/micronaut-beans/issues']

    def scm = [url: 'https://github.com/grails-plugins/micronaut-beans']

    Closure doWithSpring() {
        { ->
            List<Class> beanTypesToLoad = config.getProperty('micronaut.bean.types', List, [])
            if (beanTypesToLoad) {
                grailsMicronautBeanProcessor MicronautBeanProcessor, beanTypesToLoad
            } else {
                log.warn 'No bean types were specified in micronaut.bean.types'
            }
        }
    }
}
