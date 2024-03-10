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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.ui.tabs.search.substance.CollapsibleSection
import com.isaakhanimann.journal.ui.theme.horizontalPadding

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FAQScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FAQ") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            QuestionAnswerRow(
                question = "你們的資訊從哪裡來？",
                answer = "劑量、持續時間、交互作用、耐受性、通用名稱、精神活性類別、毒性和成癮潛力來自 PsychonautWiki。物質摘要和其他類別來自 Tripsit。效果、劑量備註、一般和長期風險以及更安全的使用來自 DIZ（蘇黎世藥物資訊中心）。"
            )
            QuestionAnswerRow(
                question = "應用程式何時檢測互動？",
                answer = "如果與您不到 2 天前攝入的物質發生交互作用。它檢查雙向相互作用，並檢查某種物質是否透過其精神活性類別間接提及。"
            )
            QuestionAnswerRow(
                question = "如何更改或添加資訊？",
                answer = "在 PsychonautWiki 中編輯文章，以便您的編輯可能會得到 PsychonautWiki 版主之一的批准，特別是如果您可以引用好的來源。更改的資訊將在應用程式的下一次更新中出現。如果要變更的資訊來自 PsychonautWiki 以外的其他來源，請聯絡支援人員。"
            )
            QuestionAnswerRow(
                question = "為什麼時間軸會獨立處理每次攝取？",
                answer = "因為關於耐受性和交叉耐受性的信息還不允許可靠地做到這一點。"
            )
            QuestionAnswerRow(
                question = "攝取劑量旁邊的點是什麼意思？",
                answer = "0點表示劑量低於閾值，1：輕，2：一般，3：強，4：重。超過4點表示減去重劑量，剩下的再按輕、普通、強進行分類。"
            )
        }
    }
}

@Composable
fun QuestionAnswerRow(question: String, answer: String) {
    CollapsibleSection(title = question) {
        Text(
            text = answer,
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .padding(top = 5.dp, bottom = 8.dp)
        )
    }
}


