package com.billionairestore.logservice.commands.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class DateTimeModel {
    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("client_ip")
    private String clientIp;

    @JsonProperty("datetime")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    private String datetime;

    @JsonProperty("day_of_week")
    private int dayOfWeek;

    @JsonProperty("day_of_year")
    private int dayOfYear;

    @JsonProperty("dst")
    private boolean dst;

    @JsonProperty("dst_from")
    private Object dstFrom;

    @JsonProperty("dst_offset")
    private int dstOffset;

    @JsonProperty("dst_until")
    private Object dstUntil;

    @JsonProperty("raw_offset")
    private int rawOffset;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("unixtime")
    private long unixtime;

    @JsonProperty("utc_datetime")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX")
    private String utcDatetime;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("week_number")
    private int weekNumber;
}
