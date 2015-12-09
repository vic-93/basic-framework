package cn.cooperlink.util.cache;


/**
 * 
 * @ClassName CacheManager
 * @Description 对外提供Cache,管理Cache
 * @author andy.hu
 * @Date 2015年12月8日
 */
public interface CacheManager {
	
	/**
	 * 创建缓存
	 * @param cacheName
	 */
	public void createCache(String cacheName);
	
	/**
	 * 获取缓存
	 * @param cacheName
	 * @return
	 */
	public <K, V> Cache<K, V> getCache(String cacheName);
	
	/**
	 * 获取所有缓存名
	 * @return
	 */
	public Iterable<String> getCacheNames();
	
	/**
	 * 销毁指定缓存
	 * @param cacheName
	 */
	public void destoryCache(String cacheName);
	
	/**
	 * 销毁所有缓存
	 */
	public void destoryCacheAll();

}
