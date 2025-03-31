package org.proyectomicro;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.ORACLE)
public interface ThingRepository extends CrudRepository<Thing, Long> {
    Optional<Thing> findByName(String name);
}
