package nested;

import org.junit.Assert;
import org.junit.Test;

public class GuavaNestedCacheTest {
    @Test
    public void testFactorial() throws Exception {
        GuavaNestedCache cache = new GuavaNestedCache();
        Assert.assertEquals(3628800L, cache.factorial(10));
    }
}
