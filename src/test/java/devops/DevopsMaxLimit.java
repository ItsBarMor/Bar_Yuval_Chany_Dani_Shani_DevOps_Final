package devops;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class DevopsMaxLimit extends Simulation {

    HttpProtocolBuilder httpProtocol = http
        .baseUrl("https://silk-spore-huskiness.ngrok-free.dev")
        .header("ngrok-skip-browser-warning", "1") // THIS BYPASSES THE NGROK BLOCK!
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");

    ScenarioBuilder scn = scenario("Max Limit Scenario")
        .exec(http("Visit Homepage").get("/daniel-yuval-bar-chany-shani/index.jsp"))
        .pause(1)
        .exec(http("Submit Form").post("/daniel-yuval-bar-chany-shani/index.jsp")
            .formParam("testValue", "Gatling Max Limit Test"));

    {
        setUp(
            // Ramps up to a huge number of users to find where the app crashes (Max Limit)
            scn.injectOpen(rampUsersPerSec(10).to(300).during(60))
        ).protocols(httpProtocol);
    }
}
