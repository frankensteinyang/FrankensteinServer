package cn.itcast.video.aciton;

import cn.itcast.video.service.WeatherResultService;

@SuppressWarnings("serial")
public class WeatherAction extends BaseAction <WeatherResultService> {
	private String[] place;
	public void setPlace(String[] place) {
		this.place = place;
	}	
	public WeatherAction()
	{
		service = new WeatherResultService();
	}
	
	/**
	 * ��������Ԥ����Ϣ
	 */
	public void weather() throws Exception 
	{
		service.setPlace(place);
		write();
	}
}
