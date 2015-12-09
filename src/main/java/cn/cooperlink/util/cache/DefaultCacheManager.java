package cn.cooperlink.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultCacheManager implements CacheManager{

	//用于存放所有的Cache
	public final Map<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	
	//构造cacheManager,可同时创建多个cache
	public DefaultCacheManager(String... cacheNames){
		if (cacheNames == null) {
			throw new NullPointerException("错误：参数cacheNames不能为空！");
		}
		for (String cacheName : cacheNames) {
			createCache(cacheName);
		}
	}
	
	@Override
	public void createCache(String cacheName) {
		if (cacheName == null) {
			throw new NullPointerException("错误：参数cacheName不能为空！");
		}
		if(cacheMap.containsKey(cacheName)){
			throw new CacheException("错误：同名的cache已经存在，无法创建！");
		}
		Cache cache = new DefaultCache();
		cacheMap.put(cacheName, cache);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(String cacheName) {
		if (cacheName == null) {
			throw new NullPointerException("错误：参数cacheName不能为空！");
		}
		return cacheMap.get(cacheName);
	}

	@Override
	public Iterable<String> getCacheNames() {
		return (Iterable<String>) cacheMap.keySet();
	}

	@Override
	public void destoryCache(String cacheName) {
		if (cacheName == null) {
			throw new NullPointerException("错误：参数cacheName不能为空！");
		}
		Cache cache = getCache(cacheName);
		if (cache != null) {
			cache.claer();
		}
	}

	@Override
	public void destoryCacheAll() {
		for (String cacheName : getCacheNames()) {
			destoryCache(cacheName);
		}
	}

}
