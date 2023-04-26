package com.headshot.filesourcebatchtry.job;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.inject.Named;

/**
 * 
 * @author nikheel.patel
 *
 */
@Named("capitalizeLine")
public class capitalizeLine implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
		return ((String) item).toUpperCase();
	}
}