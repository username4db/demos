package demo.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.jboss.logging.Logger;

/**
 * Servlet Filter implementation class DemoFilter2
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = {
				"/*" }, initParams = { @WebInitParam(name = "DemoName", value = "DemoValue") })
public class DemoFilter2 implements Filter {

	private final Logger LOG = Logger.getLogger(this.getClass());

	/**
	 * Default constructor.
	 */
	public DemoFilter2() {
		LOG.info("constructor");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.info("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("doFilter");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.info("init");
	}

}
