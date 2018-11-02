package com.workingbit.json2json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
class Json {
  private String id;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;

  private Map<String, Object> properties;

  public Json() {
    this.properties = new HashMap<>();
  }

  @JsonAnySetter
  public void add(String key, Object value) {
    properties.put(key, value);
  }

  @JsonAnyGetter
  public Map<String, Object> getProperties() {
    return properties;
  }
}

@RestController
@SpringBootApplication
public class Json2jsonApplication {

  @PostMapping("/json2json")
  public Mono<Json> json2json(@RequestBody() Json json) throws NoSuchAlgorithmException {
    json.setId("Input ID");
    String firstNameMd5 = getMd5(json.getFirstName());
    json.setFirstName(json.getFirstName() + firstNameMd5);
    String lastNameMd5 = getMd5(json.getLastName());
    json.setLastName(json.getLastName() + lastNameMd5);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
    String now = ZonedDateTime.now().format(formatter);
    json.add("current_time", now);
    json.add("say", "Java is best");
    return Mono.just(json);
  }

  private String getMd5(String str) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    return new String(md.digest(str.getBytes()));
  }

  public static void main(String[] args) {
    SpringApplication.run(Json2jsonApplication.class, args);
  }
}
