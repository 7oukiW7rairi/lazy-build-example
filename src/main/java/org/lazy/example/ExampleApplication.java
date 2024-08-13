package org.lazy.example;

import org.lazy.app.LazyApplication;
import org.lazy.app.LazyWebLauncher;
import org.lazy.app.LocalWebServer.Type;

@LazyApplication
public class ExampleApplication {

    public static void main(String[] args) {
        LazyWebLauncher.lunchWebapp(Type.JETTY, 8080, "dev");
    }
}
