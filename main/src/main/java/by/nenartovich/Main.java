package by.nenartovich;


import com.ptc.cipjava.CIPClassLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;
import java.util.Properties;

import static by.nenartovich.config.ConfigApp.PATCH_FILE_PROPERTIES;
import static by.nenartovich.config.ConfigApp.STARTUP_CLASS_SPRING;
import static by.nenartovich.config.ConfigApp.STARTUP_METHOD_SPRING;

public class Main {
    private static ClassLoader classLoader;
    private static final Properties properties = new Properties();

    public static void start() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, MalformedURLException {
        CIPClassLoader cipClassLoader = (CIPClassLoader) Main.class.getClassLoader();
        URL url = cipClassLoader.getResource(PATCH_FILE_PROPERTIES);
        try {
            assert url != null;
            try (InputStream inputStream = url.openStream()) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        URL[] files = {new File(Objects.requireNonNull(cipClassLoader.getResource(properties.getProperty("spring.path"))).getFile()).toURI().toURL()};

        classLoader = URLClassLoader.newInstance(files);
        Class<?> aClass = classLoader.loadClass(STARTUP_CLASS_SPRING);
        Method method = aClass.getMethod(STARTUP_METHOD_SPRING, String[].class);
        method.invoke(null, new Object[]{new String[0]});
    }

    public static void stop() {
        System.out.println();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        start();
    }
}