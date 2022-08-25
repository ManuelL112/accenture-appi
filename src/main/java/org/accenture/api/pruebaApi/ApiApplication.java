package org.accenture.api.pruebaApi;

import org.accenture.api.pruebaApi.domain.model.support.Album;
import org.accenture.api.pruebaApi.domain.model.support.Comments;
import org.accenture.api.pruebaApi.domain.model.support.Photo;
import org.accenture.api.pruebaApi.domain.model.support.Post;
import org.accenture.api.pruebaApi.domain.model.support.User;
import org.accenture.api.pruebaApi.gateway.AccentureGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ApiApplication {

    @Autowired
    private AccentureGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public List<Photo> getPhotos() {
        return gateway.listPhotos();
    }

    @Bean
    public List<Album> getAlbums() {
        return gateway.listAlbums();
    }

    @Bean
    public List<User> getUsers() {
        return gateway.listUsers();
    }

    @Bean
    public List<Post> getPosts() {
        return gateway.listPost();
    }

    @Bean
    public List<Comments> getComments() {
        return gateway.listComments();
    }
}
