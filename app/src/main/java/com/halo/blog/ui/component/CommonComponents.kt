@file:OptIn(ExperimentalMaterial3Api::class)
package com.halo.blog.ui.component

import android.content.Context
import android.webkit.WebView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.halo.blog.data.model.CategoryItem
import com.halo.blog.data.model.TagItem
import com.halo.blog.utils.UrlUtils

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(56.dp),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 4.dp
            )
            Text(
                text = "加载中...",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun RefreshIndicator(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                strokeWidth = 2.dp
            )
            Text(
                text = "正在从服务器拉取最新数据...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun ErrorMessage(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Error",
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.onErrorContainer
            )
            
            Text(
                text = "出现错误",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onErrorContainer,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onErrorContainer,
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onError
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "重试",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
fun CategoryChip(
    category: CategoryItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        onClick = onClick,
        label = {
            Text(
                text = category.displayName,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )
        },
        selected = false,
        modifier = modifier,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
            iconColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f),
            selectedBorderColor = MaterialTheme.colorScheme.outline
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    )
}

@Composable
fun TagChip(
    tag: TagItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val chipColor = tag.color?.let {
        try {
            Color(android.graphics.Color.parseColor(it))
        } catch (e: Exception) {
            null
        }
    }
    
    FilterChip(
        onClick = onClick,
        label = {
            Text(
                text = tag.displayName,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )
        },
        selected = false,
        modifier = modifier,
        colors = chipColor?.let {
            FilterChipDefaults.filterChipColors(
                containerColor = it.copy(alpha = 0.1f),
                labelColor = it,
                iconColor = it
            )
        } ?: FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
            iconColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f),
            selectedBorderColor = MaterialTheme.colorScheme.outline
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    )
}

@Composable
fun HtmlContent(
    html: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    // 添加日志查看原始HTML内容
    android.util.Log.d("HtmlContent", "Original HTML length: ${html.length}")
    android.util.Log.d("HtmlContent", "Original HTML contains img tags: ${html.contains("<img", ignoreCase = true)}")
    
    // 提取音频URL，但保留图片在HTML中
    val (htmlWithImages, audioUrls) = remember(html) {
        extractAudioFromHtml(context, html)
    }
    
    // 添加日志查看处理后的HTML内容
    android.util.Log.d("HtmlContent", "Processed HTML length: ${htmlWithImages.length}")
    android.util.Log.d("HtmlContent", "Processed HTML contains img tags: ${htmlWithImages.contains("<img", ignoreCase = true)}")
    if (htmlWithImages.contains("<img", ignoreCase = true)) {
        val imgMatches = "<img[^>]*>".toRegex(RegexOption.IGNORE_CASE).findAll(htmlWithImages)
        android.util.Log.d("HtmlContent", "Found ${imgMatches.count()} img tags in processed HTML")
    }
    
    var showImagePreview by remember { mutableStateOf(false) }
    var selectedImageUrl by remember { mutableStateOf("") }
    
    Column(modifier = modifier) {
        // 显示音频播放器
        if (audioUrls.isNotEmpty()) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                audioUrls.forEach { audioUrl ->
                    AudioPlayer(
                        audioUrl = audioUrl,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
        
        // 显示HTML内容（包含图片）
        if (htmlWithImages.isNotBlank()) {
            HtmlTextContentWithImages(
                html = htmlWithImages,
                modifier = Modifier.fillMaxWidth(),
                onImageClick = { imageUrl ->
                    selectedImageUrl = imageUrl
                    showImagePreview = true
                }
            )
        }
    }
    
    // 图片预览对话框
    if (showImagePreview) {
        ImagePreviewDialog(
            imageUrl = selectedImageUrl,
            onDismiss = { showImagePreview = false }
        )
    }
}

@Composable
fun HtmlTextContentWithImages(
    html: String,
    modifier: Modifier = Modifier,
    onImageClick: (String) -> Unit = {}
) {
    val context = LocalContext.current
    var webViewHeight by remember { mutableStateOf(200.dp) }
    
    // 监听字体大小变化
    val fontSize by com.halo.blog.utils.FontSizeManager.fontSize
    val currentFontSize = remember(fontSize) { fontSize }
    
    // 获取主题背景色
    // val backgroundColor = MaterialTheme.colorScheme.surface
    
    AndroidView(
        factory = { ctx ->
            WebView(ctx).apply {
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = false
                    allowFileAccess = false
                    allowContentAccess = false
                    setSupportZoom(false)
                    builtInZoomControls = false
                    displayZoomControls = false
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    textZoom = 120  // 增加文本缩放比例
                    defaultFontSize = 20  // 设置默认字体大小
                }
                
                // 添加JavaScript接口来处理图片点击
                addJavascriptInterface(object {
                    @android.webkit.JavascriptInterface
                    fun onImageClick(imageUrl: String) {
                        android.util.Log.d("HtmlTextContentWithImages", "Image clicked: $imageUrl")
                        // 在主线程中调用回调
                        android.os.Handler(android.os.Looper.getMainLooper()).post {
                            onImageClick.invoke(imageUrl)
                        }
                    }
                    
                    @android.webkit.JavascriptInterface
                    fun logMessage(message: String) {
                        android.util.Log.d("HtmlTextContentWithImages", "JS: $message")
                    }
                }, "Android")
                
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        android.util.Log.d("HtmlTextContentWithImages", "Page finished loading")
                        
                        // 延迟计算高度，确保所有内容都已加载
                        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                            view?.evaluateJavascript(
                                "(function() { var body = document.body, html = document.documentElement; var height = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight); console.log('Calculated height: ' + height); return height; })();"
                            ) { result ->
                                try {
                                    val height = result.toFloatOrNull() ?: 1000f
                                    val density = ctx.resources.displayMetrics.density
                                    // 增加更多缓冲空间，确保内容完整显示
                                    val calculatedHeight = (height / density + 100).dp
                                    val finalHeight = if (calculatedHeight < 800.dp) 800.dp else calculatedHeight
                                    android.util.Log.d("HtmlTextContentWithImages", "Final calculated height: $finalHeight")
                                    webViewHeight = finalHeight
                                } catch (e: Exception) {
                                    android.util.Log.e("HtmlTextContentWithImages", "Error calculating height", e)
                                    webViewHeight = 1200.dp
                                }
                            }
                        }, 500) // 延迟500ms
                        
                        // 添加图片点击事件监听器
                        view?.evaluateJavascript("""
                            (function() {
                                // 输出当前页面的完整HTML内容
                                console.log('Current page HTML: ' + document.documentElement.outerHTML);
                                Android.logMessage('Current page HTML: ' + document.documentElement.outerHTML);
                                
                                var images = document.getElementsByTagName('img');
                                console.log('Found ' + images.length + ' images');
                                Android.logMessage('Found ' + images.length + ' images in HTML');
                                for (var i = 0; i < images.length; i++) {
                                    Android.logMessage('Image ' + i + ' src: ' + images[i].src);
                                    images[i].onclick = function() {
                                        Android.onImageClick(this.src);
                                        return false;
                                    };
                                    images[i].style.cursor = 'pointer';
                                }
                                
                                // 输出HTML内容用于调试
                                var htmlContent = document.documentElement.innerHTML;
                                Android.logMessage('HTML content length: ' + htmlContent.length);
                                if (htmlContent.indexOf('<img') !== -1) {
                                    Android.logMessage('HTML contains img tags');
                                } else {
                                    Android.logMessage('HTML does NOT contain img tags');
                                }
                                Android.logMessage('Body content: ' + document.body.innerHTML);
                            })();
                        """.trimIndent(), null)
                    }
                }
                
                // 保留图片的display样式，但清除其他可能冲突的内联样式
                val cleanedHtml = html
                    .replace("text-indent:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-indent样式
                    .replace("text-align:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-align样式
                
                // 添加调试日志
                android.util.Log.d("HtmlTextContentWithImages", "Original HTML length: ${html.length}")
                android.util.Log.d("HtmlTextContentWithImages", "Original HTML start: ${html.take(200)}")
                android.util.Log.d("HtmlTextContentWithImages", "Original HTML end: ${html.takeLast(200)}")
                android.util.Log.d("HtmlTextContentWithImages", "Cleaned HTML length: ${cleanedHtml.length}")
                android.util.Log.d("HtmlTextContentWithImages", "Cleaned HTML start: ${cleanedHtml.take(200)}")
                android.util.Log.d("HtmlTextContentWithImages", "Cleaned HTML end: ${cleanedHtml.takeLast(200)}")
                
                val css = """
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }
                        body {
                            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Noto Sans CJK SC', sans-serif !important;
                            font-size: ${currentFontSize}px !important;
                            line-height: 1.8 !important;
                            color: #2c2c2c !important;
                            margin: 12px !important;
                            padding: 0 !important;
                            background-color: #ffffff !important;
                            text-indent: 0 !important;
                        }
                        img {
                            max-width: 100% !important;
                            height: auto !important;
                            border-radius: 8px !important;
                            margin: 16px 0 !important;
                            cursor: pointer !important;
                            transition: transform 0.2s ease !important;
                        }
                        img:hover {
                            transform: scale(1.02) !important;
                        }
                        p {
                            margin: 16px 0 !important;
                            font-size: ${currentFontSize}px !important;
                            line-height: 1.8 !important;
                            text-indent: 0 !important;
                        }
                        h1 {
                            font-size: 28px !important;
                            margin: 32px 0 20px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h2 {
                            font-size: 24px !important;
                            margin: 28px 0 16px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h3 {
                            font-size: 20px !important;
                            margin: 24px 0 12px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h4, h5, h6 {
                            font-size: 18px !important;
                            margin: 20px 0 12px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        blockquote {
                            border-left: 4px solid #6750A4 !important;
                            margin: 20px 0 !important;
                            padding: 16px 20px !important;
                            background-color: #f8f7ff !important;
                            font-style: italic !important;
                            font-size: ${(currentFontSize * 0.77f).toInt()}px !important;
                            border-radius: 0 8px 8px 0 !important;
                            text-indent: 0 !important;
                        }
                        code {
                            background-color: #f0f0f0 !important;
                            padding: 4px 8px !important;
                            border-radius: 6px !important;
                            font-family: 'SF Mono', 'Monaco', 'Inconsolata', 'Roboto Mono', monospace !important;
                            font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                            color: #d73a49 !important;
                        }
                        pre {
                            background-color: #f6f8fa !important;
                            padding: 16px !important;
                            border-radius: 12px !important;
                            overflow-x: auto !important;
                            border: 1px solid #e1e4e8 !important;
                            font-size: ${(currentFontSize * 0.68f).toInt()}px !important;
                            line-height: 1.6 !important;
                            text-indent: 0 !important;
                        }
                        pre code {
                            background-color: transparent !important;
                            padding: 0 !important;
                            color: #24292e !important;
                        }
                        ul, ol {
                            margin: 16px 0 !important;
                            padding-left: 28px !important;
                            font-size: ${(currentFontSize * 0.82f).toInt()}px !important;
                            line-height: 1.8 !important;
                        }
                        li {
                            margin: 8px 0 !important;
                            text-indent: 0 !important;
                        }
                        strong {
                            font-weight: 600 !important;
                            color: #1a1a1a !important;
                        }
                        em {
                            font-style: italic !important;
                            color: #555 !important;
                        }
                        a {
                            color: #6750A4 !important;
                            text-decoration: none !important;
                        }
                        a:hover {
                            text-decoration: underline !important;
                        }
                        table {
                            border-collapse: collapse !important;
                            width: 100% !important;
                            margin: 20px 0 !important;
                            font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                        }
                        th, td {
                            border: 1px solid #ddd !important;
                            padding: 12px !important;
                            text-align: left !important;
                        }
                        th {
                            background-color: #f5f5f5 !important;
                            font-weight: 600 !important;
                        }
                    </style>
                """
                
                val htmlContent = "$css$cleanedHtml"
                val baseUrl = com.halo.blog.utils.UrlUtils.getBaseUrl(context)
                android.util.Log.d("HtmlTextContentWithImages", "Final HTML to load: $htmlContent")
                loadDataWithBaseURL(baseUrl, htmlContent, "text/html", "UTF-8", null)
            }
        },
        modifier = modifier
            .height(webViewHeight)
            .fillMaxWidth()
    )
}

@Composable
fun HtmlTextContent(
    html: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var webViewHeight by remember { mutableStateOf(200.dp) }
    
    // 监听字体大小变化
    val fontSize by com.halo.blog.utils.FontSizeManager.fontSize
    val currentFontSize = remember(fontSize) { fontSize }
    
    // 获取主题背景色
    // val backgroundColor = MaterialTheme.colorScheme.surface
    
    AndroidView(
        factory = { ctx ->
            WebView(ctx).apply {
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = false
                    allowFileAccess = false
                    allowContentAccess = false
                    setSupportZoom(false)
                    builtInZoomControls = false
                    displayZoomControls = false
                    loadWithOverviewMode = true
                    useWideViewPort = true
                    textZoom = 120  // 增加文本缩放比例
                    defaultFontSize = 20  // 设置默认字体大小
                }
                
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        // 多次尝试计算高度，确保内容完全加载
                        fun calculateHeight(attempt: Int = 0) {
                            if (attempt > 5) return // 最多尝试5次
                            
                            view?.evaluateJavascript(
                                """(function() { 
                                    // 等待所有图片加载完成
                                    var images = document.getElementsByTagName('img');
                                    var loadedImages = 0;
                                    var totalImages = images.length;
                                    
                                    function checkAllLoaded() {
                                        if (loadedImages === totalImages) {
                                            var body = document.body, html = document.documentElement;
                                            var height = Math.max(
                                                body.scrollHeight, 
                                                body.offsetHeight, 
                                                html.clientHeight, 
                                                html.scrollHeight, 
                                                html.offsetHeight,
                                                document.documentElement.getBoundingClientRect().height
                                            );
                                            console.log('Final calculated height: ' + height + ', images: ' + totalImages);
                                            return height;
                                        }
                                        return -1; // 表示还在加载
                                    }
                                    
                                    if (totalImages === 0) {
                                        return checkAllLoaded();
                                    }
                                    
                                    for (var i = 0; i < totalImages; i++) {
                                        if (images[i].complete) {
                                            loadedImages++;
                                        } else {
                                            images[i].onload = function() {
                                                loadedImages++;
                                            };
                                        }
                                    }
                                    
                                    return checkAllLoaded();
                                })();"""
                            ) { result ->
                                try {
                                    val height = result.replace("\"", "").toFloatOrNull() ?: -1f
                                    if (height > 0) {
                                        val density = ctx.resources.displayMetrics.density
                                        // 给予充足的高度空间，不设置最小限制
                                        val calculatedHeight = (height / density + 150).dp
                                        webViewHeight = calculatedHeight
                                        android.util.Log.d("HtmlTextContent", "WebView height set to: $calculatedHeight (from $height px)")
                                    } else {
                                        // 如果还在加载，延迟重试
                                        view.postDelayed({ calculateHeight(attempt + 1) }, 300)
                                    }
                                } catch (e: Exception) {
                                    android.util.Log.e("HtmlTextContent", "Error calculating height: ${e.message}")
                                        webViewHeight = 500.dp // 给一个合理的默认值
                                }
                            }
                        }
                        
                        // 延迟开始计算，给页面一些初始化时间
                        view?.postDelayed({ calculateHeight() }, 200)
                    }
                }
                
                // 清除HTML中的特定样式，保持HTML结构完整
                val cleanedHtml = html
                    .replace("text-indent:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-indent样式
                    .replace("text-align:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-align样式
                    .trim()
                
                // 添加调试日志
                android.util.Log.d("HtmlTextContent", "Original HTML preview: ${html.take(200)}")
                android.util.Log.d("HtmlTextContent", "Cleaned HTML preview: ${cleanedHtml.take(200)}")
                
                val css = """
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            box-sizing: border-box;
                        }
                        body {
                            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Noto Sans CJK SC', sans-serif !important;
                            font-size: ${currentFontSize}px !important;
                            line-height: 1.8 !important;
                            color: #2c2c2c !important;
                            margin: 12px !important;
                            padding: 0 !important;
                            background-color: #ffffff !important;
                            text-indent: 0 !important;
                        }
                        p {
                            margin: 16px 0 !important;
                            font-size: ${currentFontSize}px !important;
                            line-height: 1.8 !important;
                            text-indent: 0 !important;
                        }
                        h1 {
                            font-size: 28px !important;
                            margin: 32px 0 20px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h2 {
                            font-size: 24px !important;
                            margin: 28px 0 16px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h3 {
                            font-size: 20px !important;
                            margin: 24px 0 12px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        h4, h5, h6 {
                            font-size: 18px !important;
                            margin: 20px 0 12px 0 !important;
                            font-weight: bold !important;
                            color: #1a1a1a !important;
                            line-height: 1.4 !important;
                            text-indent: 0 !important;
                        }
                        blockquote {
                            border-left: 4px solid #6750A4 !important;
                            margin: 20px 0 !important;
                            padding: 16px 20px !important;
                            background-color: #f8f7ff !important;
                            font-style: italic !important;
                            font-size: ${(currentFontSize * 0.77f).toInt()}px !important;
                            border-radius: 0 8px 8px 0 !important;
                            text-indent: 0 !important;
                        }
                        code {
                            background-color: #f0f0f0 !important;
                            padding: 4px 8px !important;
                            border-radius: 6px !important;
                            font-family: 'SF Mono', 'Monaco', 'Inconsolata', 'Roboto Mono', monospace !important;
                            font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                            color: #d73a49 !important;
                        }
                        pre {
                            background-color: #f6f8fa !important;
                            padding: 16px !important;
                            border-radius: 12px !important;
                            overflow-x: auto !important;
                            border: 1px solid #e1e4e8 !important;
                            font-size: ${(currentFontSize * 0.68f).toInt()}px !important;
                            line-height: 1.6 !important;
                            text-indent: 0 !important;
                        }
                        pre code {
                            background-color: transparent !important;
                            padding: 0 !important;
                            color: #24292e !important;
                        }
                        ul, ol {
                            margin: 16px 0 !important;
                            padding-left: 28px !important;
                            font-size: ${(currentFontSize * 0.82f).toInt()}px !important;
                            line-height: 1.8 !important;
                        }
                        li {
                            margin: 8px 0 !important;
                            text-indent: 0 !important;
                        }
                        strong {
                            font-weight: 600 !important;
                            color: #1a1a1a !important;
                        }
                        em {
                            font-style: italic !important;
                            color: #555 !important;
                        }
                        a {
                            color: #6750A4 !important;
                            text-decoration: none !important;
                        }
                        a:hover {
                            text-decoration: underline !important;
                        }
                        table {
                            border-collapse: collapse !important;
                            width: 100% !important;
                            margin: 20px 0 !important;
                            font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                        }
                        th, td {
                            border: 1px solid #ddd !important;
                            padding: 12px !important;
                            text-align: left !important;
                        }
                        th {
                            background-color: #f5f5f5 !important;
                            font-weight: 600 !important;
                        }
                    </style>
                """
                
                val htmlContent = "$css$cleanedHtml"
                val baseUrl = com.halo.blog.utils.UrlUtils.getBaseUrl(context)
                loadDataWithBaseURL(baseUrl, htmlContent, "text/html", "UTF-8", null)
            }
        },
        update = { webView ->
            // 当字体大小变化时重新加载内容
            val cleanedHtml = html
                .replace("text-indent:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-indent样式
                .replace("text-align:\\s*[^;\"]*;".toRegex(RegexOption.IGNORE_CASE), "") // 移除text-align样式
                .trim()
            
            val css = """
                <style>
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                    }
                    body {
                        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Noto Sans CJK SC', sans-serif !important;
                        font-size: ${currentFontSize}px !important;
                        line-height: 1.8 !important;
                        color: #2c2c2c !important;
                        margin: 12px !important;
                        padding: 0 !important;
                        background-color: #ffffff !important;
                        text-indent: 0 !important;
                    }
                    img {
                        max-width: 100% !important;
                        height: auto !important;
                        border-radius: 8px !important;
                        margin: 16px 0 !important;
                        cursor: pointer !important;
                        transition: transform 0.2s ease !important;
                    }
                    img:hover {
                        transform: scale(1.02) !important;
                    }
                    p {
                        margin: 16px 0 !important;
                        font-size: ${currentFontSize}px !important;
                        line-height: 1.8 !important;
                        text-indent: 0 !important;
                    }
                    h1 {
                        font-size: ${(currentFontSize * 1.27f).toInt()}px !important;
                        margin: 32px 0 20px 0 !important;
                        font-weight: bold !important;
                        color: #1a1a1a !important;
                        line-height: 1.4 !important;
                        text-indent: 0 !important;
                    }
                    h2 {
                        font-size: ${(currentFontSize * 1.09f).toInt()}px !important;
                        margin: 28px 0 16px 0 !important;
                        font-weight: bold !important;
                        color: #1a1a1a !important;
                        line-height: 1.4 !important;
                        text-indent: 0 !important;
                    }
                    h3 {
                        font-size: ${(currentFontSize * 0.91f).toInt()}px !important;
                        margin: 24px 0 12px 0 !important;
                        font-weight: bold !important;
                        color: #1a1a1a !important;
                        line-height: 1.4 !important;
                        text-indent: 0 !important;
                    }
                    h4, h5, h6 {
                        font-size: ${(currentFontSize * 0.82f).toInt()}px !important;
                        margin: 20px 0 12px 0 !important;
                        font-weight: bold !important;
                        color: #1a1a1a !important;
                        line-height: 1.4 !important;
                        text-indent: 0 !important;
                    }
                    blockquote {
                        border-left: 4px solid #6750A4 !important;
                        margin: 20px 0 !important;
                        padding: 16px 20px !important;
                        background-color: #f8f7ff !important;
                        font-style: italic !important;
                        font-size: ${(currentFontSize * 0.77f).toInt()}px !important;
                        border-radius: 0 8px 8px 0 !important;
                        text-indent: 0 !important;
                    }
                    code {
                        background-color: #f0f0f0 !important;
                        padding: 4px 8px !important;
                        border-radius: 6px !important;
                        font-family: 'SF Mono', 'Monaco', 'Inconsolata', 'Roboto Mono', monospace !important;
                        font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                        color: #d73a49 !important;
                    }
                    pre {
                        background-color: #f6f8fa !important;
                        padding: 16px !important;
                        border-radius: 12px !important;
                        overflow-x: auto !important;
                        border: 1px solid #e1e4e8 !important;
                        font-size: ${(currentFontSize * 0.68f).toInt()}px !important;
                        line-height: 1.6 !important;
                        text-indent: 0 !important;
                    }
                    pre code {
                        background-color: transparent !important;
                        padding: 0 !important;
                        color: #24292e !important;
                    }
                    ul, ol {
                        margin: 16px 0 !important;
                        padding-left: 28px !important;
                        font-size: ${(currentFontSize * 0.82f).toInt()}px !important;
                        line-height: 1.8 !important;
                    }
                    li {
                        margin: 8px 0 !important;
                        text-indent: 0 !important;
                    }
                    strong {
                        font-weight: 600 !important;
                        color: #1a1a1a !important;
                    }
                    em {
                        font-style: italic !important;
                        color: #555 !important;
                    }
                    a {
                        color: #6750A4 !important;
                        text-decoration: none !important;
                    }
                    a:hover {
                        text-decoration: underline !important;
                    }
                    table {
                        border-collapse: collapse !important;
                        width: 100% !important;
                        margin: 20px 0 !important;
                        font-size: ${(currentFontSize * 0.73f).toInt()}px !important;
                    }
                    th, td {
                        border: 1px solid #ddd !important;
                        padding: 12px !important;
                        text-align: left !important;
                    }
                    th {
                        background-color: #f5f5f5 !important;
                        font-weight: 600 !important;
                    }
                </style>
            """
            
            val htmlContent = "$css$cleanedHtml"
            val baseUrl = UrlUtils.getBaseUrl(context)
            webView.loadDataWithBaseURL(baseUrl, htmlContent, "text/html", "UTF-8", null)
            
            // 重新添加图片点击事件监听器
            webView.evaluateJavascript("""
                (function() {
                    var images = document.getElementsByTagName('img');
                    for (var i = 0; i < images.length; i++) {
                        images[i].onclick = function() {
                            Android.onImageClick(this.src);
                            return false;
                        };
                        images[i].style.cursor = 'pointer';
                    }
                })();
            """.trimIndent(), null)
        },
        modifier = modifier
            .height(webViewHeight)
            .fillMaxWidth()
    )
}

// 从HTML中提取音频并返回保留图片的HTML和音频URL列表
private fun extractAudioFromHtml(context: Context, html: String): Pair<String, List<String>> {
    val baseUrl = UrlUtils.getBaseUrl(context)
    val audioUrls = mutableListOf<String>()
    
    // 提取音频URL
    val audioPattern = "<audio[^>]*>.*?<source[^>]*src\\s*=\\s*[\"']([^\"']+)[\"'][^>]*>.*?</audio>".toRegex(RegexOption.DOT_MATCHES_ALL)
    val audioMatches = audioPattern.findAll(html)
    
    audioMatches.forEach { matchResult ->
        val srcValue = matchResult.groupValues[1]
        val fullAudioUrl = if (srcValue.startsWith("/") && baseUrl != null) {
            "$baseUrl$srcValue"
        } else {
            srcValue
        }
        audioUrls.add(fullAudioUrl)
    }
    
    // 也尝试提取简单的audio标签
    val simpleAudioPattern = "<audio[^>]*src\\s*=\\s*[\"']([^\"']+)[\"'][^>]*>".toRegex()
    val simpleAudioMatches = simpleAudioPattern.findAll(html)
    
    simpleAudioMatches.forEach { matchResult ->
        val srcValue = matchResult.groupValues[1]
        val fullAudioUrl = if (srcValue.startsWith("/") && baseUrl != null) {
            "$baseUrl$srcValue"
        } else {
            srcValue
        }
        if (!audioUrls.contains(fullAudioUrl)) {
            audioUrls.add(fullAudioUrl)
        }
    }
    
    // 处理图片URL，确保它们是完整的URL
    var processedHtml = html
    val imgPattern = "<img[^>]*src\\s*=\\s*[\"']([^\"']+)[\"']".toRegex()
    processedHtml = imgPattern.replace(processedHtml) { matchResult ->
        val srcValue = matchResult.groupValues[1]
        val fullImageUrl = if (srcValue.startsWith("/") && baseUrl != null) {
            UrlUtils.buildImageUrl(context, srcValue) ?: srcValue
        } else {
            srcValue
        }
        matchResult.value.replace(srcValue, fullImageUrl)
    }
    
    // 移除音频标签
    val audioRemovePattern = "<audio[^>]*>.*?</audio>".toRegex(RegexOption.DOT_MATCHES_ALL)
    processedHtml = audioRemovePattern.replace(processedHtml, "")
    
    // 移除视频标签
    val videoPattern = "<video[^>]*>.*?</video>".toRegex(RegexOption.DOT_MATCHES_ALL)
    processedHtml = videoPattern.replace(processedHtml, "")
    
    // 移除空的段落标签和div标签
    processedHtml = processedHtml.replace("<p[^>]*>\\s*</p>".toRegex(), "")
    processedHtml = processedHtml.replace("<div[^>]*>\\s*</div>".toRegex(), "")
    
    // 移除只包含空白字符的段落
    processedHtml = processedHtml.replace("<p[^>]*>\\s*&nbsp;\\s*</p>".toRegex(), "")
    
    // 清理多余的空白和换行
    processedHtml = processedHtml.replace("\\s*\\n\\s*".toRegex(), "\n")
    processedHtml = processedHtml.replace("\\n{3,}".toRegex(), "\n\n")
    
    return Pair(processedHtml.trim(), audioUrls)
}

@Composable
fun EmptyState(
    message: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Info
) {
    Column(
        modifier = modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
        )
        
        Text(
            text = "暂无内容",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
        )
    }
}