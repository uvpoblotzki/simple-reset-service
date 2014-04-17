package io.github.uvpoblotzki.service;

import io.github.uvpoblotzki.Greeting;
import io.github.uvpoblotzki.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/service/**")
public class RepositoryEndpoint {

  private GreetingRepository repository;

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public String greet(@GreetingParam final String name) {
    final Greeting greeting = getRepository().findByName(name);
    final StringBuilder sb = new StringBuilder();
    if (greeting != null) {
      sb.append(greeting.getValue()).append(' ');
    } else {
      sb.append("Hello ");
    }
    sb.append(name);
    return sb.toString();
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.PUT)
  public String save(@GreetingParam final String name, @RequestBody final MultiValueMap<String, String> body) {
    getRepository().save(new Greeting(name, body.getFirst("greeting")));
    return "OK";
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.DELETE)
  public String delete(@GreetingParam final String name) {
    final Greeting greeting = getRepository().findByName(name);
    if (greeting != null) {
      getRepository().delete(greeting);
    }
    return "OK";
  }

  public GreetingRepository getRepository() {
    return repository;
  }

  @Autowired
  public void setRepository(final GreetingRepository repository) {
    this.repository = repository;
  }
}
