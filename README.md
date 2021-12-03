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

