package sk.plaut.ChatApp.filters;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("logedInUser") != null) {
            filterChain.doFilter(request, response);
        } else {
            session.setAttribute("logedInInfo", "Ops.. nie si prihlaseny.");

            request = new HttpServletRequestWrapper(request) {
                @Override
                public String getRequestURI() {
                    return "/";
                }
            };
            filterChain.doFilter(request,response);
        }

    }
}
