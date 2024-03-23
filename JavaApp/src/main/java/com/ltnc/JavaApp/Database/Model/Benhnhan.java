package com.ltnc.JavaApp.Database.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "Benhnhan")

public class Benhnhan {
 @Id
  public String id;

  public String firstName;
  public String lastName;

  public Benhnhan() {}

  public Benhnhan(String id,String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format(
        "Benhnhan[id=%s, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }
}
