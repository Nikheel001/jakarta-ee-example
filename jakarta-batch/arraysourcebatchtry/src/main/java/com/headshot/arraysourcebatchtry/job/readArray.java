package com.headshot.arraysourcebatchtry.job;

import java.io.Serializable;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("readArray")
public class readArray extends AbstractItemReader {

	Integer idx = 0;
	int[] ref;

	@Inject
	JobContext jobCtx;

	@Override
	public void open(Serializable ckpt) throws Exception {
		ref = new int[45];
		ref[0] = 0;
		for (int i = 1; i < ref.length; i++) {
			ref[i] = i;
		}
	}

	@Override
	public Object readItem() throws Exception {
		if (idx >= ref.length) {
			return null;
		}
		return ref[idx++];
	}
}
