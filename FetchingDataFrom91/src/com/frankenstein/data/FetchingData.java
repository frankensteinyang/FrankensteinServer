package com.frankenstein.data;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;



public class FetchingData {

	public static void main(String[] args) {
		
		try {
		// syso Alt + / 
//		System.out.println();
		
		// 创建网页解析器
		Parser p = new Parser();
		// 设置网页文件路径
		p.setURL("file:///Users/yons/Documents/workspace/FetchingDataFrom91/attachments/91.html");
		// 开始解析(只获得img节点)
		NodeFilter filter = new TagNameFilter("img");
		
		NodeList nodeList = p.parse(filter);
		System.out.println(nodeList.size());
		
		StringBuilder sb = new StringBuilder();
		sb.append("@[");
		for (int i = 0; i < nodeList.size(); i++) {
			TagNode imgNode = (TagNode)nodeList.elementAt(i);
			String src = imgNode.getAttribute("src");
			String title = imgNode.getAttribute("title");
//			System.out.println("title =" + title + "src =" + src );
			
			sb.append("@{");
			
			sb.append(" @\"title\" : @\"" + title + "\", ");
			sb.append(" @\"src\" : @\"" + src + "\" ");
			
			sb.append("}");
			if (i != nodeList.size() - 1) {
				sb.append(", ");
			}
			
		}
		
		sb.append("]");
		System.out.println(sb);
		
		} catch (Exception e) {
		
		}
	}

}
