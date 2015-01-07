package cn.itcast.video.aciton;

import org.apache.struts2.ServletActionContext;

import cn.itcast.video.service.LoginResultService;

@SuppressWarnings("serial")
public class LoginAction  extends BaseAction <LoginResultService> {
	// �û���
	static final String USERNAME = "123";
	// ����
	static final String PWD = "123";
	private String username;
	private String pwd;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public LoginAction()
	{
		service = new LoginResultService();
	}
	
	/**
	 * �����¼
	 */
	public void login() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if ("GET".equals(method)) { // GET��Ҫ�������������ת��
			// ���� --UTF-8ת��--> %E%%DD --tomcat-ISO8859-1--> ����
			if(username != null) {
				byte[] bytes = username.getBytes("ISO8859-1");
				username = new String(bytes, "UTF-8");
			}
			
			if(pwd != null) {
				byte[] bytes = pwd.getBytes("ISO8859-1");
				pwd = new String(bytes, "UTF-8");
			}
		}
		System.out.println("�û���="+username+", ����="+pwd);
		
		// ��������
		if (!USERNAME.equals(username)) { // �û���������
			service.setSuccess(false);
			service.setMessage("�û���������");
		} else if (!PWD.equals(pwd)) { // ���벻��ȷ
			service.setSuccess(false);
			service.setMessage("���벻��ȷ");
		} else { // �û�����������ȷ
			service.setSuccess(true);
			service.setMessage("��¼�ɹ�");
		}
		
		// �������
		write();
	}
}
