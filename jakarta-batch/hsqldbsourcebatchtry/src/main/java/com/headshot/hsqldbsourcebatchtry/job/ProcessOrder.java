package com.headshot.hsqldbsourcebatchtry.job;

import java.time.LocalDateTime;

import com.headshot.hsqldbsourcebatchtry.entity.Customermonthlyspent;
import com.headshot.hsqldbsourcebatchtry.entity.CustomermonthlyspentPK;
import com.headshot.hsqldbsourcebatchtry.entity.Order;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.inject.Named;

/**
 * 
 * @author nikheel.patel
 *
 */
@Named("ProcessOrder")
public class ProcessOrder implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
		Order order = (Order) item;
		
		Customermonthlyspent cms = new Customermonthlyspent();
		CustomermonthlyspentPK cmspk = new CustomermonthlyspentPK();

		cms.setAmount(order.getAmount());
		cms.setId(cmspk);

		cmspk.setCid(order.getCid());
		cmspk.setMonthyear(LocalDateTime.of(order.getCreatedon().getYear(), order.getCreatedon().getMonth(), 1, 0, 0));		
		return cms;
	}
}