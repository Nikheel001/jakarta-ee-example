package com.headshot.hsqldbsourcebatchtry.job;

import java.io.Serializable;
import java.util.Iterator;

import com.headshot.hsqldbsourcebatchtry.entity.Order;
import com.headshot.hsqldbsourcebatchtry.repo.OrderRepo;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("ReadOrder")
public class ReadOrder extends AbstractItemReader {

	@Inject
	OrderRepo orderrepo;

	private int ordersVisited = 0;

	@Inject
	JobContext jobCtx;

	Iterator<Order> orders;

	@Override
	public void open(Serializable ckpt) throws Exception {
		orders = orderrepo.listNextNitems(ordersVisited, 10).iterator();
	}

	@Override
	public void close() throws Exception {
	}

	@Override
	public Object readItem() throws Exception {
		if (orders != null && orders.hasNext()) {
			ordersVisited++;
			return orders.next();
		}
		return null;
	}
}
