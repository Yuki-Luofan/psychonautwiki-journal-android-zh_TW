/*
 * Copyright (c) 2022. Isaak Hanimann.
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

package com.isaakhanimann.journal.ui.tabs.safer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.ui.tabs.search.substance.SectionText
import com.isaakhanimann.journal.ui.tabs.search.substance.VerticalSpace
import com.isaakhanimann.journal.ui.theme.horizontalPadding

@Preview
@Composable
fun ReagentTestingPreview() {
    ReagentTestingScreen(navigateToReagentTestingArticle = {})
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReagentTestingScreen(
    navigateToReagentTestingArticle: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("試劑檢測清單") })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = navigateToReagentTestingArticle,
                icon = {
                    Icon(
                        Icons.Outlined.Article,
                        contentDescription = "Open Link"
                    )
                },
                text = { Text("Article") },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = horizontalPadding)
        ) {
            ElevatedCard(modifier = Modifier.padding(vertical = 3.dp)) {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                    SectionText(
                        text = """試劑測試套件是一種藥物測試方法，使用化學溶液，當應用於化合物時會改變顏色。它們可以幫助確定給定樣品中可能存在哪些化學物質。在許多情況下，他們不排除除了可疑化合物之外或代替可疑化合物還存在另一種類似化合物的可能性。
儘管很少有物質在允許使用吸墨紙的劑量下有效，但 LSD 並不是唯一的一種：必須測試其存在以避免 NBOMe 類物質。此外，測試可能的芬太尼污染變得越來越重要，因為這種物質在劑量下有效，使得可以在一張吸墨紙上放置大量的芬太尼。
試劑只能確定特定物質的存在，而不能確定其數量或純度。深色反應往往凌駕於藥丸中其他物質的反應。某種物質的陽性或陰性反應並不表示該藥物是安全的。沒有一種藥物的使用是 100% 安全的。做出明智的決定並對您的健康和福祉負責；沒有其他人可以。"""
                    )
                    VerticalSpace()
                }
            }
            ElevatedCard(modifier = Modifier.padding(vertical = 5.dp)) {
                Column(
                    Modifier.padding(vertical = 5.dp)
                ) {
                    Text(
                        text = "套件賣家",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Divider()
                    val uriHandler = LocalUriHandler.current
                    TextButton(onClick = { uriHandler.openUri("https://dancesafe.org/testing-kit-instructions/") }) {
                        Text(text = "DanceSafe")
                    }
                    Divider()
                    TextButton(onClick = { uriHandler.openUri("https://bunkpolice.com") }) {
                        Text(text = "Bunk Police")
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}