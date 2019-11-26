## lunchDemo（外卖订餐）

# 技术：
1.基于SpringBoot和SpringCloud实现的微服务架构；
2.使用Feign作为消息中间件实现服务调用；
3.使用Filter完成对未登录访问信息的拦截；
3.使用mysql5数据库；

# 项目用时：
2天

# 项目架构
lunchDemo分为前台后台系统，前台主要为消费者使用，功能有查看菜品，订购，查看订单状态，退出登录；后台为管理员使用，功能有查看订单，更改订单状态，添加/删除菜品，退出登录，（添加删除用户/管理员未实现，方法大同）
            
1.项目由七个微服务注册：分别为Eureka注册中心，client服务调用者，configServer配置中心，及四个底层的服务提供者
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/%E9%A1%B9%E7%9B%AE%E6%9E%84%E6%9E%B6.png)
2.使用表格
项目会使用到5张表，user表储存消费者，Admin表储存管理员，menu表储存菜单，order表储存订单，type表储存菜的类型，主要是在前端的修改的下拉框中使用，所以这个表的改动比较少
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/address%E8%A1%A8.jpg)
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/admin%E8%A1%A8.jpg)
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/menu%E8%A1%A8.jpg)
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/order%E8%A1%A8.jpg)
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/type%E8%A1%A8.jpg)

3.消费者
查看菜品/订购/查看本人订单/退出登录
![描述](https://github.com/chew1983/lunchDemo/blob/master/images/%E7%94%A8%E6%88%B7%E8%AE%A2%E8%B4%AD.gif?raw=true)
4.管理员
查看订单，更改订单状态，添加/删除菜品，退出登录
![描述](https://raw.githubusercontent.com/chew1983/lunchDemo/master/images/%E7%AE%A1%E7%90%86%E5%91%98.gif)
