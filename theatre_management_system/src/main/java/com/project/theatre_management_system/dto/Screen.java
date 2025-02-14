package com.project.theatre_management_system.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;
	private String screenType;
	private String screenSize;
	private Time screenStartTime;
	private Time screenEndTime;
	private String screenNumber;
	private String screenAudioType;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public Time getScreenStartTime() {
		return screenStartTime;
	}
	public void setScreenStartTime(Time screenStartTime) {
		this.screenStartTime = screenStartTime;
	}
	public Time getScreenEndTime() {
		return screenEndTime;
	}
	public void setScreenEndTime(Time screenEndTime) {
		this.screenEndTime = screenEndTime;
	}
	public String getScreenNumber() {
		return screenNumber;
	}
	public void setScreenNumber(String screenNumber) {
		this.screenNumber = screenNumber;
	}
	public String getScreenAudioType() {
		return screenAudioType;
	}
	public void setScreenAudioType(String screenAudioType) {
		this.screenAudioType = screenAudioType;
	}
	
}
