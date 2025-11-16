package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = path.equals("/login") || path.equals("/login.jsp");
        boolean registerRequest = path.equals("/register") || path.equals("/register.jsp");
        boolean resourceRequest = path.startsWith("/css/") || path.startsWith("/js/") || path.startsWith("/images/");

        if (loggedIn || loginRequest || registerRequest || resourceRequest || path.equals("/")) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }
}