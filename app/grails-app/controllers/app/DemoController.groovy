package app

import micronaut.beans.MessageHelper
import org.springframework.beans.factory.annotation.Autowired

class DemoController {

    @Autowired
    MessageHelper messageHelper

    def message() {
        render messageHelper.customMessage
    }
}
