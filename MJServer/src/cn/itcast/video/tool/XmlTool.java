package cn.itcast.video.tool;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class XmlTool {
	/**
	 * ����ֻ��һ��Ԫ�ص�xml
	 * @param rootEmtName Ԫ����
	 * @param attrName ������
	 * @param attrValue ����ֵ
	 */
	public static String xml(String rootEmtName, String attrName, String attrValue)
	{
		Element root = new Element(rootEmtName);
		root.setAttribute(attrName, attrValue);
		Document doc = new Document(root);
		XMLOutputter output = new XMLOutputter();
		return output.outputString(doc);
	}
	
	/**
	 * ����ֻ��һ��Ԫ�ص�xml
	 * @param rootEmtName Ԫ����
	 * @param text Ԫ������
	 */
	public static String xml(String rootEmtName, String text)
	{
		Element root = new Element(rootEmtName);
		root.setText(text);
		Document doc = new Document(root);
		XMLOutputter output = new XMLOutputter();
		return output.outputString(doc);
	}
}
