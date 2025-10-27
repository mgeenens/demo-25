package com.example.hmrback.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseController.BASE_PATH)
public abstract class BaseController {
    public static final String BASE_PATH = "/hmr/api";
}
