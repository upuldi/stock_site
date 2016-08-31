package exam.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 4/12/12
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompressionFilter implements Filter {

    private ServletContext ctx;
    private FilterConfig cfg;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.cfg = filterConfig;
        ctx = cfg.getServletContext();
        ctx.log(cfg.getFilterName() + "initialized.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String valid_encodings = request.getHeader("Accept-Encoding");
        if ( valid_encodings.indexOf("gzip") > -1 ) {
            CompressionResponseWrapper wrappedResp = new CompressionResponseWrapper(response);
            wrappedResp.setHeader("Content-Encoding", "gzip");
            filterChain.doFilter(request, wrappedResp);

            GZIPOutputStream gzos = wrappedResp.getGZIPOutputStream();
            gzos.finish();
            ctx.log(cfg.getFilterName() + ": finished the request.");
        } else {
            ctx.log(cfg.getFilterName() + ": no encoding performed.");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        cfg = null;
        ctx = null;
    }

}
