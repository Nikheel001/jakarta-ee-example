package com.headshot.arraysourcebatchtry.job;

import java.util.List;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.inject.Named;

@Named("writeArray")
public class writeArray extends AbstractItemWriter {

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for (Object object : items) {
			System.out.println((Integer) object);
		}
	}

}
