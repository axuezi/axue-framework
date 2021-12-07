# 项目说明

## 1. 项目结构
```yaml
.
├─ axue-framework-bom                     Framework Dependencies BOM
├─ axue-framework-boot
│  ├─ axue-framework-boot-parent          SpringBoot Parent 封装
│  └─ axue-framework-boot-plugins
│      ├─ axue-framework-boot-plugin-data-elasticsearch    Elasticsearch插件
│      ├─ axue-framework-boot-plugin-data-redis            Redis插件
│      ├─ axue-framework-boot-plugin-email                 Email插件
│      ├─ axue-framework-boot-plugin-job                   xxl-job插件
│      ├─ axue-framework-boot-plugin-kafka                 kafka插件
│      ├─ axue-framework-boot-plugin-mybatis-plus          Mybatis Plus插件
│      ├─ axue-framework-boot-plugin-rocketmq              rockermq插件
│      ├─ axue-framework-boot-plugin-sms                   短信插件
│      ├─ axue-framework-boot-plugin-storage               云存储插件
│      └─ axue-framework-boot-plugin-swagger               Swagger插件
├─ axue-framework-cache                     缓存框架
├─ axue-framework-cloud
│  ├─ axue-framework-cloud-gateway-parent          微服务gateway网关模块父工程 
│  ├─ axue-framework-cloud-parent                  微服务父工程
│  ├─ axue-framework-cloud-web-parent              微服务web项目父工程
│  └─ axue-framework-cloud-web-plus-parent         微服务web项目插件增强父工程
├─ axue-framework-common                           公共包
├─ axue-framework-demo                      样例工程
│  ├─ axue-framework-demo-microservice             微服务样例项目
│  └─ axue-framework-demo-monolithic               单体(巨石系统monolithic)样例项目
├─ axue-framework-mq                        消息队列框架
├─ axue-framework-orm                       orm框架
├─ axue-framework-rpc                       RPC远程调用框架
└─ axue-framework-sdk                       SDK封装
   ├─ axue-framework-sdk-core                      SDK 核心模块
   └─ axue-framework-sdk-message                   Message 消息中心SDK
```

## 2. 工程集成引入

### 集成网关引入

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-gateway-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/>
</parent>
```

### 集成SpringBoot工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### 集成微服务web工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-web-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### 集成微服务plus-web工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-web-plus-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### 集成微服务父工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### 集成消息SDK

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-sdk-message</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## 3. 插件集成引入

### Mybatis-Plus插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-mybatis-plus</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### Swagger插件集成

1. 引入pom文件

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-swagger</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

2. yaml配置

```yaml
axue:
  swagger:
    title: # 系统名称
    scan-package: # 扫包路径
```

### Redis插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-data-redis</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### ES插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-data-elasticsearch</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### MQ插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-rocketmq</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### kafka插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-kafka</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### Email插件集成

1. 引入pom文件

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-email</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

2. yaml配置

```yaml
email:
  mail-smtp-host: # smtp 主机host
  mail-smtp-username: # smtp 用户名
  mail-smtp-uassword: # smtp 密码
  site-name: # 站点名称
```

### XXL-JOB插件集成

1. 引入pom文件

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-job</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```
2. yaml配置

```yaml
xxl:
  job:
    admin:
      addresses: # 调度中心部署跟地址
    executor:
      appname: # 执行器AppName
      address: # 服务注册地址,优先使用该配置作为注册地址 为空时使用内嵌服务 ”IP:PORT“ 作为注册地址 从而更灵活的支持容器类型执行器动态IP和动态映射端口问题
      ip: # 执行器IP [选填]：默认为空表示自动获取IP，多网卡时可手动设置指定IP ，该IP不会绑定Host仅作为通讯实用；地址信息用于 "执行器注册" 和 "调度中心请求并触发任务"
      port: # 执行器端口号 [选填]：小于等于0则自动获取；默认端口为9998，单机部署多个执行器时，注意要配置不同执行器端口；
      accessToken: # 执行器通讯TOKEN [选填]：非空时启用；
      logPath: # 执行器运行日志文件存储磁盘路径 [选填] ：需要对该路径拥有读写权限；为空则使用默认路径；
      logRetentionDays: # 执行器日志保存天数 [选填] ：值大于3时生效，启用执行器Log文件定期清理功能，否则不生效；
```

### 云存储服务 插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-storage</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

### 短信插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-sms</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

