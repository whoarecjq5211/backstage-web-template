package org.beckoning.web.loading.constant;

public class CommonResp {
	private int result;
	private String msg;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
		this.msg = Result.getMsg(result);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonResp [result=").append(result).append(", msg=").append(msg).append("]");
		return builder.toString();
	}

}
