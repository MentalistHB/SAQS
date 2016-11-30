package com.projekt_saqs.presenter;

import java.util.Random;

import com.projekt_saqs.Info;
import com.projekt_saqs.model.UpdateInfoModel;

public class ComponentPresenter implements Runnable{
	private UpdateInfoModel uim;

	public ComponentPresenter(UpdateInfoModel n_uim){
		this.uim = n_uim;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		int i = 0, time = 0;
		while(i < 10){
			try {
				Thread.sleep(time * 1000);
				Info info = new Info();
				this.uim.getActualInfo(info);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time = r.nextInt((30 - 2) + 1) + 2;
			i++;
		}
	}
}
