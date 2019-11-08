package com.dzf.zxkj.platform.model.tax.jiangsutaxrpt.taxrequest.incometax.a;

import com.dzf.zxkj.platform.model.tax.jiangsutaxrpt.taxrequest.TaxExcelPos;

@TaxExcelPos(reportID = "10412001", reportname = "A200000所得税月(季)度预缴纳税申报表")
public class IncomeTaxAgent {
	@TaxExcelPos(row = 38, col = 2)
	private String sfdlsb;
	@TaxExcelPos(row = 38, col = 6)
	private String dlrmc;
	@TaxExcelPos(row = 39, col = 2, splitIndex = 0)
	private String dlrsfzjzldm;
	@TaxExcelPos(row = 39, col = 2, splitIndex = 1)
	private String dlrsfzjzlmc;
	@TaxExcelPos(row = 39, col = 6)
	private String dlrsfzjhm;

	public String getDlrsfzjzlmc() {
		return dlrsfzjzlmc;
	}

	public void setDlrsfzjzlmc(String dlrsfzjzlmc) {
		this.dlrsfzjzlmc = dlrsfzjzlmc;
	}

	public String getDlrsfzjzldm() {
		return dlrsfzjzldm;
	}

	public void setDlrsfzjzldm(String dlrsfzjzldm) {
		this.dlrsfzjzldm = dlrsfzjzldm;
	}

	public String getDlrsfzjhm() {
		return dlrsfzjhm;
	}

	public void setDlrsfzjhm(String dlrsfzjhm) {
		this.dlrsfzjhm = dlrsfzjhm;
	}

	public String getSfdlsb() {
		return sfdlsb == null ? "N" : sfdlsb;
	}

	public void setSfdlsb(String sfdlsb) {
		if ("是".equals(sfdlsb)) {
			sfdlsb = "Y";
		} else if ("否".equals(sfdlsb)) {
			sfdlsb = "N";
		}
		this.sfdlsb = sfdlsb;
	}

	public String getDlrmc() {
		return dlrmc;
	}

	public void setDlrmc(String dlrmc) {
		this.dlrmc = dlrmc;
	}

}
