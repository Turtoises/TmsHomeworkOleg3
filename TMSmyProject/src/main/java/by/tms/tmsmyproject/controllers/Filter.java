package by.tms.tmsmyproject.controllers;

import by.tms.tmsmyproject.utils.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "DateFilter", urlPatterns = Constants.URI_FIRST_PAGE)
public class Filter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uri = request.getRequestURI();

        if (uri.equals(Constants.URI_FIRST_PAGE)) {
            request.getRequestDispatcher(Constants.URI_FRONT_CONTROLLER_SERVLET + "?command=" + Constants.COMMAND_OPEN_FIST_PAGE).forward(request, response);
        }

        chain.doFilter(request, response);
    }
}

