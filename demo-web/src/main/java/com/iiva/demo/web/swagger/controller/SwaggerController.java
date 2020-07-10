package com.iiva.demo.web.swagger.controller;

import com.iiva.demo.web.swagger.entity.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
@Api(value = "电影Controller",tags = {"电影访问接口"})
@RequestMapping("/film")
public class SwaggerController {

    // Swagger Documnet Url : http://localhost:8080/demo/swagger-ui.html

    @GetMapping("/{id}")
    @ApiOperation("根据id查询电影的接口")
    @ApiImplicitParam(name = "id", value = "电影id", defaultValue = "99", required = true)
    public Film getFilmById(@PathVariable String id) {
        Film film = new Film();
        film.setId(id);
        film.setName("功夫之王");
        film.setDescription("成龙、李连杰");
        return film;
    }

}
