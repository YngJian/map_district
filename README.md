# amap-district-data 
 
#### 项目介绍 
根据高德地图行政区域查询API获取最新的所有的行政区域数据，用于省市区街道级联查询  
高德地图行政区域查询 - [http://lbs.amap.com/api/webservice/guide/api/district](http://lbs.amap.com/api/webservice/guide/api/district) 
 
本项目基于高德地图行政区域查询API, 由于高德地图行政区域查询API有调用次数和并发数量限制，故将行政区域数据保存在数据库中，需要时从本地数据查询获取。 
目前部分城市和省直辖县因为没有区县的概念，故在市级下方直接显示街道。例如：广东-东莞、海南-文昌市。 
 
#### application.yml配置说明 
1. 修改数据库配置：spring.datasource 
2. 修改高德地图WebApi key：amap.key 

#### 使用说明 
生成方式： 
运行com.tooldin.amapdistrictsdata.AmapDistrictsDataApplication，即可将高德地图的行政区域保存到指定的数据库中。 

查询SQL： 
1. 查询所有省 
``` 
select * from amap_district where `level` = 'province';
``` 

2. 查询广东省下面的行政区域 
``` 
select * from amap_district where parent_id = 102688;
``` 

3. 查询广东省东莞市下面的行政区域 
``` 
select * from amap_district where parent_id = 104228;
``` 

#### 注意事项  
以下district可以根据需要是否保留  
澳门大学横琴校区(由澳门管辖)  