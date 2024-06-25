package com.jan.service.factory;

import com.jan.service.category.WebApiCategoryDataCollector;
import com.jan.service.product.DbProductDataCollector;
import com.jan.service.product.FileSystemProductDataCollector;
import com.jan.service.product.RSSProductDataCollector;
import com.jan.service.product.WebApiProductDataCollector;
import com.jan.service.user.WebApiUserDataCollector;

public class DataServiceFactory {
    public static DataServiceFactory productServiceFactory;
    private DataServiceFactory(){}
    public static DataServiceFactory getInstance(){
        if(productServiceFactory==null){
            productServiceFactory = new DataServiceFactory();
        }
        return productServiceFactory;
    }
    public WebApiProductDataCollector getWebApiProductDataCollector(String apiUrl){
        return new WebApiProductDataCollector(apiUrl);
    }
    public FileSystemProductDataCollector getFileSystemProductDataCollector(String fsUrl){
        return new FileSystemProductDataCollector(fsUrl);
    }
    public RSSProductDataCollector getRssProductDataCollector(String rssUrl){
        return new RSSProductDataCollector(rssUrl);
    }
    public DbProductDataCollector getDbProductDataCollector(String dbUrl){
        return new DbProductDataCollector(dbUrl);
    }
    public WebApiCategoryDataCollector getWebApiCategoryDataCollector(String apiUrl){
        return new WebApiCategoryDataCollector(apiUrl);
    }
    public WebApiUserDataCollector getWebApiUserDataCollector(String apiUrl){
        return new WebApiUserDataCollector(apiUrl);
    }
}
