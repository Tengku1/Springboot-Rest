package com.northwind.api.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CustomerDto {
    private String customerId;

    @Size(max = 40, message = "Company Name Length Exceeded")
    @NotBlank(message = "Company Name Cannot Be Null !")
    private String companyName;

    @Size(max = 30, message = "Contact Name Length Exceeded")
    private String contactName;

    @Size(max = 30, message = "Contact Title Length Exceeded")
    private String contactTitle;

    @Size(max = 60, message = "Address Length Exceeded")
    private String address;

    @Size(max = 15, message = "City Length Exceeded")
    private String city;

    @Size(max = 15, message = "Region Length Exceeded")
    private String region;

    @Size(max = 10, message = "Postal Code Length Exceeded")
    private String postalCode;

    @Size(max = 15, message = "Country Length Exceeded")
    private String country;

    @Size(max = 24, message = "Phone Length Exceeded")
    private String phone;

    @Size(max = 24, message = "Fax Length Exceeded")
    private String fax;
}
