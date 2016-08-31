package exam.test;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 4/12/12
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class GZIPServletOutputStream extends ServletOutputStream {

    GZIPOutputStream internalGzipOS;

    /**
     * Decorator constructor
     */
    GZIPServletOutputStream(ServletOutputStream sos) throws IOException {
        this.internalGzipOS = new GZIPOutputStream(sos);
    }

    public void write(int param) throws java.io.IOException {
        internalGzipOS.write(param);
    }
}
