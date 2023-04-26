package com.headshot.filesourcebatchtry.job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("readFile")
public class readFile extends AbstractItemReader {

	private String fileName;
	private BufferedReader breader;
	private long linesvisited = 0;

	@Inject
	JobContext jobCtx;

	@Override
	public void open(Serializable ckpt) throws Exception {
		fileName = jobCtx.getProperties().getProperty("inputfile");
		breader = new BufferedReader(new FileReader(fileName));
		if (ckpt != null) {
			breader.lines().skip(linesvisited);
		}
	}

	@Override
	public void close() throws Exception {
		breader.close();
	}

	@Override
	public Object readItem() throws Exception {
		if (breader != null) {
			linesvisited++;
			return breader.readLine();
		}
		return null;
	}
}
