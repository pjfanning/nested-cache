package nested;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class CaffeineNestedCache {

    class FactorialLoader implements CacheLoader<Integer, Long> {
        @Override
        public Long load(Integer key) {
            if (key == 0) {
                return 1L;
            }
            return key * cache.get(key - 1);
        }
    }

    LoadingCache<Integer, Long> cache = Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new FactorialLoader());

    public long factorial(int n) {
        return cache.get(n);
    }
}
