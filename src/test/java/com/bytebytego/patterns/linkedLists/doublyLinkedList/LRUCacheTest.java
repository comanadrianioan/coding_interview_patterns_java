package com.bytebytego.patterns.linkedLists.doublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LRUCacheTest {
    private LRUCache cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache(2);
    }

    @Test
    void testBasicPutAndGet() {
        cache.put(1, 1);
        assertEquals(1, cache.get(1), "Should return 1 for key 1");
        assertEquals(-1, cache.get(2), "Should return -1 for non-existent key");
    }

    @Test
    void testUpdateExistingKey() {
        cache.put(1, 1);
        cache.put(1, 2);
        assertEquals(2, cache.get(1), "Should return updated value 2 for key 1");
    }

    @Test
    void testEvictionWhenCapacityExceeded() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3); // This should evict key 1
        assertEquals(-1, cache.get(1), "Key 1 should have been evicted");
        assertEquals(2, cache.get(2), "Key 2 should still be present");
        assertEquals(3, cache.get(3), "Key 3 should be present");
    }

    @Test
    void testLRUEvictionOrder() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);      // Makes key 1 most recently used
        cache.put(3, 3);   // Should evict key 2
        assertEquals(1, cache.get(1), "Key 1 should still be present");
        assertEquals(-1, cache.get(2), "Key 2 should have been evicted");
        assertEquals(3, cache.get(3), "Key 3 should be present");
    }

    @Test
    void testSingleCapacity() {
        LRUCache singleCache = new LRUCache(1);
        singleCache.put(1, 1);
        singleCache.put(2, 2);
        assertEquals(-1, singleCache.get(1), "Key 1 should have been evicted");
        assertEquals(2, singleCache.get(2), "Key 2 should be present");
    }

    @Test
    void testGetUpdatesLRUOrder() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);      // Makes key 1 most recently used
        cache.put(3, 3);   // Should evict key 2 instead of key 1
        assertEquals(1, cache.get(1), "Key 1 should still be present after get operation");
        assertEquals(3, cache.get(3), "Key 3 should be present");
        assertEquals(-1, cache.get(2), "Key 2 should have been evicted");
    }

    @Test
    void testMultipleUpdates() {
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);  // Update value of key 1
        cache.put(3, 3);   // Should evict key 2
        assertEquals(10, cache.get(1), "Key 1 should have updated value");
        assertEquals(-1, cache.get(2), "Key 2 should have been evicted");
        assertEquals(3, cache.get(3), "Key 3 should be present");
    }
}