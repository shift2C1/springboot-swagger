package com.pipichao.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
public class Test {

/** paramType: 几种参数类型
 * //    Valid values are {@code path}, {@code query}, {@code body}, {@code header} or {@code form}.
 * */

    /**
     * post请求 ：从请求体中获取数据
     * */

    @ApiOperation(value = "post 请求的数据",notes = "哈哈哈")
    @ApiImplicitParams(
            {
//                    @ApiImplicitParam(name = "id",value = "用户id",dataType = "string",paramType = "query")
//                    @ApiImplicitParam(name = "name",value = "用户名字",paramType = "body")
//                    ,@ApiImplicitParam(name = "id",value = "用户id",dataType = "string",paramType = "body")
            }
    )
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String test( @RequestBody User user){
        System.out.println(user.toString());
        return user.toString();
    }


    /**
     * get请求：路径拼接参数
     * */
    @ApiOperation(value = "get方法",notes = "test get 方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",paramType = "query")
            , @ApiImplicitParam(name = "username",value = "用户名字",paramType = "query")
    })
    @GetMapping("/get")
    public String test1(@RequestParam("id")String userId,@RequestParam("username")String name){
        return "success:"+userId+":"+name;
    }

    /**
     * post请求：从表单获取数据
     * */
    @ApiOperation("获取form数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "表单数据",paramType = "form")
    })
    @PostMapping("/form")
    public String form(@RequestParam("id")String id){
        return id;
    }

    /**
     * 任何请求：从请求头获取数据
     * */
    @ApiOperation("获取请求头的数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token",value = "token 令牌",paramType = "header")
    })
    @GetMapping("/headers")
    public String getHeaders(@RequestHeader("token")String token){
        return "success:"+token;
    }

    /**
     * get 请求：rest 交互风格 路径参数
     * */
    @ApiOperation("rest path 参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "用户id",paramType = "path")
    })
    @GetMapping("/path/{id}")
    public String path(@PathVariable("id")String id){
        return "success:"+id;
    }


}
