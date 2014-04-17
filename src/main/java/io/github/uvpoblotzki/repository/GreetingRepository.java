package io.github.uvpoblotzki.repository;

import io.github.uvpoblotzki.Greeting;

public interface GreetingRepository {

  void save(final Greeting greeting);

  void delete(final Greeting greeting);

  Greeting findByName(final String name);

}
