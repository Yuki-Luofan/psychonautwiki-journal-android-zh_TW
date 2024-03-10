/*
 * Copyright (c) 2022-2023. Isaak Hanimann.
 * This file is part of PsychonautWiki Journal.
 *
 * PsychonautWiki Journal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * PsychonautWiki Journal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PsychonautWiki Journal.  If not, see https://www.gnu.org/licenses/gpl-3.0.en.html.
 */

package com.isaakhanimann.journal.ui.tabs.settings

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.ContactSupport
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.QuestionAnswer
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.VolunteerActivism
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.isaakhanimann.journal.ui.VERSION_NAME
import com.isaakhanimann.journal.ui.tabs.journal.experience.components.CardWithTitle
import com.isaakhanimann.journal.ui.theme.horizontalPadding
import com.isaakhanimann.journal.ui.utils.getStringOfPattern
import kotlinx.coroutines.launch
import java.time.Instant

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(
        deleteEverything = {},
        navigateToFAQ = {},
        navigateToComboSettings = {},
        navigateToSubstanceColors = {},
        navigateToCustomUnits = {},
        importFile = {},
        exportFile = {},
        snackbarHostState = remember { SnackbarHostState() },
    )
}

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    navigateToFAQ: () -> Unit,
    navigateToComboSettings: () -> Unit,
    navigateToSubstanceColors: () -> Unit,
    navigateToCustomUnits: () -> Unit,
) {
    SettingsScreen(
        navigateToFAQ = navigateToFAQ,
        navigateToComboSettings = navigateToComboSettings,
        navigateToSubstanceColors = navigateToSubstanceColors,
        navigateToCustomUnits = navigateToCustomUnits,
        deleteEverything = viewModel::deleteEverything,
        importFile = viewModel::importFile,
        exportFile = viewModel::exportFile,
        snackbarHostState = viewModel.snackbarHostState,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navigateToFAQ: () -> Unit,
    navigateToComboSettings: () -> Unit,
    navigateToSubstanceColors: () -> Unit,
    navigateToCustomUnits: () -> Unit,
    deleteEverything: () -> Unit,
    importFile: (uri: Uri) -> Unit,
    exportFile: (uri: Uri) -> Unit,
    snackbarHostState: SnackbarHostState,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("設置") }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = horizontalPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CardWithTitle(title = "UI界面", innerPaddingHorizontal = 0.dp) {
                SettingsButton(
                    imageVector = Icons.Outlined.Medication,
                    text = "客製化部件"
                ) {
                    navigateToCustomUnits()
                }
                Divider()
                SettingsButton(
                    imageVector = Icons.Outlined.Palette,
                    text = "物質顏色"
                ) {
                    navigateToSubstanceColors()
                }
                Divider()
                SettingsButton(
                    imageVector = Icons.Outlined.WarningAmber,
                    text = "互動設定"
                ) {
                    navigateToComboSettings()
                }

            }
            CardWithTitle(title = "應用程式數據", innerPaddingHorizontal = 0.dp) {
                var isShowingExportDialog by remember { mutableStateOf(false) }
                SettingsButton(imageVector = Icons.Outlined.FileUpload, text = "匯出文件") {
                    isShowingExportDialog = true
                }
                val jsonMIMEType = "application/json"
                val launcherExport =
                    rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.CreateDocument(
                            mimeType = jsonMIMEType
                        )
                    ) { uri ->
                        if (uri != null) {
                            exportFile(uri)
                        }
                    }
                AnimatedVisibility(visible = isShowingExportDialog) {
                    AlertDialog(
                        onDismissRequest = { isShowingExportDialog = false },
                        title = {
                            Text(text = "要輸出到哪裏？")
                        },
                        text = {
                            Text("這會將您的所有資料從應用程式匯出到一個檔案中，以便您可以將其發送給某人或在新手機上再次匯入")
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    isShowingExportDialog = false
                                    launcherExport.launch("Journal ${Instant.now().getStringOfPattern("dd MMM yyyy")}.json")
                                }
                            ) {
                                Text("選擇位置")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { isShowingExportDialog = false }
                            ) {
                                Text("取消")
                            }
                        }
                    )
                }
                Divider()
                var isShowingImportDialog by remember { mutableStateOf(false) }
                SettingsButton(imageVector = Icons.Outlined.FileDownload, text = "匯入文件") {
                    isShowingImportDialog = true
                }
                val launcherImport =
                    rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
                        if (uri != null) {
                            importFile(uri)
                        }
                    }
                AnimatedVisibility(visible = isShowingImportDialog) {
                    AlertDialog(
                        onDismissRequest = { isShowingImportDialog = false },
                        title = {
                            Text(text = "從哪裏導入文件？")
                        },
                        text = {
                            Text("導入之前匯出的文件。請注意，這將刪除您應用程式中已有的資料。")
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    isShowingImportDialog = false
                                    launcherImport.launch(jsonMIMEType)
                                }
                            ) {
                                Text("選擇位置")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { isShowingImportDialog = false }
                            ) {
                                Text("取消")
                            }
                        }
                    )
                }
                Divider()
                var isShowingDeleteDialog by remember { mutableStateOf(false) }
                SettingsButton(
                    imageVector = Icons.Outlined.DeleteForever,
                    text = "刪除數據"
                ) {
                    isShowingDeleteDialog = true
                }
                val scope = rememberCoroutineScope()
                AnimatedVisibility(visible = isShowingDeleteDialog) {
                    AlertDialog(
                        onDismissRequest = { isShowingDeleteDialog = false },
                        title = {
                            Text(text = "要刪除數據嗎?")
                        },
                        text = {
                            Text("恁是否要刪除數據？只有小廢物才會這麽做的，你是被條子找了嗎？")
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    isShowingDeleteDialog = false
                                    deleteEverything()
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            message = "Deleted Everything",
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                }
                            ) {
                                Text("我是小廢物")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { isShowingDeleteDialog = false }
                            ) {
                                Text("取消")
                            }
                        }
                    )
                }
            }
            val uriHandler = LocalUriHandler.current
            CardWithTitle(title = "Feedback", innerPaddingHorizontal = 0.dp) {
                SettingsButton(imageVector = Icons.Outlined.QuestionAnswer, text = "FAQ") {
                    navigateToFAQ()
                }
                Divider()
                SettingsButton(
                    imageVector = Icons.Outlined.ContactSupport,
                    text = "問題/回饋/錯誤報告"
                ) {
                    uriHandler.openUri("https://t.me/+ss8uZhBF6g00MTY8")
                }
                Divider()
                SettingsButton(imageVector = Icons.Outlined.VolunteerActivism, text = "捐獻") {
                    uriHandler.openUri("https://www.buymeacoffee.com/isaakhanimann")
                }
            }
            CardWithTitle(title = "App", innerPaddingHorizontal = 0.dp) {
                SettingsButton(imageVector = Icons.Outlined.Code, text = "原始碼倉庫") {
                    uriHandler.openUri("https://github.com/isaakhanimann/psychonautwiki-journal-android")
                }
                Divider()

                SettingsButton(imageVector = Icons.Outlined.Code, text = "漢化倉庫") {
                    uriHandler.openUri("https://github.com/Yuki-Luofan/psychonautwiki-journal-android-zh_TW")
                }
                Divider()

                val context = LocalContext.current
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, SHARE_APP_URL)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                SettingsButton(imageVector = Icons.Outlined.Share, text = "Share") {
                    context.startActivity(shareIntent)
                }
                Divider()
                Text(
                    text = "Version $VERSION_NAME",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(vertical = 10.dp)
                )
            }
        }
    }
}

const val SHARE_APP_URL = "https://psychonautwiki.org/wiki/PsychonautWiki_Journal"


@Composable
fun SettingsButton(imageVector: ImageVector, text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 2.dp)
    ) {
        Icon(
            imageVector,
            contentDescription = imageVector.name,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
        Spacer(modifier = Modifier.weight(1f))
    }
}