package io.gatling.demo;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://silk-spore-huskiness.ngrok-free.dev")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7")
    .contentTypeHeader("application/x-www-form-urlencoded")
    .originHeader("https://silk-spore-huskiness.ngrok-free.dev")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("priority", "u=0, i"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"148\", \"Google Chrome\";v=\"148\", \"Not/A)Brand\";v=\"99"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS"),
    Map.entry("sec-fetch-dest", "document"),
    Map.entry("sec-fetch-mode", "navigate"),
    Map.entry("sec-fetch-site", "same-origin"),
    Map.entry("sec-fetch-user", "?1")
  );


  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .post("/daniel-yuval-bar-chany-shani/index.jsp")
        .headers(headers_0)
        .formParam("testValue", "test3")
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
