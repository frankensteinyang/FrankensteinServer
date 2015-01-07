package cn.itcast.video.tool;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ResponseTool {
	public static final String CONTENT_TYPE_XML = "text/xml;charset=UTF-8";
	public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
	public static final String CONTENT_TYPE_PLAIN = "text/plain;charset=UTF-8";
	public static final int ERROR_CODE_INVALID = HttpServletResponse.SC_BAD_REQUEST;
	public static final int ERROR_CODE_NOT_FOUND = HttpServletResponse.SC_NOT_FOUND;
	public static final int ERROR_CODE_INTERNAL = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	public static final String ERROR_MESSAGE_INVALID = "����������";
	public static final String ERROR_MESSAGE_NOT_FOUND = "�Ҳ�����Դ";
	public static final String ERROR_MESSAGE_INTERNAL = "�������ڲ�����";
	/**
	 * д���ݸ��ͻ���
	 * @param content ����
	 * @param contentType ��������
	 */
	public static void write(String content, String contentType) throws Exception  {
		HttpServletResponse response = ServletActionContext.getResponse();
		// ���ñ�������ݸ�ʽ
		response.setContentType(contentType);
		Writer writer = response.getWriter();
		writer.write(content);
		writer.flush();
		writer.close();
	}
	public static void writeXML(String content) throws Exception  {
		write(content, CONTENT_TYPE_XML);
	}	
	public static void writeJSON(String content) throws Exception  {
		write(content, CONTENT_TYPE_JSON);
	}
	
	/**
	 * д���ݸ��ͻ���
	 * @param content ����
	 * @param contentType ��������
	 * @param erroCode ������
	 * @param errorMsg ������Ϣ
	 */
	public static void writeError(String content, String contentType, int erroCode, String errorMsg) throws Exception  {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendError(erroCode, errorMsg);
		// ���ñ�������ݸ�ʽ
		write(content, contentType);
	}
	public static void writeErrorXML(String content, int erroCode, String errorMsg) throws Exception  {
		writeError(content, CONTENT_TYPE_XML, erroCode, errorMsg);
	}	
	public static void writeErrorJSON(String content, int erroCode, String errorMsg) throws Exception  {
		writeError(content, CONTENT_TYPE_JSON, erroCode, errorMsg);
	}
}
