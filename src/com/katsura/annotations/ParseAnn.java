package com.katsura.annotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ParseAnn {
    public static void main(String[] args) {

        try {
            Class c = Class.forName("com.katsura.annotations.Child");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if (isExist) {
                Description description = (Description)c.getAnnotation(Description.class);
                System.out.println(description.value());
            }

            Method[] ms = c.getMethods();
            for(Method m : ms ) {
                boolean isMExist = m.isAnnotationPresent(Description.class);
                if (isMExist) {
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.value());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
