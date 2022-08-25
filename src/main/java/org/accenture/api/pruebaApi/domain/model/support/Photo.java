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
public class Photo {

    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

}
