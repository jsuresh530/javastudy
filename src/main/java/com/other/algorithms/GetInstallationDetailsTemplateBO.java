package com.other.algorithms;
import java.io.Serializable;
import java.util.Calendar;
import java.util.concurrent.CopyOnWriteArrayList;


public class GetInstallationDetailsTemplateBO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -604987026304275775L;
	private String accountType;
	private int creditDebitBatchNumber = 0;
	private long debitSaleCount = 0;
	private long debitSaleVoidCount = 0;
	private long debitRefundCount = 0;
	private long debitRefundVoidCount = 0;

	private long creditSaleCount = 0;
	private long creditSaleVoidCount = 0;
	private long creditRefundCount = 0;
	private long creditRefundVoidCount = 0;

	private double debitSaleAmount;
	private double debitsaleVoidAmount;
	private double debitRefundAmount;
	private double debitRefundVoidAmount;
	private int plccTransNumber=1 ;
	private int plccBatchNumber=1 ;
	private int plccSeqNumber=1;
	private double plccSaleamount=0;
	private double plccSaleVoidAmount=0;
	private long plccSaleCount;
	private long plccSaleVoidCount;
	
	private double plccRefundAmount;
	private long plccRefundCount;
	
	private double debitPostauthAmount;
	private long debitPostauthCount;
	
	private double creditPostauthAmount;
	private long creditPostauthCount;
	
	private double creditSaleAmount;
	private double creditSaleVoidAmount;
	private double creditRefundAmount;
	private double creditRefundVoidAmount;
	
	private String debitTID;
	private String creditTID;
	private String plccCreditTid ;
	
	private Calendar lastBatchUploadDate;
	private String settlmentUploadTime;
	private boolean lastBatchUploadStatus;
	
	private String  lastTransactionReversal;
	private final String DB_ENCRYPTOR_KEY = "5UC355K3Yjjhnt2q2k4tlpalsjkfmnlw";
	
	private  CopyOnWriteArrayList<String> reversalDB;
	
	private  CopyOnWriteArrayList<String> ff_key_exchange_Alert ;
	private  CopyOnWriteArrayList<String> ff_host_cms_Alert ;
	private  CopyOnWriteArrayList<String> ff_duplicate_trns_Alert ;
	private  CopyOnWriteArrayList<String> ff_debit_trns_faied_Alert ;
	
	private  CopyOnWriteArrayList<String> ff_settlement_failed_Alert ;
	private  CopyOnWriteArrayList<String> ff_res_timeout_Alert ; 
	private  CopyOnWriteArrayList<String> ff_invalid_server_res_Alert ;
	private  CopyOnWriteArrayList<String> ff_pos_cms_fail_Alert ;
	private  CopyOnWriteArrayList<String> ff_heartbit_trns_Alert ;
	
	private  CopyOnWriteArrayList<String> failed_alert_store ;
	private  CopyOnWriteArrayList<String> failed_hb_alert_store ;
	
	private  boolean keyExcFailAlertSent;
	private  boolean posCctCmsFailedAlertSent;
	private  boolean hostCmsFailedAlert;
	private  boolean duplicateTransactionAlert;
	private  boolean debitTransFailed;
	private  boolean settlementFailed;
	private  boolean timeOutSent;
	private  boolean invServerResponse;

	private boolean isVegaInitialized;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getCreditDebitBatchNumber() {
		return creditDebitBatchNumber;
	}

	public void setCreditDebitBatchNumber(int creditDebitBatchNumber) {
		this.creditDebitBatchNumber = creditDebitBatchNumber;
	}

	public long getDebitSaleCount() {
		return debitSaleCount;
	}

	public void setDebitSaleCount(long debitSaleCount) {
		this.debitSaleCount = debitSaleCount;
	}

	public long getDebitSaleVoidCount() {
		return debitSaleVoidCount;
	}

	public void setDebitSaleVoidCount(long debitSaleVoidCount) {
		this.debitSaleVoidCount = debitSaleVoidCount;
	}

	public long getDebitRefundCount() {
		return debitRefundCount;
	}

	public void setDebitRefundCount(long debitRefundCount) {
		this.debitRefundCount = debitRefundCount;
	}

	public long getDebitRefundVoidCount() {
		return debitRefundVoidCount;
	}

	public void setDebitRefundVoidCount(long debitRefundVoidCount) {
		this.debitRefundVoidCount = debitRefundVoidCount;
	}

	public long getCreditSaleCount() {
		return creditSaleCount;
	}

	public void setCreditSaleCount(long creditSaleCount) {
		this.creditSaleCount = creditSaleCount;
	}

	public long getCreditSaleVoidCount() {
		return creditSaleVoidCount;
	}

	public void setCreditSaleVoidCount(long creditSaleVoidCount) {
		this.creditSaleVoidCount = creditSaleVoidCount;
	}

	public long getCreditRefundCount() {
		return creditRefundCount;
	}

	public void setCreditRefundCount(long creditRefundCount) {
		this.creditRefundCount = creditRefundCount;
	}

	public long getCreditRefundVoidCount() {
		return creditRefundVoidCount;
	}

	public void setCreditRefundVoidCount(long creditRefundVoidCount) {
		this.creditRefundVoidCount = creditRefundVoidCount;
	}

	public double getDebitSaleAmount() {
		return debitSaleAmount;
	}

	public void setDebitSaleAmount(double debitSaleAmount) {
		this.debitSaleAmount = debitSaleAmount;
	}

	public double getDebitsaleVoidAmount() {
		return debitsaleVoidAmount;
	}

	public void setDebitsaleVoidAmount(double debitsaleVoidAmount) {
		this.debitsaleVoidAmount = debitsaleVoidAmount;
	}

	public double getDebitRefundAmount() {
		return debitRefundAmount;
	}

	public void setDebitRefundAmount(double debitRefundAmount) {
		this.debitRefundAmount = debitRefundAmount;
	}

	public double getDebitRefundVoidAmount() {
		return debitRefundVoidAmount;
	}

	public void setDebitRefundVoidAmount(double debitRefundVoidAmount) {
		this.debitRefundVoidAmount = debitRefundVoidAmount;
	}

	public int getPlccTransNumber() {
		return plccTransNumber;
	}

	public void setPlccTransNumber(int plccTransNumber) {
		this.plccTransNumber = plccTransNumber;
	}

	public int getPlccBatchNumber() {
		return plccBatchNumber;
	}

	public void setPlccBatchNumber(int plccBatchNumber) {
		this.plccBatchNumber = plccBatchNumber;
	}

	public int getPlccSeqNumber() {
		return plccSeqNumber;
	}

	public void setPlccSeqNumber(int plccSeqNumber) {
		this.plccSeqNumber = plccSeqNumber;
	}

	public double getPlccSaleamount() {
		return plccSaleamount;
	}

	public void setPlccSaleamount(double plccSaleamount) {
		this.plccSaleamount = plccSaleamount;
	}

	public double getPlccSaleVoidAmount() {
		return plccSaleVoidAmount;
	}

	public void setPlccSaleVoidAmount(double plccSaleVoidAmount) {
		this.plccSaleVoidAmount = plccSaleVoidAmount;
	}

	public long getPlccSaleCount() {
		return plccSaleCount;
	}

	public void setPlccSaleCount(long plccSaleCount) {
		this.plccSaleCount = plccSaleCount;
	}

	public long getPlccSaleVoidCount() {
		return plccSaleVoidCount;
	}

	public void setPlccSaleVoidCount(long plccSaleVoidCount) {
		this.plccSaleVoidCount = plccSaleVoidCount;
	}

	public double getPlccRefundAmount() {
		return plccRefundAmount;
	}

	public void setPlccRefundAmount(double plccRefundAmount) {
		this.plccRefundAmount = plccRefundAmount;
	}

	public long getPlccRefundCount() {
		return plccRefundCount;
	}

	public void setPlccRefundCount(long plccRefundCount) {
		this.plccRefundCount = plccRefundCount;
	}

	public double getDebitPostauthAmount() {
		return debitPostauthAmount;
	}

	public void setDebitPostauthAmount(double debitPostauthAmount) {
		this.debitPostauthAmount = debitPostauthAmount;
	}

	public long getDebitPostauthCount() {
		return debitPostauthCount;
	}

	public void setDebitPostauthCount(long debitPostauthCount) {
		this.debitPostauthCount = debitPostauthCount;
	}

	public double getCreditPostauthAmount() {
		return creditPostauthAmount;
	}

	public void setCreditPostauthAmount(double creditPostauthAmount) {
		this.creditPostauthAmount = creditPostauthAmount;
	}

	public long getCreditPostauthCount() {
		return creditPostauthCount;
	}

	public void setCreditPostauthCount(long creditPostauthCount) {
		this.creditPostauthCount = creditPostauthCount;
	}

	public double getCreditSaleAmount() {
		return creditSaleAmount;
	}

	public void setCreditSaleAmount(double creditSaleAmount) {
		this.creditSaleAmount = creditSaleAmount;
	}

	public double getCreditSaleVoidAmount() {
		return creditSaleVoidAmount;
	}

	public void setCreditSaleVoidAmount(double creditSaleVoidAmount) {
		this.creditSaleVoidAmount = creditSaleVoidAmount;
	}

	public double getCreditRefundAmount() {
		return creditRefundAmount;
	}

	public void setCreditRefundAmount(double creditRefundAmount) {
		this.creditRefundAmount = creditRefundAmount;
	}

	public double getCreditRefundVoidAmount() {
		return creditRefundVoidAmount;
	}

	public void setCreditRefundVoidAmount(double creditRefundVoidAmount) {
		this.creditRefundVoidAmount = creditRefundVoidAmount;
	}

	public String getDebitTID() {
		return debitTID;
	}

	public void setDebitTID(String debitTID) {
		this.debitTID = debitTID;
	}

	public String getCreditTID() {
		return creditTID;
	}

	public void setCreditTID(String creditTID) {
		this.creditTID = creditTID;
	}

	public String getPlccCreditTid() {
		return plccCreditTid;
	}

	public void setPlccCreditTid(String plccCreditTid) {
		this.plccCreditTid = plccCreditTid;
	}

	public Calendar getLastBatchUploadDate() {
		return lastBatchUploadDate;
	}

	public void setLastBatchUploadDate(Calendar lastBatchUploadDate) {
		this.lastBatchUploadDate = lastBatchUploadDate;
	}

	public String getSettlmentUploadTime() {
		return settlmentUploadTime;
	}

	public void setSettlmentUploadTime(String settlmentUploadTime) {
		this.settlmentUploadTime = settlmentUploadTime;
	}

	public boolean isLastBatchUploadStatus() {
		return lastBatchUploadStatus;
	}

	public void setLastBatchUploadStatus(boolean lastBatchUploadStatus) {
		this.lastBatchUploadStatus = lastBatchUploadStatus;
	}

	public String getLastTransactionReversal() {
		return lastTransactionReversal;
	}

	public void setLastTransactionReversal(String lastTransactionReversal) {
		this.lastTransactionReversal = lastTransactionReversal;
	}

	public CopyOnWriteArrayList<String> getReversalDB() {
		return reversalDB;
	}

	public void setReversalDB(CopyOnWriteArrayList<String> reversalDB) {
		this.reversalDB = reversalDB;
	}

	public CopyOnWriteArrayList<String> getFf_key_exchange_Alert() {
		return ff_key_exchange_Alert;
	}

	public void setFf_key_exchange_Alert(
			CopyOnWriteArrayList<String> ff_key_exchange_Alert) {
		this.ff_key_exchange_Alert = ff_key_exchange_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_host_cms_Alert() {
		return ff_host_cms_Alert;
	}

	public void setFf_host_cms_Alert(CopyOnWriteArrayList<String> ff_host_cms_Alert) {
		this.ff_host_cms_Alert = ff_host_cms_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_duplicate_trns_Alert() {
		return ff_duplicate_trns_Alert;
	}

	public void setFf_duplicate_trns_Alert(
			CopyOnWriteArrayList<String> ff_duplicate_trns_Alert) {
		this.ff_duplicate_trns_Alert = ff_duplicate_trns_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_debit_trns_faied_Alert() {
		return ff_debit_trns_faied_Alert;
	}

	public void setFf_debit_trns_faied_Alert(
			CopyOnWriteArrayList<String> ff_debit_trns_faied_Alert) {
		this.ff_debit_trns_faied_Alert = ff_debit_trns_faied_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_settlement_failed_Alert() {
		return ff_settlement_failed_Alert;
	}

	public void setFf_settlement_failed_Alert(
			CopyOnWriteArrayList<String> ff_settlement_failed_Alert) {
		this.ff_settlement_failed_Alert = ff_settlement_failed_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_res_timeout_Alert() {
		return ff_res_timeout_Alert;
	}

	public void setFf_res_timeout_Alert(
			CopyOnWriteArrayList<String> ff_res_timeout_Alert) {
		this.ff_res_timeout_Alert = ff_res_timeout_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_invalid_server_res_Alert() {
		return ff_invalid_server_res_Alert;
	}

	public void setFf_invalid_server_res_Alert(
			CopyOnWriteArrayList<String> ff_invalid_server_res_Alert) {
		this.ff_invalid_server_res_Alert = ff_invalid_server_res_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_pos_cms_fail_Alert() {
		return ff_pos_cms_fail_Alert;
	}

	public void setFf_pos_cms_fail_Alert(
			CopyOnWriteArrayList<String> ff_pos_cms_fail_Alert) {
		this.ff_pos_cms_fail_Alert = ff_pos_cms_fail_Alert;
	}

	public CopyOnWriteArrayList<String> getFf_heartbit_trns_Alert() {
		return ff_heartbit_trns_Alert;
	}

	public void setFf_heartbit_trns_Alert(
			CopyOnWriteArrayList<String> ff_heartbit_trns_Alert) {
		this.ff_heartbit_trns_Alert = ff_heartbit_trns_Alert;
	}

	public CopyOnWriteArrayList<String> getFailed_alert_store() {
		return failed_alert_store;
	}

	public void setFailed_alert_store(
			CopyOnWriteArrayList<String> failed_alert_store) {
		this.failed_alert_store = failed_alert_store;
	}

	public CopyOnWriteArrayList<String> getFailed_hb_alert_store() {
		return failed_hb_alert_store;
	}

	public void setFailed_hb_alert_store(
			CopyOnWriteArrayList<String> failed_hb_alert_store) {
		this.failed_hb_alert_store = failed_hb_alert_store;
	}

	public boolean isKeyExcFailAlertSent() {
		return keyExcFailAlertSent;
	}

	public void setKeyExcFailAlertSent(boolean keyExcFailAlertSent) {
		this.keyExcFailAlertSent = keyExcFailAlertSent;
	}

	public boolean isPosCctCmsFailedAlertSent() {
		return posCctCmsFailedAlertSent;
	}

	public void setPosCctCmsFailedAlertSent(boolean posCctCmsFailedAlertSent) {
		this.posCctCmsFailedAlertSent = posCctCmsFailedAlertSent;
	}

	public boolean isHostCmsFailedAlert() {
		return hostCmsFailedAlert;
	}

	public void setHostCmsFailedAlert(boolean hostCmsFailedAlert) {
		this.hostCmsFailedAlert = hostCmsFailedAlert;
	}

	public boolean isDuplicateTransactionAlert() {
		return duplicateTransactionAlert;
	}

	public void setDuplicateTransactionAlert(boolean duplicateTransactionAlert) {
		this.duplicateTransactionAlert = duplicateTransactionAlert;
	}

	public boolean isDebitTransFailed() {
		return debitTransFailed;
	}

	public void setDebitTransFailed(boolean debitTransFailed) {
		this.debitTransFailed = debitTransFailed;
	}

	public boolean isSettlementFailed() {
		return settlementFailed;
	}

	public void setSettlementFailed(boolean settlementFailed) {
		this.settlementFailed = settlementFailed;
	}

	public boolean isTimeOutSent() {
		return timeOutSent;
	}

	public void setTimeOutSent(boolean timeOutSent) {
		this.timeOutSent = timeOutSent;
	}

	public boolean isInvServerResponse() {
		return invServerResponse;
	}

	public void setInvServerResponse(boolean invServerResponse) {
		this.invServerResponse = invServerResponse;
	}

	public boolean isVegaInitialized() {
		return isVegaInitialized;
	}

	public void setVegaInitialized(boolean isVegaInitialized) {
		this.isVegaInitialized = isVegaInitialized;
	}

	public String getDB_ENCRYPTOR_KEY() {
		return DB_ENCRYPTOR_KEY;
	}
	
}
