package com.example.warehouse.system.mapper;

import org.springframework.stereotype.Component;

import com.example.warehouse.system.entity.Address;
import com.example.warehouse.system.requestdto.AddressRequest;
import com.example.warehouse.system.responsedto.AddressResponse;

@Component
public class AddressMapper {

    public Address mapToAddress(AddressRequest addressRequest, Address address) {
        address.setAddressLine(addressRequest.getAddressLine());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setCountry(addressRequest.getCountry());
        address.setPincode(addressRequest.getPincode());
        address.setLongitude(addressRequest.getLongitude());
        address.setLatitude(addressRequest.getLatitude());
        return address;
    }

    public AddressResponse mapToAddressResponse(Address address) {
        return AddressResponse.builder()
                .addressId(address.getAddressId())
                .addressLine(address.getAddressLine())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .longitude(address.getLongitude())
                .latitude(address.getLatitude())
                .build();
    }
}
