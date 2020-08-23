package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

/**
 * Servlet implementation class DemoServlet1
 */
@WebServlet("/demo1")
public class DemoServlet1 extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private final Logger LOG = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoServlet1() {
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

		response.setContentType("text/html");
		// request.login("USER", "PASS");
		if (request.authenticate(response)) {
			LOG.info(request.getAuthType());
		}
		System.getenv().forEach((key, value) -> {
			try {
				response.getWriter().append(key).append(":").append(value).append("<HR>");
			} catch (Exception e) {
			}
		});
		ending();

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
