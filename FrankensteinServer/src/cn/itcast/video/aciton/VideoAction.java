package cn.itcast.video.aciton;

import cn.itcast.video.service.VideoResultService;

@SuppressWarnings("serial")
public class VideoAction extends BaseAction <VideoResultService> {
	public VideoAction()
	{
		service = new VideoResultService();
	}
	
	/**
	 * ������Ƶ��Ϣ
	 */
	public void video() throws Exception 
	{
		write();
	}
}
