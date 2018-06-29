package app

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import static org.springframework.http.HttpStatus.OK

@Integration
@Stepwise
class DemoControllerSpec extends Specification {

    @Shared
    def rest = new RestBuilder()

    void 'test retrieving message'() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/message")

        then:
        resp.status == OK.value()
        resp.text == 'This Is A Custom Message'
    }
}
