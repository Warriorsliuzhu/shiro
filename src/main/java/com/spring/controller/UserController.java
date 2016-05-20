package com.spring.controller;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class UserController {
    private final String _pagePath = "index.ftl";

//    @RequestMapping("")
//    public String index(Model model) {
//        System.out.println("----------------------");
//        model.addAttribute("test", "渴望光荣");
//
//        model.addAttribute("_pagePath", _pagePath);
//        return "layout";
//
//    }

    @RequestMapping(value = "cache")
    public String manageView(Model model) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class,
                                ResourcePoolsBuilder.heap(100))
                                .build())
                .build(true);

        Cache<String, String> preConfigured
                = cacheManager.getCache("preConfigured", String.class, String.class);

        Cache<String, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class,
                        ResourcePoolsBuilder.heap(100)).build());

        myCache.put("test", "da one!");
        String value = myCache.get("test");
        System.out.println(value);
        cacheManager.close();
        return "";
    }




}
