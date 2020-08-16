package com.test.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mafeng
 * @data 2020/8/16
 **/
public class P7Lru {
    public static void main(String[] args) {

    }

    class LruCache<K, V> extends LinkedHashMap<K, V> {

        private final int CACHE_SIZE;

        public LruCache(int cacheSize) {
            super((int)Math.ceil((cacheSize / 0.75) + 1), 0.75f, true);
            CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > CACHE_SIZE;
        }
    }
}
