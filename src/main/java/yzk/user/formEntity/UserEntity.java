package yzk.user.formEntity;


public class UserEntity {
	private int id;
	private int jsid; //角色
	private String xh;   //学号
	private String mm;  //密码
	private String zsxm; //真实姓名
	private String nm; //昵称
	private String tx;	//头像
	private String phone; //电话
	private String email; //邮箱
	private String tjsj; //提交时间
	private String ggsj; //更改时间
	private String xb;  //性别
	private String bjid; //班级
	private String js; //角色
	private int yhzt; //用户状态 0可用 1禁用
	private int lsskbid; // 老师授课表id
	private String jsxgr;//角色修改人
	private String jsxgrq;//角色修改日期
	private String njmc; //年级
	private String xi; //系
	private String zymc; //专业
	private String bjmc; //班级
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", jsid=" + jsid + ", xh=" + xh + ", mm=" + mm + ", zsxm=" + zsxm + ", nm=" + nm
				+ ", tx=" + tx + ", phone=" + phone + ", email=" + email + ", tjsj=" + tjsj + ", ggsj=" + ggsj + ", xb="
				+ xb + ", bjid=" + bjid + ", js=" + js + ", yhzt=" + yhzt + ", lsskbid=" + lsskbid + ", jsxgr=" + jsxgr
				+ ", jsxgrq=" + jsxgrq + ", njmc=" + njmc + ", xi=" + xi + ", zymc=" + zymc + ", bjmc=" + bjmc + "]";
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getNjmc() {
		return njmc;
	}
	public void setNjmc(String njmc) {
		this.njmc = njmc;
	}
	public String getXi() {
		return xi;
	}
	public void setXi(String xi) {
		this.xi = xi;
	}
	public String getZymc() {
		return zymc;
	}
	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	public String getBjmc() {
		return bjmc;
	}
	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJsid() {
		return jsid;
	}
	public void setJsid(int jsid) {
		this.jsid = jsid;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getZsxm() {
		return zsxm;
	}
	public void setZsxm(String zsxm) {
		this.zsxm = zsxm;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getGgsj() {
		return ggsj;
	}
	public void setGgsj(String ggsj) {
		this.ggsj = ggsj;
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
	public int getYhzt() {
		return yhzt;
	}
	public void setYhzt(int yhzt) {
		this.yhzt = yhzt;
	}
	public int getLsskbid() {
		return lsskbid;
	}
	public void setLsskbid(int lsskbid) {
		this.lsskbid = lsskbid;
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
