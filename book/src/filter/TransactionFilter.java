package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName TransactionFilter
 * @Description TODO
 * @Author SawyerRen
 * @Date 2020/3/28 21:10
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
