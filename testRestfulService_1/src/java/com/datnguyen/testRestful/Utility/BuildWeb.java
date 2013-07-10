/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnguyen.testRestful.Utility;

/**
 *
 * @author AsusVM
 */
public class BuildWeb {
    public static String buildWebMap(String imgHttp){
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>");
        builder.append("<html lang=\"en\">");
        builder.append("<head><title>Title</title> <meta http-equiv=\"refresh\" content=\"5\" ></head>");
        builder.append("<body><img src=\"");
        builder.append(imgHttp);
        builder.append("\"></body>");
        //Hello</h1></body>");
        builder.append("</html>");
        String html = builder.toString();
        return html;
    }
            
}
