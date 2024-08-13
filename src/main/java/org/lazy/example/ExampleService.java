package org.lazy.example;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Named("main")
@Singleton
@Transactional
public class ExampleService implements ServiceInterface {

    private ExampleRepository exampleRepository;
    
    @Inject
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }



    public List<ExampleEntity> getEntities() {
        return Collections.emptyList();
    }

}
