package com.workingbit.langbattle;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.lang.String.format;

@RestController
@SpringBootApplication
public class LangBattleApplication {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

  public static void main(String[] args) {
    SpringApplication.run(LangBattleApplication.class, args);
  }

  @PostMapping("/")
  public ResponseEntity<Map<String, Object>> postJson(@RequestBody() Map<String, Object> req) {
    var firstName = (String) req.get("first_name");
    var lastName = (String) req.get("last_name");
    var currentDate = FORMATTER.format(ZonedDateTime.now());
    return ResponseEntity.ok(
        Map.of(
            "id", req.get("id"),
            "first_name", format("%s %s", firstName, DigestUtils.md5Hex(firstName)),
            "last_name", format("%s %s", lastName, DigestUtils.md5Hex(lastName)),
            "current_time", currentDate,
            "say", "Java is the best"
        )
    );
  }
}
