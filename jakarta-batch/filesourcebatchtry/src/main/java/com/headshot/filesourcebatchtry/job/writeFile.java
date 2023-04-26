package com.headshot.filesourcebatchtry.job;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("writeFile")
public class writeFile extends AbstractItemWriter {

	private String fileName;
	private BufferedWriter bwriter;

	@Inject
	JobContext jobCtx;

	@Override
	public void open(Serializable ckpt) throws Exception {
		fileName = jobCtx.getProperties().getProperty("outputfile");
		bwriter = new BufferedWriter(new FileWriter(fileName, true));
	}

	@Override
	public void close() throws Exception {
		bwriter.close();
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		if (bwriter != null) {
			System.out.println("writing to "+fileName);
			for (Object object : items) {
				bwriter.write(object.toString());
				bwriter.newLine();
			}
			bwriter.write("=================chunk written=================");
			bwriter.newLine();
			bwriter.flush();
		} else {
			System.out.println("check if filename is correct");
		}
	}
}
