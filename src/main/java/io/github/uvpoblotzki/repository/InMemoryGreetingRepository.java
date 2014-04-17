package io.github.uvpoblotzki.repository;

import io.github.uvpoblotzki.Greeting;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryGreetingRepository implements GreetingRepository {

  private final Map<String, Greeting> store = new HashMap<String, Greeting>();

  @Override
  public void save(final Greeting greeting) {
    Assert.notNull(greeting);
    Assert.notNull(greeting.getName());

    store.put(greeting.getName(), greeting);
  }

  @Override
  public void delete(final Greeting greeting) {
    Assert.notNull(greeting);
    Assert.notNull(greeting.getName());

    store.remove(greeting.getName());
  }

  @Override
  public Greeting findByName(final String name) {
    return store.get(name);
  }
}
