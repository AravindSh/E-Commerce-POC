package mongodbDataInit.mongodbDataInit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectId {
	
	@JsonProperty("$oid")
	private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
}
