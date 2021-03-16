package bg.softuni.proxies.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheableInvocationHandler implements InvocationHandler {

  private final Object realObject;
  private final Map<String, Object> cache = new HashMap<>();

  public CacheableInvocationHandler(Object realObject) {
    this.realObject = realObject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Cacheable cacheable = realObject.
        getClass().
        getMethod(method.getName(), method.getParameterTypes()).
        getAnnotation(Cacheable.class);

    if (cacheable != null) {
      String cacheId = cacheable.value();
      Object cachedValue = cache.get(cacheId);
      if (cachedValue != null) {
        return cachedValue;
      } else  {
        cachedValue = method.invoke(realObject, args);
        cache.put(cacheId, cachedValue);
        return cachedValue;
      }
    } else  {
      return method.invoke(realObject, args);
    }
  }
}
