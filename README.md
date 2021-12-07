# 1。 工程集成引入

## 集成网关引入

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-gateway-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/>
</parent>
```

## 集成SpringBoot工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## 集成微服务web工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-web-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## 集成微服务plus-web工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-web-plus-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## 集成微服务父工程

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-cloud-parent</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## 集成消息SDK

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-sdk-message</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

# 2. 插件集成引入

## Mybatis-Plus插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-mybatis-plus</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## Swagger插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-swagger</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## Redis插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-data-redis</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## ES插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-data-elasticsearch</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## MQ插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-rocketmq</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## kafka插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-kafka</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## Email插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-email</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

## XXL-JOB插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-job</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```
## 云存储服务 插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-storage</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```
## 短信插件集成

```xml

<parent>
    <groupId>com.axue.framework</groupId>
    <artifactId>axue-framework-boot-plugin-sms</artifactId>
    <version>1.0.0</version>
    <relativePath/><!-- 父工程相对路径写空,就可以强制到maven私服去找,不然默认是到上一层目录去找父程,那就会找不到 -->
</parent>
```

