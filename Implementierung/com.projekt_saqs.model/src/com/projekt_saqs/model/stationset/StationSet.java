package com.projekt_saqs.model.stationset;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.projekt_saqs.Info;
import com.projekt_saqs.Station;
import com.projekt_saqs.model.UpdateInfoModel;

public class StationSet extends Observable implements UpdateInfoModel, Runnable{
	private ArrayList<Station> list_station = new ArrayList<Station>();
	
	public StationSet(){
		
	}

	public ArrayList<Station> getList_station() {
		return list_station;
	}

	public void setList_station(ArrayList<Station> list_station) {
		this.list_station = list_station;
	}

	@Override
	public void run() {
		Random r = new Random();
		int i = 0, time = 0;
		while(i < 10){
			try {
				Thread.sleep(time * 1000);
				Station station = new Station();
				this.list_station.add(station);
				this.setChanged();
				this.notifyObservers();
				System.out.println("\nA new Station is created");
				System.out.println(station.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time = r.nextInt((30 - 2) + 1) + 2;
			i++;
		}
	}
	
	public void show_list_station(){
		int i = 1;
		for(Station s : this.list_station){
			System.out.println(i + ") Id: " + s.getIdStation() + "\tdate: " + s.getDate().toString() + "\tTarget: " + s.getTarget());
			i++;
		}
	}

	@Override
	public int getActualInfo(Info info) {
		int index = this.getStationIndex(info);
		if(index != -1){
			Station currentStation = this.list_station.get(index);
			if(index != -1){
				this.list_station.get(index).setIdStation(info.getIdStation());
				this.list_station.get(index).setDate(info.getDate());
				this.list_station.get(index).setTarget(info.getTarget());
				System.out.println("The station " + currentStation.getIdStation() + " has been modified!!!");
				return 0;
			}else{
				System.out.println("The station " + currentStation.getIdStation() + " was not found!!!");
				return -1;
			}
		}else{
			System.out.println("The station " + info.getIdStation() + " was not found!!!");
			return -1;
		}
	}
	
	public Station getStation(String n_id){
		for(Station s : this.list_station){
			if(s.getIdStation() == n_id)
				return s;
		}
		return null;
	}
	
	public Station getStation(Station s){
		return this.getStation(s.getIdStation());
	}
	
	public int getStationIndex(String n_id){
		int i = 0;
		for(Station s : this.list_station){
			if(s.getIdStation() == n_id)
				return i;
			i++;
		}
		return -1;
	}
	
	public int getStationIndex(Station s){
		return this.getStationIndex(s.getIdStation());
	}
}
