package nested;

import org.junit.Assert;
import org.junit.Test;

public class AsyncCaffeineNestedCacheTest {
    @Test
    public void testFactorial() throws Exception {
        AsyncCaffeineNestedCache cache = new AsyncCaffeineNestedCache();
        Assert.assertEquals(3628800L, cache.factorial(10));
    }
}
