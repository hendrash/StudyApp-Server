package com.StudyGuide.StudyGuide.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;

public final class HeaderUtil {
public static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);
private HeaderUtil(){}

public static HttpHeaders createAlert(String messageDetail, String messageHeader){
    HttpHeaders headers= new HttpHeaders();
    headers.add("X-HOA-messageDetail",messageDetail);
    headers.add("X-HOA-messageHeader", messageHeader);
    return headers;
}
public static HttpHeaders createEntityDeletionAlert(String entityName, String messageHeader){
    return createAlert("The"+entityName+"record has been deleted ", messageHeader);
}
public static HttpHeaders createEntityUpdateAlert(String entityName, String messageHeader){
    return createAlert("the "+entityName+" record has been updated",messageHeader);
}
}
