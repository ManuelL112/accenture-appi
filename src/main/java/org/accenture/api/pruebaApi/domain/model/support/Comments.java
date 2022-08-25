package org.accenture.api.pruebaApi.domain.model.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments {

    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;

}
