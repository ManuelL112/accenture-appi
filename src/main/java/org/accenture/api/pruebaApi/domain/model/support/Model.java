package org.accenture.api.pruebaApi.domain.model.support;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Model<I extends Serializable> {

    private I id;
    
}
