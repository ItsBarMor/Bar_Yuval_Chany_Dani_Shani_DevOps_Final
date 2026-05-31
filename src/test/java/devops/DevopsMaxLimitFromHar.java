package io.gatling.demo;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class DevopsMaxLimitFromHar extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://silk-spore-huskiness.ngrok-free.dev")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7")
    .contentTypeHeader("application/x-www-form-urlencoded")
    .originHeader("https://silk-spore-huskiness.ngrok-free.dev")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36")
    .header("ngrok-skip-browser-warning", "1");

  private Map<CharSequence, String> headers = Map.ofEntries(
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1")
  );

  private ScenarioBuilder scn = scenario("Max Limit Scenario")
    .exec(
      http("Submit Form")
        .post("/daniel-yuval-bar-chany-shani/index.jsp")
        .headers(headers)
        .formParam("testValue", "Gatling Max Limit Test")
        .check(status().in(200, 304))
    );

  {
    setUp(
      scn.injectOpen(
        rampUsersPerSec(10).to(300).during(Duration.ofMinutes(5))
      )
    ).protocols(httpProtocol);
  }
}
