package cn.cooperlink.util.cache;

public class CacheException extends RuntimeException{

	public CacheException(){
		super();
	}
	
	public CacheException(String msg){
		super(msg);
	}
	
	public CacheException(String msg,Throwable throwable){
		super(msg, throwable);
	}
	
	public CacheException(Throwable throwable){
		super(throwable);
	}
	
}
