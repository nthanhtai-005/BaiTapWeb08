package vn.iostar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -851275453357087824L;
	private String id;
	private String name;
	private String phoneNumber;
	private String email;
}
