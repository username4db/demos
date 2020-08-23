package demo.servlet;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.jboss.logging.Logger;

import demo.pojo.DemoTimer;

public class BaseServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(BaseServlet.class);

	private static final long serialVersionUID = 1L;

	@Inject
	DemoTimer demoTimer;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseServlet() {
		super();
	}

	public String starting() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		LOG.info(stackTrace[2].getClassName() + ":" + stackTrace[2].getMethodName());
		return "";
	}

	public String ending() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		LOG.info(stackTrace[2].getClassName() + ":" + stackTrace[2].getMethodName());
		return "";
	}

}
