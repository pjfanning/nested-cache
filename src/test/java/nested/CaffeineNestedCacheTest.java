package nested;

import org.junit.Assert;
import org.junit.Test;

public class CaffeineNestedCacheTest {
    @Test
    public void testFactorial() {
        CaffeineNestedCache cache = new CaffeineNestedCache();
        Assert.assertEquals(3628800L, cache.factorial(10));
    }
}
