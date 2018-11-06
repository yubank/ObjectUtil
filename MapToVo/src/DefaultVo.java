
public class DefaultVo {
	public String getAAA() {
		return AAA;
	}
	public void setAAA(String aAA) {
		AAA = aAA;
	}
	public String getBBB() {
		return BBB;
	}
	public void setBBB(String bBB) {
		BBB = bBB;
	}
	public String getCCC() {
		return CCC;
	}
	public void setCCC(String cCC) {
		CCC = cCC;
	}
	
	private String AAA;
	private String BBB;
	private String CCC;

	@Override
	public String toString() {
		return "AAA:" + AAA + "\nBBB:" + BBB + "\nCCC:" + CCC;
	}
}
