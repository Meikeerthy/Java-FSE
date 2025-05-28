import java.lang.reflect.*;

public class Ex39_Reflection {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("MyClass");

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods in MyClass:");
            for (Method method : methods) {
                System.out.println("- " + method.getName() + " with parameters: " + 
                                   Arrays.toString(method.getParameterTypes()));
            }

            Object obj = clazz.getDeclaredConstructor().newInstance();

            Method sayHelloMethod = clazz.getMethod("sayHello");
            sayHelloMethod.invoke(obj);

            Method addMethod = clazz.getMethod("add", int.class, int.class);
            Object result = addMethod.invoke(obj, 5, 7);
            System.out.println("Result of add(5, 7): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
