package com.fc.ch3.diCopy3;

import com.google.common.reflect.ClassPath;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component class Car{ }
@Component class SportsCar extends Car { }
@Component class Truck extends Car { }
@Component class Engine { }

class AppContext{
    Map map; // 객체 저장소

    AppContext() {
        map = new HashMap();
        doComponntScan();
    }

    private void doComponntScan() {
        // 1. 패키지 내 클래스 목록 가져온다.
        // 2. 반복문으로 클래스를 하나씩 읽어와서 @Component가 붙어있는지 확인
        // 3. @Component가 붙어있으면 객체를 생성하여 map에 저장
        try {
            ClassLoader classLoader =  AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fc.ch3.diCopy3");
            for (ClassPath.ClassInfo classInfo:set) {
                Class clazz = classInfo.load();
                Component component = (Component) clazz.getAnnotation(Component.class);
                if(component!=null){
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // [by Name]으로 검색
    Object getBean(String key){
        return map.get(key);
    }

    // [by Type]으로 검색
    Object getBean(Class clazz){
        for (Object obj: map.values() ) {
            if(clazz.isInstance(obj))
                return obj;
        }
        return null;
    }
}

public class Main4 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car"); // by Name으로 객체 검색
        Car car2 = (Car)ac.getBean(Car.class); // by Type으로 객체 검색
        Engine engine = (Engine)ac.getBean("engine");
        System.out.println("car" + car);
        System.out.println("engine" + engine);
    }
}
