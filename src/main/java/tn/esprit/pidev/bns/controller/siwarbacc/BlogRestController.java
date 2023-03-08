package tn.esprit.pidev.bns.controller.siwarbacc;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwarbacc.Blog;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.IBlogService;

import java.util.List;
@SpringBootApplication

@RestController
@AllArgsConstructor
@RequestMapping("/Blog")
@Tag(name = "Blogs Docs")
public class BlogRestController {
@Autowired
    IBlogService blogService;
    @Operation(description = "Get All blogs")
@GetMapping("/retrieve-all-Blogs")
public List<Blog> getBlogs() {
    List<Blog> listBlogs = blogService.retrieveAllBlogs();
    return listBlogs;
}
    @Operation(description = "retrieve blogs")
@GetMapping("/retrieve-bLog/{id}")
    public Blog retrieveBlog(@PathVariable("id") Integer Id){
    return blogService.retrieveBlog(Id);
}
    @Operation(description = "Add blogs")
@PostMapping("/add-Blog")
    public Blog addBlog (@RequestBody Blog b) {
    Blog blog = blogService.addBlog(b);
    return blog;

}
    @Operation(description = "Delete blogs")
@DeleteMapping("/remove-Blog/{blog-id}")
public void removeBlog(@PathVariable("blog-id") Integer Id) {blogService.removeBlog(Id);}
    @Operation(description = "Update blogs")
    @PutMapping("/update-Blog")
    public Blog updateBlog(@RequestBody Blog b) {
    Blog blog= blogService.updateBlog(b);
    return blog;

    }
   // @GetMapping("/{field}")
    //private ApiResponse <List<Blog>> getBlogswithSort(@PathVariable String field){
       //List<Blog> allBlogs = blogService.findBlogsWithSorting(field);
        //return new ApiResponsE<>(allBlogs.size(), allBlogs);
   // }

   //@GetMapping
    //private ApiResponse<List<Blog>> getBlogs() {
      // List<Blog> allBlogs = blogService.findAllBlogs();
       // return new APIResponse<>(allBlogs.size(), allBlogs);
 // }
    //@GetMapping("/{field}")
   // private APIResponse<List<Blog>> getBlogsWithSort(@PathVariable String field) {
      //  List<Blog> allBlogs = blogService.findBlogsWithSorting(field);
        //return new APIResponse<>(allBlogs.size(), allBlogs);
    //}

   // @GetMapping("/pagination/{offset}/{pageSize}")
   // private APIResponse<Page<Blog>> getBlogsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
       // Page<Blog> blogsWithPagination = blogService.findBlogsWithPagination(offset, pageSize);
       // return new APIResponse<>(blogsWithPagination.getSize(), blogsWithPagination);
   //}
}
