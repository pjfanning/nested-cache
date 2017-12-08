package nested;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;

public class AsyncCaffeineNestedCache {
    class FactorialLoader implements CacheLoader<Integer, Long> {
        @Override
        public Long load(Integer key) throws Exception {
            if (key == 0) {
                return 1L;
            }
            return key * cache.get(key - 1).get();
        }
    }

    AsyncLoadingCache<Integer, Long> cache = Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .buildAsync(new FactorialLoader());

    public long factorial(int n) throws Exception {
        return cache.get(n).get();
    }
}
