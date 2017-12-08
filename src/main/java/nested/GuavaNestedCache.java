package nested;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaNestedCache {

    class FactorialLoader extends CacheLoader<Integer, Long> {
        @Override
        public Long load(Integer key) throws Exception {
            if (key == 0) {
                return 1L;
            }
            return key * cache.get(key - 1);
        }
    }

    LoadingCache<Integer, Long> cache = CacheBuilder.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new FactorialLoader());

    public long factorial(int n) throws Exception {
        return cache.get(n);
    }
}
