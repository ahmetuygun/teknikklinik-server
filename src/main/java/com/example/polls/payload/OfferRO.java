package com.example.polls.payload;

import java.math.BigDecimal;

public class OfferRO {
	
	    private Integer id;
	    private BigDecimal price;
	    private int fixerId;
	    private String  defectName ;
	    private int deviceId;
	    private int defectId;;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public int getFixerId() {
			return fixerId;
		}
		public void setFixerId(int fixerId) {
			this.fixerId = fixerId;
		}
		public String getDefectName() {
			return defectName;
		}
		public void setDefectName(String defectName) {
			this.defectName = defectName;
		}
		public int getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(int deviceId) {
			this.deviceId = deviceId;
		}
		public int getDefectId() {
			return defectId;
		}
		public void setDefectId(int defectId) {
			this.defectId = defectId;
		}
	    
	    
	    
	    
	    
	    

}
