package devops;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class DevopsLoad extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("https://silk-spore-huskiness.ngrok-free.dev")
        .header("ngrok-skip-browser-warning", "1")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

    ScenarioBuilder scn = scenario("Load Test Scenario")
        .exec(http("Visit Homepage").get("/daniel-yuval-bar-chany-shani/index.jsp"))
        .pause(1)
        .exec(http("Submit Form").post("/daniel-yuval-bar-chany-shani/index.jsp")
            .formParam("testValue", "Gatling Load Test"));

    {
        setUp(
            // 5 Minutes Load Test (300 seconds) - Sustained traffic
            scn.injectOpen(constantUsersPerSec(20).during(300))
        ).protocols(httpProtocol);
    }
}
