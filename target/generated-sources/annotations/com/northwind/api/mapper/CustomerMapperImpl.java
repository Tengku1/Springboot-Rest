package com.northwind.api.mapper;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.dto.CustomerDto;
import com.northwind.api.entities.Category;
import com.northwind.api.entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T05:11:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto map(Category category) {
        if ( category == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    @Override
    public Customer map(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }

    @Override
    public List<CustomerDto> map(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( customerToCustomerDto( customer ) );
        }

        return list;
    }

    protected CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId( customer.getCustomerId() );
        customerDto.setCompanyName( customer.getCompanyName() );
        customerDto.setContactName( customer.getContactName() );
        customerDto.setContactTitle( customer.getContactTitle() );
        customerDto.setAddress( customer.getAddress() );
        customerDto.setCity( customer.getCity() );
        customerDto.setCountry( customer.getCountry() );

        return customerDto;
    }
}
