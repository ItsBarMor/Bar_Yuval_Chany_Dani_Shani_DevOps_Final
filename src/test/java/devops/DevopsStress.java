package devops;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class DevopsStress extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("https://silk-spore-huskiness.ngrok-free.dev")
        .header("ngrok-skip-browser-warning", "1")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

    ScenarioBuilder scn = scenario("Stress Test Scenario")
        .exec(http("Visit Homepage").get("/daniel-yuval-bar-chany-shani/index.jsp"))
        .pause(1)
        .exec(http("Submit Form").post("/daniel-yuval-bar-chany-shani/index.jsp")
            .formParam("testValue", "Gatling Stress Test"));

    {
        setUp(
            // 5 Minutes Stress Test (300 seconds) - Heavy traffic with massive spikes
            scn.injectOpen(
                constantUsersPerSec(10).during(60),
                rampUsersPerSec(10).to(100).during(60),
                constantUsersPerSec(100).during(60),
                rampUsersPerSec(100).to(300).during(60),
                constantUsersPerSec(300).during(60)
            )
        ).protocols(httpProtocol);
    }
}
