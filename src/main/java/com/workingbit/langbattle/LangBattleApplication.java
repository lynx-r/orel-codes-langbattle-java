package com.workingbit.langbattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Map;

import static java.lang.String.format;

@RestController
@SpringBootApplication
public class LangBattleApplication {

  private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

  public static void main(String[] args) {
    SpringApplication.run(LangBattleApplication.class, args);
  }

  @PostMapping("/")
  public ResponseEntity<Map<String, Object>> get(@RequestBody() Map<String, Object> req) throws NoSuchAlgorithmException {
    var firstName = (String) req.get("first_name");
    var firstNameWithMd5 = format("%s %s", firstName, getMd5(firstName));
    var lastName = (String) req.get("last_name");
    var lastNameWithMd5 = format("%s %s", lastName, getMd5(lastName));
    var currentDate = FORMATTER.format(ZonedDateTime.now());
    req.put("first_name", firstNameWithMd5);
    req.put("last_name", lastNameWithMd5);
    req.put("current_time", currentDate);
    req.put("say", "Java is the best");
    return ResponseEntity.ok(req);
  }

  private String getMd5(String str) throws NoSuchAlgorithmException {
    var md = MessageDigest.getInstance("MD5");
    return Base64.getEncoder().encodeToString(md.digest(str.getBytes()));
  }
}
