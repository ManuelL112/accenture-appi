package org.accenture.api.pruebaApi.domain.model.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
