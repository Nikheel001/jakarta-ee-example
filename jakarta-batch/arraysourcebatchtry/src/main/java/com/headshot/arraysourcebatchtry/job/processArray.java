package com.headshot.arraysourcebatchtry.job;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.inject.Named;

@Named("processArray")
public class processArray implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
		Integer x = (Integer) item;
		return (x & 1) == 1 ? x : null;
	}

}
