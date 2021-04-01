package com.controllers;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuqian
 * @date 2018/10/28 19:00.
 */
@RestController
public class HelloController {

  @GetMapping({"/", "hello"})
  public String hello(
    @RequestParam(value = "name", required = false) String name
  ) {
    if (StringUtils.isEmpty(name)) {
      name = "Java 11 ";
    }
    var prefix = "Hello, ";
    var postfix = " !";
    return prefix + name + postfix;
  }
}
