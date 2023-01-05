package Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestWrapper {
    private static final String BASE_URL = "https://api.dropboxapi.com";
    private static final String TOKEN = "sl.BWX1VigQ6N5k3mgPSM_CBngn8c7Jt-TPbtpuXCk8D_v-m1EXa5-gKims4D5K5A-gQaIbZ-zuOlja5p8ZbBZIGEdTQ4pkPol7tOJBYcEs_M_9QRrTV-irdyDZZuHmFtji9P0OqNA";
    public static RequestSpecification request_specification = new RequestSpecBuilder()
        .setConfig(RestAssured.config()
        .encoderConfig(encoderConfig()
        .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
        .setBaseUri(BASE_URL)
        .setBasePath("/2/files")
        .setAuth(RestAssured.oauth2(TOKEN))
        .build();
}
