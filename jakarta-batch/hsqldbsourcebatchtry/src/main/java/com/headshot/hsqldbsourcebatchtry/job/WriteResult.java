package com.headshot.hsqldbsourcebatchtry.job;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.headshot.hsqldbsourcebatchtry.entity.Customermonthlyspent;
import com.headshot.hsqldbsourcebatchtry.repo.CustomermonthlyspentRepo;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("WriteResult")
public class WriteResult extends AbstractItemWriter {

	@Inject
	CustomermonthlyspentRepo cmsRepo;

	@Inject
	JobContext jobCtx;

	@Override
	public void open(Serializable ckpt) throws Exception {
		if(cmsRepo==null) {
			System.out.println("cmsRepo is null");
		}
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		System.out.println(Arrays.deepToString(items.toArray()));
		for (Object object : items) {
			cmsRepo.accumulateCMS((Customermonthlyspent) object);
		}
	}
}
