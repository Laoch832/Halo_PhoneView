# Halo博客应用 - 日志功能说明

## 概述

为了更好地调试和监控应用运行状态，特别是网络请求和JSON解析问题，我们为Halo博客应用增加了全面的日志记录功能。

## 新增功能

### 1. 统一日志工具类 (LogUtils)

**文件位置**: `app/src/main/java/com/halo/blog/utils/LogUtils.kt`

**主要功能**:
- 提供统一的日志记录接口
- 仅在Debug模式下启用日志记录
- 支持不同级别的日志：Debug、Info、Warning、Error
- 提供专门的网络、JSON、服务器切换和应用启动日志方法

**核心方法**:
```kotlin
// 基础日志方法
LogUtils.d(tag, message)  // Debug日志
LogUtils.i(tag, message)  // Info日志
LogUtils.w(tag, message)  // Warning日志
LogUtils.e(tag, message, throwable)  // Error日志

// 专用日志方法
LogUtils.logNetworkRequest(url, method, headers)  // 网络请求日志
LogUtils.logNetworkResponse(url, code, message, responseTime)  // 网络响应日志
LogUtils.logNetworkError(url, error)  // 网络错误日志
LogUtils.logJsonError(json, error)  // JSON解析错误日志
LogUtils.logServerSwitch(oldServer, newServer)  // 服务器切换日志
LogUtils.logAppStart(isFirstLaunch, selectedServer)  // 应用启动日志
```

### 2. 增强的网络拦截器

**文件位置**: `app/src/main/java/com/halo/blog/data/api/NetworkModule.kt`

**新增功能**:
- 详细记录每个网络请求的URL、方法和请求头
- 记录响应状态码、消息和响应时间
- 捕获并记录网络异常
- 记录Retrofit初始化时的基础URL

**日志示例**:
```
D/Network: === 网络请求开始 ===
D/Network: URL: https://demo.halo.run/api/v1alpha1/posts
D/Network: 方法: GET
D/Network: === 网络请求结束 ===
D/Network: === 网络响应开始 ===
D/Network: URL: https://demo.halo.run/api/v1alpha1/posts
D/Network: 状态码: 200
D/Network: 响应消息: OK
D/Network: 响应时间: 1250ms
D/Network: === 网络响应结束 ===
```

### 3. 自定义JSON转换器

**文件位置**: `app/src/main/java/com/halo/blog/data/api/LoggingGsonConverterFactory.kt`

**主要功能**:
- 替换默认的GsonConverterFactory
- 捕获并详细记录JSON解析错误
- 记录请求JSON序列化过程
- 提供完整的错误上下文信息

**错误日志示例**:
```
E/JSON: === JSON解析错误 ===
E/JSON: JSON内容: {"malformed": json content}
E/JSON: 错误信息: Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 1 path $
E/JSON: === JSON解析错误结束 ===
```

### 4. 服务器切换日志

**文件位置**: `app/src/main/java/com/halo/blog/utils/PreferenceManager.kt`

**功能**:
- 记录用户切换服务器的操作
- 显示旧服务器和新服务器地址
- 记录应用启动时的服务器配置状态

**日志示例**:
```
I/Server: === 服务器切换 ===
I/Server: 旧服务器: https://demo.halo.run/
I/Server: 新服务器: http://192.168.0.30:114/
I/Server: === 服务器切换结束 ===
```

## 日志标签说明

| 标签 | 用途 | 示例 |
|------|------|------|
| `Network` | 网络请求相关 | 请求URL、响应状态、网络错误 |
| `JSON` | JSON处理相关 | 解析错误、序列化过程 |
| `Server` | 服务器切换相关 | 服务器地址变更 |
| `App` | 应用生命周期相关 | 启动状态、配置信息 |
| `HaloBlog` | 通用应用日志 | 默认标签 |

## 使用方法

### 查看日志

1. **Android Studio Logcat**:
   - 连接设备或启动模拟器
   - 打开Android Studio的Logcat窗口
   - 使用标签过滤器查看特定类型的日志

2. **ADB命令行**:
   ```bash
   # 查看所有应用日志
   adb logcat | grep "HaloBlog\|Network\|JSON\|Server\|App"
   
   # 只查看网络相关日志
   adb logcat | grep "Network"
   
   # 只查看错误日志
   adb logcat *:E | grep "HaloBlog"
   ```

### 调试JSON解析问题

当遇到类似 "Use JsonReader.setLenient(true) to accept malformed JSON" 的错误时：

1. 查看JSON日志标签的错误信息
2. 检查服务器返回的JSON格式是否正确
3. 确认API端点是否返回了预期的数据结构
4. 验证服务器地址配置是否正确

## 性能影响

- 日志功能仅在Debug模式下启用
- Release版本不会产生任何日志开销
- 网络请求时间测量对性能影响微乎其微
- JSON内容记录仅在发生错误时进行

## 注意事项

1. **隐私保护**: 日志中不会记录敏感信息如认证令牌
2. **存储空间**: 长时间运行可能产生大量日志，建议定期清理
3. **调试专用**: 这些日志主要用于开发和调试，不应依赖于生产环境
4. **网络流量**: 详细的网络日志可能会增加调试时的可读性，但不会影响实际网络请求

## 故障排除

### 常见问题

1. **看不到日志输出**:
   - 确认应用运行在Debug模式
   - 检查Logcat过滤器设置
   - 确认设备已正确连接

2. **JSON解析错误**:
   - 查看JSON日志中的具体错误信息
   - 验证服务器返回的数据格式
   - 检查网络连接状态

3. **网络请求失败**:
   - 查看Network标签的错误日志
   - 确认服务器地址配置
   - 检查网络权限设置

通过这些增强的日志功能，开发者可以更容易地诊断和解决应用中的网络和数据处理问题。