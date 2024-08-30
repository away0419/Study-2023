package com.example.encryption.encryption;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EncryptionCache {

    /**
     * 캐시 조회. 저장 안함.
     * @param cacheKey
     * @return
     */
    @Cacheable(cacheNames = CommonCacheConstants.ENCRYPT, key = "#cacheKey", unless = "!#result")
    public boolean getCache(String cacheKey) {
        return false;
    }

    /**
     * 캐시 저장
     * @param cacheKey
     * @return
     */
    @CachePut(cacheNames = CommonCacheConstants.ENCRYPT, key = "#cacheKey", condition = "#cacheKey != null and #cacheKey.length() != 0", unless = "!#result")
    public boolean setCache(String cacheKey) {
        return true;
    }

    /**
     * 캐시 삭제
     * @param cacheKey
     */
    @CacheEvict(cacheNames = CommonCacheConstants.ENCRYPT, key = "#cacheKey")
    public void evictCache(String cacheKey) {
    }

}
