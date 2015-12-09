package cn.cooperlink.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @ClassName DefaultCache
 * @Description cache默认实现，
 * 				备并发控制,保证线程之间的共享互斥
 * @author andy.hu
 * @Date 2015年12月8日
 */
public class DefaultCache<K, V> implements Cache<K, V>{

	//用于存放cache数据
	private final Map<K, V> dataMap = new ConcurrentHashMap<K, V>();
	
	@Override
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException("错误：参数key不能为空！");
		}
		return dataMap.get(key);
	}

	@Override
	public void put(K key, V value) {
		if (key == null) {
			throw new NullPointerException("错误：参数key不能为空！");
		}
		if (value == null) {
			throw new NullPointerException("错误：参数value不能为空！");
		}
		dataMap.put(key, value);
	}

	@Override
	public void update(K key, V value) {
		if (key == null) {
			throw new NullPointerException("错误：参数key不能为空！");
		}
		if (value == null) {
			throw new NullPointerException("错误：参数value不能为空！");
		}
		dataMap.remove(key);
		dataMap.put(key, value);
	}

	@Override
	public boolean remove(K key) {
		if (key == null) {
			throw new NullPointerException("错误：参数key不能为空！");
		}
		return dataMap.remove(key) != null;
	}

	@Override
	public void claer() {
		dataMap.clear();
	}

	@Override
	public boolean containKey(K key) {
		return dataMap.containsKey(key);
	}

}
