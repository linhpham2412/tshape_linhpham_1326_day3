package nt.tshape;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfo {
    private String emailID;
    private String password;
    private String customerName;
    private Boolean isCustomerMale;
    private Date customerDateOfBirth;
    private String customerAddress;
    private String customerCity;
    private String customerState;
    private String customerPIN;
    private String customerMobileNo;
    private String customerEmail;
    private String customerPassword;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();


    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    public String getCustomerDateOfBirth(String datePattern) throws ParseException {
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(customerDateOfBirth);
    }

    public int compareWithExpectedDOBReturnZeroIfMatched(String actualDOB, String datePattern) throws ParseException {
        simpleDateFormat.applyPattern(datePattern);
        Date actualDate = simpleDateFormat.parse(actualDOB);
        return customerDateOfBirth.compareTo(actualDate);
    }
    public void setCustomerDateOfBirth(String dateOfBirth, String datePattern) throws ParseException {
        simpleDateFormat.applyPattern(datePattern);
        this.customerDateOfBirth = simpleDateFormat.parse(dateOfBirth);
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerPIN() {
        return customerPIN;
    }

    public void setCustomerPIN(String customerPIN) {
        this.customerPIN = customerPIN;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Boolean getIsCustomerMale() {
        return isCustomerMale;
    }

    public void setIsCustomerMale(Boolean customerMale) {
        isCustomerMale = customerMale;
    }
}
