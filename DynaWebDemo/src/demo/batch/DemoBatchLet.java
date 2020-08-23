package demo.batch;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import demo.pojo.DemoPojo;

@Named
public class DemoBatchLet extends AbstractBatchlet {

	private final Logger LOG = Logger.getLogger(this.getClass());

	@Inject
	private DemoPojo demoPojo1;

	@Override
	public String process() throws Exception {
		LOG.info("demoBatchLet start");
		LOG.info(demoPojo1.getData());
		LOG.info(demoPojo1);
		Thread.sleep(3000);
		LOG.info("demoBatchLet ending");
		return BatchStatus.COMPLETED.toString();
	}
}