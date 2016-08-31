package exam.test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 4/12/12
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompressionResponseWrapper extends HttpServletResponseWrapper {

    private GZIPServletOutputStream servletGzipOS = null;
    private PrintWriter pw = null;
    private Object streamUsed = null;


    public CompressionResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    public void setContentLength(int len) { }

    public GZIPOutputStream getGZIPOutputStream() {
        return this.servletGzipOS.internalGzipOS;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if ((streamUsed != null) && (streamUsed != pw)) {
            throw new IllegalStateException();
        }
        if ( servletGzipOS == null ) {
            servletGzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
            streamUsed = servletGzipOS;
        }
        return servletGzipOS;
    }
    public PrintWriter getWriter() throws IOException {
        if ( (streamUsed != null) && (streamUsed != servletGzipOS)) {
            throw new IllegalStateException();
        }
        if ( pw == null ) {
            servletGzipOS = new GZIPServletOutputStream(getResponse()
                    .getOutputStream());
            OutputStreamWriter osw  = new OutputStreamWriter(servletGzipOS,getResponse().getCharacterEncoding());
            pw = new PrintWriter(osw);
            streamUsed = pw;
        }
        return pw;
    }
}

