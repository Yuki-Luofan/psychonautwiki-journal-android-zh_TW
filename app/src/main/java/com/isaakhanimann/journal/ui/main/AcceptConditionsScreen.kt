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

package com.isaakhanimann.journal.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.R

@Preview
@Composable
fun AcceptConditionsPreview() {
    AcceptConditionsScreen {}
}

@Composable
fun AcceptConditionsScreen(
    onTapAccept: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var checkedState0 by remember { mutableStateOf(false) }
        var checkedState1 by remember { mutableStateOf(false) }
        var checkedState2 by remember { mutableStateOf(false) }
        var checkedState3 by remember { mutableStateOf(false) }
        val allIsChecked =
            checkedState0 && checkedState1 && checkedState2 && checkedState3
        val painter =
            if (allIsChecked) painterResource(R.drawable.eye_open) else painterResource(R.drawable.eye_closed)
        Image(
            painter = painter,
            contentDescription = "PsychonautWiki eye",
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    checkedState0 = true
                    checkedState1 = true
                    checkedState2 = true
                    checkedState3 = true
                }
                .fillMaxWidth(0.4f)
                .padding(bottom = 10.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    checkedState0 = checkedState0.not()
                }) {
                Checkbox(
                    checked = checkedState0,
                    onCheckedChange = { checkedState0 = it }
                )
                Text(text = "我承認我是唯一對自己的行爲負責的人，特別是我在決定使用毒品時。")
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    checkedState1 = checkedState1.not()
                }) {
                Checkbox(
                    checked = checkedState1,
                    onCheckedChange = { checkedState1 = it }
                )
                Text(text = "我將會使用這個應用程序來降低我或其他人吸毒的風險。")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    checkedState2 = checkedState2.not()
                }
            ) {
                Checkbox(
                    checked = checkedState2,
                    onCheckedChange = { checkedState2 = it }
                )
                Text(text = "我承認應用程序裏的數據可能是不完整或錯誤的。")
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    checkedState3 = checkedState3.not()
                }) {
                Checkbox(
                    checked = checkedState3,
                    onCheckedChange = { checkedState3 = it }
                )
                Text(text = "在嘗試自我治療之前，我會尋求專業協助（這個在中國是廢話，爲了你不被抓捕，請忽略這一條）")
            }
        }
        Text(
            text = "你的選項和其他用戶資料將會被一直保存在設備本地",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Button(onClick = onTapAccept, enabled = allIsChecked) {
            Text(text = "繼續")
        }
    }
}