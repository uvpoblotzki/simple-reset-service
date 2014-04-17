package io.github.uvpoblotzki;

public class Greeting {

  private String value;
  private String name;

  public Greeting() {
  }

  public Greeting(final String name, final String value) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
