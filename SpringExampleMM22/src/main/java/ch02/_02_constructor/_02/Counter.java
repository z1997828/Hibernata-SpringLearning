package ch02._02_constructor._02;

public class Counter {
	int     iCount;
	long    lCount;
	
	public Counter(Integer iCount) {
		this.iCount = iCount;
	}
	public Counter(Long lCount) {
		this.lCount = lCount;
	}
	public Integer getiCount() {
		return iCount;
	}
	public Long getlCount() {
		return lCount;
	}
	@Override
	public String toString() {
		return "Counter [iCount=" + iCount + ", lCount=" + lCount + "]";
	}
	
}
