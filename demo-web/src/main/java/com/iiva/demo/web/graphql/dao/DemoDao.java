package com.iiva.demo.web.graphql.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iiva.demo.web.graphql.entity.Advertisement;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.entity.Category;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoDao {

    @Select("select * from category")
    List<Category> getAllCategories();

    @Select("select * from book where id = #{id}")
    Book getBookById(Integer id);

    @Select("select * from author where id = #{id}")
    Author getAuthorById(Integer id);

    @Select("<script>"
            + "select * from book where id in "
                + "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
                    + "#{item}"
                + "</foreach>"
            + "</script>")
    List<Book> getBooksByIds(@Param("ids")List<Integer> ids);

    @Select("select * from book where category_id = #{categoryId}")
    List<Book> getBooksByCategoryId(Integer categoryId);

    @Select("select * from book where author_id = #{authorId}")
    List<Book> getBooksByAuthorId(Integer authorId);

    @Select("select * from advertisement where type = #{type} order by publish_time desc limit #{limit}")
    List<Advertisement> getAdvertisementsByTypeLatest(String type, Integer limit);

    @Insert("insert into author values(null,#{name})")
    Integer addAuthor(AddAuthorRequest addAuthorRequest);

    @Select("select * from book")
    List<Book> getBooksByPage(Page<Book> pageBooks);
}
