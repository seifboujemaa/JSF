package jsfproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsfproject.bean.AuthentificationBean;


@WebFilter("/faces/pages/*")
public class GeneralFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		HttpServletResponse response2 = (HttpServletResponse) response;
		AuthentificationBean bean = (AuthentificationBean) httpServletRequest.getSession().getAttribute("authentificationBean");
		if (bean != null &&  bean.isBool())
			filter.doFilter(httpServletRequest, response2);
		
		else
			response2.sendRedirect(httpServletRequest.getContextPath()
					+ "/faces/register.xhtml");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
