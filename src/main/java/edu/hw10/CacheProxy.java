package edu.hw10;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Object target;
    private final Map<String, Object> cache;
    private final boolean persist;

    private CacheProxy(Object target, boolean persist) {
        this.target = target;
        this.cache = new HashMap<>();
        this.persist = persist;
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(Object target, Class<T> interfaceClass, boolean persist) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[]{interfaceClass},
            new CacheProxy(target, persist)
        );
    }

    public static <T> T create(Object target, Class<T> interfaceClass) {
        return create(target, interfaceClass, false);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = method.getName() + argsToString(args);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        Object result = method.invoke(target, args);
        cache.put(key, result);

        if (persist) {
            persistResult(key, result);
        }

        return result;
    }

    private String argsToString(Object[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            sb.append("_").append(arg.toString());
        }
        return sb.toString();
    }

    private void persistResult(String key, Object result) {
        // Ваш код для сохранения результата на диск
        // Например, можно использовать сериализацию объекта и запись в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(key + ".ser"))) {
            oos.writeObject(result);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
