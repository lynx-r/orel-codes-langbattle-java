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
    var firstNameWithMd5 = format("%s %s", firstName, DigestUtils.md5Hex(firstName));
    var lastName = (String) req.get("last_name");
    var lastNameWithMd5 = format("%s %s", lastName, DigestUtils.md5Hex(lastName));
    var currentDate = FORMATTER.format(ZonedDateTime.now());
    req.put("first_name", firstNameWithMd5);
    req.put("last_name", lastNameWithMd5);
    req.put("current_time", currentDate);
    req.put("say", "Java is the best");
    return ResponseEntity.ok(req);
  }
}
