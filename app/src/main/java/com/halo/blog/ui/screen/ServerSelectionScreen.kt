package com.halo.blog.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.halo.blog.BuildConfig
import com.halo.blog.utils.PreferenceManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerSelectionScreen(
    onServerSelected: (String) -> Unit
) {
    val context = LocalContext.current
    val preferenceManager = remember { PreferenceManager(context) }
    
    // 服务器选项
    val serverOptions = listOf(
        "服务器1" to "http://192.168.0.30:114",
        "服务器2" to "https://www.120505.xyz"
    )
    
    var selectedServer by remember { 
        mutableStateOf(preferenceManager.getSelectedServer() ?: serverOptions[0].second) 
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "选择服务器线路",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        if (BuildConfig.DEBUG) {
            Text(
                text = "Debug模式 - 请选择服务器",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
        
        Column(
            modifier = Modifier.selectableGroup()
        ) {
            serverOptions.forEach { (name, url) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedServer == url),
                            onClick = { selectedServer = url },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (selectedServer == url),
                        onClick = null
                    )
                    Column(
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Text(
                            text = name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = url,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                preferenceManager.saveSelectedServer(selectedServer)
                onServerSelected(selectedServer)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "确认选择",
                fontSize = 16.sp
            )
        }
    }
}