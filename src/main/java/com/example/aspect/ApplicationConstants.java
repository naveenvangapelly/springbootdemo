package com.example.aspect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class ApplicationConstants {

    public static final String       ACCOUNTHOLDERID                 = "accountHolderId";
    public static final String       ACCOUNTID                       = "accountId";
    public static final String       ACCOUNTHOLDER                   = "ACCOUNTHOLDER";
    public static final String       BENEFACTOR                      = "BENEFACTOR";
    public static final String       TRANSACTIONCREDIT               = "Cr";
    public static final String       TRANSACTIONDEBIT                = "Dr";
    public static final String       TRANSACTIONCURRENCYCODENUMERIC  = "840";
    public static final String       TRANSACTIONCURRENCYCODEALPHA3   = "USD";
    public static final String       TRANSACTIONTYPECODE             = "INWORK";
    public static final int          LOADAMOUNTMIN                   = 2;
    public static final int          LOADAMOUNTMAX                   = 500;
    public static final int          DISPLAYORDERGROUP               = 1;
    public static final String       AVAILABLEBALANCE_ZERO           = "0";

    public static final String       ACCOUNTTYPE_PTS                 = "PTS";
    public static final String       ACCOUNTTYPE_POINT               = "POINT";
    public static final String       ACCOUNTTYPE_UNIT                = "UNIT";
    public static final double       BALANCE                         = 123.45;
    public static final String       QUERYPARAM_ACCOUNTTYPE          = "accountType";
    public static final String       QUERYPARAM_PLANNAME             = "name";
    public static final List<String> ALLOWEDQUERYPARAMLIST           = Collections
            .unmodifiableList(Arrays.asList("accountType", "name"));
    public static final List<String> QUERYPARAM_ACCOUNTTYPEVALUELIST = Collections
            .unmodifiableList(Arrays.asList("point", "unit"));
    public static final String       LOGMESSAGE                      = "(*LOG*)";
    public static final String       BEFORERUNNINGCLASS              = " Before running, Interface/Class intercepted is :  ";
    public static final String       BEFORERUNNINGMETHOD             = " Before running, Method intercepted is : ";
    public static final String       METHODARGS                      = " Arguments passed to method : ";
    public static final String       AFTERRUNNINGCLASS               = " After running, Interface/Class is :  ";
    public static final String       AFTERRUNNINGMETHOD              = " After running, Method is : ";
    public static final String       AFTERRETURNVALUE                = " After returning, the return value is : ";
    public static final List<Locale> LOCALES                         = Arrays.asList(new Locale("en"), new Locale("es"),
            new Locale("fr"), new Locale("es", "MX"), new Locale("en", "GB"), new Locale("zh"), new Locale("ja"));

    private ApplicationConstants() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}
