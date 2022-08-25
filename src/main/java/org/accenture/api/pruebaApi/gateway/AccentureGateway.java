package org.accenture.api.pruebaApi.gateway;


import org.accenture.api.pruebaApi.domain.model.support.Album;
import org.accenture.api.pruebaApi.domain.model.support.Comments;
import org.accenture.api.pruebaApi.domain.model.support.Photo;
import org.accenture.api.pruebaApi.domain.model.support.Post;
import org.accenture.api.pruebaApi.domain.model.support.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author carlos.montoya@zabud.com.co
 * @version 1.0
 */
@FeignClient(name = "AccentureApi",
        url = "${accenture.api.url}")
public interface AccentureGateway {


    @GetMapping("/users")
    List<User> listUsers();

    @GetMapping("/posts")
    List<Post> listPost();

    @GetMapping("/albums")
    List<Album> listAlbums();

    @GetMapping("/photos")
    List<Photo> listPhotos();

    @GetMapping("/comments")
    List<Comments> listComments();
}
