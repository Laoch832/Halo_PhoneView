# Halo Blog Android App

**注意**：本应用目前仅支持中文界面。
**注意**：本应用目前仅支持中文界面。
**注意**：本应用目前仅支持中文界面。

一个基于 Halo 博客系统的 Android 客户端应用，为用户提供优雅的博客阅读体验。

## 📱 应用简介

这是一个专为 Halo 博客系统设计的 Android 原生应用，采用现代化的 Material Design 3 设计语言和 Jetpack Compose 技术栈构建。应用支持多服务器切换、离线缓存、自动后台更新等功能，为用户提供流畅的博客阅读体验。

## ✨ 主要功能

### 📖 文章阅读
- **文章列表浏览**：支持分页加载，流畅的滚动体验
- **文章详情查看**：支持 HTML 内容渲染，图片加载优化
- **分类和标签**：按分类和标签筛选文章
- **搜索功能**：全文搜索文章内容
- **字体大小调节**：个性化阅读体验，支持 14px-40px 字体调节

### 🔧 系统设置
- **多服务器支持**：可在多个 Halo 服务器间切换
- **API 密钥管理**：安全的 API 认证机制
- **自动后台更新**：每小时自动更新文章内容
- **离线缓存**：支持文章列表和详情的本地缓存

### 🎨 用户体验
- **Material Design 3**：现代化的界面设计
- **深色模式支持**：跟随系统主题
- **流畅动画**：优化的页面切换和加载动画
- **响应式布局**：适配不同屏幕尺寸

## 🛠 技术栈

### 核心技术
- **Jetpack Compose**：现代化的 UI 工具包
- **Material Design 3**：Google 最新设计规范

### 架构组件
- **MVVM 架构**：清晰的代码结构
- **Hilt**：依赖注入框架
- **ViewModel & LiveData**：数据绑定和状态管理
- **Navigation Compose**：声明式导航

### 网络和数据
- **Retrofit**：HTTP 客户端
- **OkHttp**：网络请求拦截和日志
- **Gson**：JSON 序列化
- **Coroutines**：异步编程
- **Flow**：响应式数据流

### 其他功能
- **Coil**：图片加载库
- **WorkManager**：后台任务管理
- **SharedPreferences**：本地数据存储
- **Kotlinx DateTime**：日期时间处理

## 🔧 服务器配置技术说明

### 默认服务器设置

应用的默认博客服务器配置位于以下源码文件中：

**主要配置文件**：
- `app/src/main/java/com/halo/blog/data/api/NetworkModule.kt`（第108行）
  ```kotlin
  val baseUrl = preferenceManager.getSelectedServer() ?: "https://demo.halo.run/"
  ```
  - 默认服务器：`https://demo.halo.run/`
  - 如果用户未选择服务器，自动使用此默认地址

### 服务器选择相关文件

**1. 服务器选择界面**：
- `app/src/main/java/com/halo/blog/ui/screen/ServerSelectionScreen.kt`（第27-30行）
  - 定义可选服务器列表
  - 首次启动时显示的服务器选择界面

**2. 设置界面**：
- `app/src/main/java/com/halo/blog/ui/screen/SettingsScreen.kt`（第35-38行）
  - 设置界面中的服务器切换功能
  - 用户可随时更改服务器配置

**3. 偏好设置管理**：
- `app/src/main/java/com/halo/blog/utils/PreferenceManager.kt`
  - `saveSelectedServer()`：保存用户选择的服务器
  - `getSelectedServer()`：获取当前选择的服务器
  - `isFirstLaunch()`：检查是否首次启动

### 自定义服务器配置

如需添加或修改服务器选项，请编辑以下文件中的 `serverOptions`：


```kotlin
// 在 ServerSelectionScreen.kt 和 SettingsScreen.kt 中
val serverOptions = listOf(
    "服务器1" to "http://your-server-1.com",
    "服务器2" to "https://your-server-2.com"
)
```

### 工作原理

1. **默认连接**：应用启动时，`NetworkModule` 从 `PreferenceManager` 读取用户选择
2. **回退机制**：如果用户未选择服务器，使用默认的 demo 服务器
3. **动态切换**：用户可在设置中切换服务器，重启应用后生效
4. **持久化存储**：用户选择通过 SharedPreferences 保存到本地

## 📋 系统要求

- **最低 Android 版本**：Android 7.0 (API 24)
- **目标 Android 版本**：Android 14 (API 34)
- **编译 SDK 版本**：34
- **最低内存要求**：2GB RAM
- **存储空间**：至少 50MB 可用空间

## 🚀 安装使用

### 从源码构建

1. **克隆项目**
   ```bash
   git clone https://github.com/your-username/Halo-androidApp.git
   cd Halo-androidApp
   ```

2. **环境要求**
   - Android Studio Hedgehog | 2023.1.1 或更高版本
   - JDK 11 或更高版本
   - Android SDK 34

3. **构建项目**
   ```bash
   ./gradlew assembleDebug
   ```

4. **安装到设备**
   ```bash
   ./gradlew installDebug
   ```

### 配置服务器

**默认设置**：应用默认连接到开发者的博客服务器，您可以直接开始使用。

**更换服务器**：如需连接到您自己的 Halo 博客，请按以下步骤操作：

1. 打开应用，点击右上角的「设置」图标
2. 在「服务器设置」部分选择或配置您的 Halo 服务器地址
3. 如需要，在「API密钥设置」中配置访问密钥
4. 保存设置后重启应用即可连接到新服务器

## 📖 使用指南

### 首次使用
1. **直接使用**：应用默认已连接到示例博客，可直接开始阅读
2. **更换服务器**（可选）：如需连接自己的博客，在设置中选择要连接的 Halo 服务器
3. **配置 API 密钥**（可选）：如果服务器需要认证，请配置相应的 API 密钥
4. **开始阅读**：返回首页即可开始浏览文章

### 功能说明
- **首页**：显示最新文章列表，支持下拉刷新和上拉加载更多
- **搜索**：点击搜索图标可搜索文章、分类和标签
- **文章详情**：点击文章卡片查看详细内容
- **分类/标签**：点击分类或标签可查看相关文章
- **设置**：配置服务器、API 密钥、字体大小等


### 主要依赖版本
- Compose BOM: 2023.08.00
- Kotlin: 1.8.10
- Hilt: 2.44
- Retrofit: 2.9.0
- Navigation Compose: 2.5.3
- WorkManager: 2.8.1

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 🙏 致谢

- [Halo](https://halo.run/) - 优秀的开源博客系统
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - 现代化的 Android UI 工具包
- [Material Design 3](https://m3.material.io/) - Google 设计规范


*最后更新：2024年1月*