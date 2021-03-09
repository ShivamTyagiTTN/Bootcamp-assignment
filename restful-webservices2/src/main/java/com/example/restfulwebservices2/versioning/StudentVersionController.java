package com.example.restfulwebservices2.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersionController {

    //MimeType Versioning
    @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v1+json")
    public StudentV1 produces1(){
        return new StudentV1("Shivam Tyagi");
    }
    @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v2+json")
    public StudentV2 produces2(){
        return new StudentV2(new Name("Shivam", "Tyagi"));
    }

    //Request Parameter versioning
    @GetMapping(value = "/student/param", params = "version=1")
    public StudentV1 param1(){
        return new StudentV1("Shivam Tyagi");
    }
    @GetMapping(value = "/student/param", params = "version=2")
    public StudentV2 param2(){
        return new StudentV2(new Name("Shivam", "Tyagi"));
    }

    //URI versioning
    @GetMapping("v1/student")
    public StudentV1 studentV1(){
        return new StudentV1("Shivam Tyagi");
    }
    @GetMapping("v2/student")
    public StudentV2 studentV2(){
        return new StudentV2(new Name("Shivam", "Tyagi"));
    }

    //Custom Header Versioning
    @GetMapping(value = "/student/header", headers = "X-API-VERSION=1")
    public StudentV1 header1(){
        return new StudentV1("Shivam Tyagi");
    }
    @GetMapping(value = "/student/header", headers = "X-API-VERSION=2")
    public StudentV2 header2(){
        return new StudentV2(new Name("Shivam", "Tyagi"));
    }
}
