package top.xc27.dcard.service;

import javax.servlet.http.HttpServletRequest;

public interface DcardService {

    String analyseData(String url, HttpServletRequest servletRequest);
}
