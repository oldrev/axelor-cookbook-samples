# axelor-cookbook-samples

Axelor 教程代码范例仓库，本仓库保存“命叔杂技”视频专栏《Axelor 开发系列教程》的实例代码。

本项目的 `build.gradle` 中引用了作者提供的 Axelor 开发平台汉化版： 

https://github.com/axelor-l10n-cn 

请确保网络可以访问 GitHub 的内容，自己的项目可参考如何使用汉化版。

任何问题可进 QQ 群 1048161339 讨论。

# 视频教程在线观看：

* Youtube： https://www.youtube.com/watch?v=wegQWkt3vDg&list=PLlQK_EEIm_sWj-BvmcOcj8klPX2M96aF9
* Bilibili: https://space.bilibili.com/26188820/channel/detail?cid=103191
* 西瓜视频： https://www.ixigua.com/pseries/6791677568144638477

# 编译环境需求

* Java JDK8（必须 Java8）
* Gradle 6.0+（必须）
* Intellij IDEA（可选）

# 命令行编译运行

进入各个例子的目录，执行：

## Windows

```cmd
.\gradlew.bat run
```

## Linux & MacOSX

```bash
./gradlew run
```

启动完成以后命令行日志会提示服务器 URL，用浏览器打开即可，默认用户名、密码：`admin`和`admin`。

# FAQ

* **Q：编译时出现错误，`generateCode` 任务生成的代码报“注释未结束”的错误。** A：升级机器上的 Gradle 到 6.0 或更高版本可解决。

