package org.lazy.example;

import javax.inject.Named;

import org.eclipse.jetty.util.annotation.Name;
import org.lazy.web.Response;
import org.lazy.web.annotation.Controller;
import org.lazy.web.annotation.PathMapping;

@Controller("/example")
public class ExampleController {

    private ServiceInterface serviceInterface;

    public ExampleController(@Named("main") ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @PathMapping
    public Response getEntities() {
        return Response.body(serviceInterface.getEntities()).status(200).build();
    }
}
