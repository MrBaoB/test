package yzk.power.entity;

public class Power {
	private Integer id;//用户id
	private String zsxm; //真实姓名
	private String xh; //学号/工号
	private String xb; //性别
	private String bjid; //班级
	private String js;//角色
	private Integer jsid;//角色
	public Integer getJsid() {
		return jsid;
	}
	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}
	private String jsxgr;//角色修改人
	private String jsxgrq;//角色修改日期
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZsxm() {
		return zsxm;
	}
	public void setZsxm(String zsxm) {
		this.zsxm = zsxm;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getBjid() {
		return bjid;
	}
	public void setBjid(String bjid) {
		this.bjid = bjid;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getJsxgr() {
		return jsxgr;
	}
	public void setJsxgr(String jsxgr) {
		this.jsxgr = jsxgr;
	}
	public String getJsxgrq() {
		return jsxgrq;
	}
	public void setJsxgrq(String jsxgrq) {
		this.jsxgrq = jsxgrq;
	}
	
}
