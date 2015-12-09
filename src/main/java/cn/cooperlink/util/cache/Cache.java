package cn.cooperlink.util.cache;

/**
 * 
 * @ClassName Cache
 * @Description cache接口，cache常用操作
 * @author andy.hu
 * @Date 2015年12月8日
 */
public interface Cache<K,V> {

	/**
	 * 从缓存获取数据
	 * @param key
	 * @return
	 */
	public V get(K key);
	
	/**
	 * 数据放入缓存中
	 * @param key
	 * @param value
	 */
	public void put(K key , V value);
	
	/**
	 * 更新缓存数据
	 * @param key
	 * @param value
	 */
	public void update(K key, V value);
	
	/**
	 * 是否包含该key
	 * @param key
	 * @return
	 */
	public boolean containKey(K key);
	
	/**
	 * 从缓存中移除数据
	 * @param key
	 * @return
	 */
	public boolean remove(K key);
	
	/**
	 * 清楚缓存
	 */
	public void claer();
	
}
