package cn.itcast.video.aciton;

import java.io.File;

import cn.itcast.video.service.UploadServiceResult;

@SuppressWarnings("serial")
public class UploadAction extends BaseAction <UploadServiceResult> {
	// �ļ��ϴ����ĸ��ļ�������(�����Ǵ��ڵ��ļ���)
	static final String FILE_DIR = "/Users/apple/Desktop/";
	private String username;
	private File file;
	private String fileFileName;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public UploadAction()
	{
		service = new UploadServiceResult();
	}
	
	/**
	 * �����ļ��ϴ�
	 */
	public void upload() throws Exception {
		if (file != null) {
			service.setSuccess(true);
			service.setMessage("�ϴ��ɹ�");
			file.renameTo(new File(FILE_DIR + fileFileName));
			System.out.println(username + "�ϴ���" + fileFileName + "�ļ�");
		} else {
			service.setSuccess(false);
			service.setMessage("�ϴ�ʧ��");
		}

		write();
	}
}
