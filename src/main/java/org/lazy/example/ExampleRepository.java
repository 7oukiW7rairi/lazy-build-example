package org.lazy.example;

import org.lazy.jpa.JpaRepository;
import org.lazy.jpa.Query;
import org.lazy.jpa.Repository;

import java.util.*;

@Repository
public interface ExampleRepository extends JpaRepository<Integer, ExampleEntity> {

    @Query("select e from ExampleEntity e where e.number > ?1 order by ?2")
    List<ExampleEntity> getEntities(Integer number, long l);

    @Query("update ExampleEntity e set e.username = ?1 where e.admin = ?2")
    void updateEntity(float v, boolean b);

    @Query("select e from ExampleEntity e where e.number > ?1")
    List<ExampleEntity> getEntitiesExcludeSomeEntities(List<ExampleEntity> entities);

    @Query("select e from ExampleEntity e where e.number > ?1 order by ?2")
    ExampleEntity getEntityBySomething(byte[] bytes, double v);

    @Query("select e from ExampleEntity e where e.number > ?1 order by ?2")
    List<ExampleEntity> getEntitiesWithoutOtherEntities(short i, char c);
}
