package micronaut.beans;

import javax.inject.Singleton;

@Singleton
public class MessageHelper {

    public String getCustomMessage() {
        return "This Is A Custom Message";
    }
}
