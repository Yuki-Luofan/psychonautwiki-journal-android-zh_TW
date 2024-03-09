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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.data.substances.classes.roa.DoseClass
import com.isaakhanimann.journal.ui.tabs.search.substance.CollapsibleSection
import com.isaakhanimann.journal.ui.tabs.search.substance.VerticalSpace
import com.isaakhanimann.journal.ui.theme.horizontalPadding

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DoseExplanationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("劑量分類") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            VerticalSpace()
            ElevatedCard(modifier = Modifier.padding(vertical = 5.dp, horizontal = horizontalPadding)) {
                Text(
                    text = "物質作用的範圍和強度取決於許多因素。這些包括給藥途徑、劑量、設定和環境以及個人和環境因素。\n" +
                            "有效劑量可分為五類：閾值、輕、普通、強、重。",
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = horizontalPadding)
                )
            }
            DoseClass.values().forEach {
                CollapsibleSection(title = it.name) {
                    Text(
                        text = it.description,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(horizontal = horizontalPadding)
                    )
                }
            }
        }
    }
}