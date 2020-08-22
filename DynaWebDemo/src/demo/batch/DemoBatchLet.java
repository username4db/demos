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
	DemoPojo pojo;

	@Override
	public String process() throws Exception {
		LOG.info("demoBatchLet start");
		LOG.info(pojo.getData());
		Thread.sleep(3000);
		pojo.setData("new");
		LOG.info("demoBatchLet ending");
		return BatchStatus.COMPLETED.toString();
	}
}