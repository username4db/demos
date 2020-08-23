package demo.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import demo.pojo.DemoPojo1;

/**
 * Servlet implementation class DemoServlet2
 */
@WebServlet("/demo2")
public class DemoServlet2 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private final Logger LOG = Logger.getLogger(this.getClass());

	@Inject
	private DemoPojo1 demoPojo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet2() {
		super();
		LOG.info("constructor");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		starting();
		response.setContentType("text/plain");
		submitJobFromXML("DemoJob");
		System.getProperties().list(response.getWriter());
		response.getWriter().append("<HR>").append("Served at: ").append(request.getContextPath());
		ending();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private long submitJobFromXML(String jobName) {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties props = new Properties();
		props.setProperty("PROP", "");
		long executionID = jobOperator.start(jobName, props);
		return executionID;
	}

}
