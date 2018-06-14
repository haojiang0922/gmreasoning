package gr.ntua.softeng.gm.model.comp;

public abstract class Component<T> {

	private T data;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
