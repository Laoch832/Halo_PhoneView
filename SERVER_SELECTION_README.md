# 服务器选择功能说明

## 功能概述

本应用已集成服务器选择功能，允许用户在Debug模式下选择不同的服务器线路，并在设置中切换服务器。

## 服务器配置

当前配置的服务器：
- **服务器1**: `http://192.168.0.30:114`
- **服务器2**: `https://www.120505.xyz`

## 使用方式

### Debug模式下的服务器选择

1. **首次启动**: 在Debug版本中，应用首次启动时会自动显示服务器选择界面
2. **选择服务器**: 用户可以选择任一服务器线路
3. **确认选择**: 点击"确认选择"按钮后，应用会保存选择并进入主界面

### 设置中的服务器切换

1. **进入设置**: 在主界面点击左上角的设置图标（齿轮图标）
2. **服务器设置**: 在设置界面中可以看到"服务器设置"选项
3. **切换服务器**: 选择不同的服务器选项
4. **自动保存**: 选择后会自动保存，但需要重启应用才能生效

## 技术实现

### 核心组件

1. **ServerSelectionScreen**: 服务器选择界面
2. **SettingsScreen**: 设置界面
3. **PreferenceManager**: 偏好设置管理器，用于保存用户选择
4. **NetworkModule**: 网络模块，动态获取服务器URL

### 数据持久化

- 使用SharedPreferences保存用户的服务器选择
- 支持首次启动检测
- 自动记住用户的选择

### 网络配置

- NetworkModule会从PreferenceManager获取当前选择的服务器URL
- 如果没有选择，则使用默认的demo服务器
- 自动处理URL格式（确保以"/"结尾）

## 构建和安装

### Debug版本
```bash
./gradlew assembleDebug
```

APK文件位置：`app/build/outputs/apk/debug/app-debug.apk`

### 安装到设备
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 注意事项

1. **Debug模式专用**: 服务器选择界面仅在Debug模式下的首次启动时显示
2. **重启生效**: 更改服务器后需要重启应用才能生效
3. **网络权限**: 确保应用有网络访问权限
4. **服务器可用性**: 请确保配置的服务器地址可以正常访问

## 自定义服务器

如需添加或修改服务器地址，请编辑以下文件中的`serverOptions`：
- `ServerSelectionScreen.kt`
- `SettingsScreen.kt`

```kotlin
val serverOptions = listOf(
    "服务器1" to "http://your-server-1.com",
    "服务器2" to "https://your-server-2.com"
)
```