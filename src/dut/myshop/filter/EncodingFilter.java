package dut.myshop.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletRequest myRequest=new MyRequest(httpRequest);
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		httpResponse.setContentType("text/html;charset=utf-8");
		// pass the request along the filter chain
		chain.doFilter(httpRequest, httpResponse);
	//	chain.doFilter(myRequest, httpResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;
	private boolean flag = false;

	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.req = request;
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		Map<String, String[]> map = this.getParameterMap();
		String[] values = map.get(name);
		if (values == null)
			return null;
		return values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		String method = req.getMethod();
		if (method.equalsIgnoreCase("post")) {
			try {
				req.setCharacterEncoding("utf-8");
				return req.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (method.equalsIgnoreCase("get")) {
			Map<String, String[]> map = req.getParameterMap();
			if (!flag) {
				for (String paramKey : map.keySet()) {

					String[] values = map.get(paramKey);
					for (int i = 0; i < values.length; i++) {
						try {
							values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				flag = true;
			}
			return map;
		}

		return super.getParameterMap();

	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		Map<String, String[]> map = this.getParameterMap();
		String[] strs = map.get(name);
		if (strs == null)
			return null;
		return strs;
	}

}
