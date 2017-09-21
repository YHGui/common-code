package com.katsura.annotations;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("Lucy");

        Filter f3 = new Filter();
        f3.setEmail("yhgui15@126.com, yhgui2014@126.com, yhgui2015@tongji.com");

        String sql1 = query(f1);
    }

    private static String query(Filter filter) {
        StringBuilder sb = new StringBuilder();
        Class c = filter.getClass();
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append("where 1 = 1");

        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            boolean isFExist = field.isAnnotationPresent(Column.class);
            if(!isFExist) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        }
        return null;
    }

}
