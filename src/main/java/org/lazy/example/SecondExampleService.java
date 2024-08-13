package org.lazy.example;

import java.util.Collections;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Named("second")
@Singleton
@Transactional
public class SecondExampleService implements ServiceInterface {

    @Override
    public List<ExampleEntity> getEntities() {
        return Collections.singletonList(new ExampleEntity());
    }

}
