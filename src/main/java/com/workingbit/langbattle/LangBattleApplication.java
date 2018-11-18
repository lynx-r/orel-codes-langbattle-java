package com.workingbit.langbattle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
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

@Data
class JsonRequest {
  private String id;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
}

@Data
@AllArgsConstructor
class JsonResponse {
  private String id;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  private String say;
  @JsonProperty("current_time")
  private String currentTime;
}

@RestController
@SpringBootApplication
public class LangBattleApplication {

  public static void main(String[] args) {
    SpringApplication.run(LangBattleApplication.class, args);
  }

  @PostMapping("/")
  public ResponseEntity<JsonResponse> get(@RequestBody() JsonRequest req) throws NoSuchAlgorithmException {
    String firstNameWithMd5 = req.getFirstName() + " " + getMd5(req.getFirstName());
    String lastNameWithMd5 = req.getLastName() + " " + getMd5(req.getLastName());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
    String now = ZonedDateTime.now().format(formatter);
    JsonResponse resp = new JsonResponse(req.getId(), firstNameWithMd5, lastNameWithMd5, "Java is the best", now);
    return ResponseEntity.ok(resp);
  }

  private String getMd5(String str) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    return Base64.getEncoder().encodeToString(md.digest(str.getBytes()));
  }
}
