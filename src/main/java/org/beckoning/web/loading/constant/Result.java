package org.beckoning.web.loading.constant;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private static final Map<Integer, String> msgs = new HashMap<>();

	public static final int RESULT_OK = 0;

	static {
		msgs.put(RESULT_OK, "操作成功");
	}

	public static String getMsg(int key) {
		return msgs.get(key);
	}

}
