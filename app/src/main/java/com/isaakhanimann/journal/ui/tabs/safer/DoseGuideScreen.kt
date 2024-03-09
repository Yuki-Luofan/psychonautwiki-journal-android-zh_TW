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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.ui.tabs.search.substance.SectionText
import com.isaakhanimann.journal.ui.theme.horizontalPadding

@Preview
@Composable
fun DoseGuideScreenPreview() {
    DoseGuideScreen(
        navigateToDoseClassification = {},
        navigateToVolumetricDosing = {},
        navigateToPWDosageArticle = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoseGuideScreen(
    navigateToDoseClassification: () -> Unit,
    navigateToVolumetricDosing: () -> Unit,
    navigateToPWDosageArticle: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("劑量指南") })
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = navigateToPWDosageArticle,
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

            SectionText(
                text = """劑量是指施用精神活性物質的大小或數量。
雖然等級可能有所不同，但通常可分為六個等級：閾值、輕度、普通、強烈、重度和過量（致命和非致命）。每個等級都與不同程度的預期效果和潛在副作用有關，這取決於物質和個人的生理機能。
在心理或娛樂藥物使用的背景下，了解劑量的作用非常重要。
服用錯誤劑量的物質可能會導致負面經歷，例如極度焦慮、不舒服的身體副作用、住院或（在極端情況下）死亡。服用太低的劑量通常會讓人們感到不舒服和沮喪，當它導致他們重新服用高於最初預期的劑量時，這可能是危險的，這可能會導致突然強烈、壓倒性和潛在危險的經歷。"""
            )
            val titleStyle = MaterialTheme.typography.titleMedium
            Text("選擇劑量", style = titleStyle)
            SectionText(
                text = """使用者應避免使用他們感到不舒服或不熟悉的劑量。沒有經驗的使用者應始終從較低劑量開始，以逐漸達到正常或常用劑量。這允許使用者驗證他們的身體是否與該物質相容並且沒有表現出任何過敏或異常敏感。
初步測試後，使用者可以決定增加劑量。建議控制增量地增加用量，通常是先前劑量的1/3至1/2。然而，有些物質處理起來非常棘手。例如，眾所周知，2C-P 具有陡峭的劑量反應曲線，只需額外幾毫克即可將可控劑量與過量劑量分開。此外，如果攝入，2C-P 的起效會非常緩慢，在報告 3 至 5 小時後才會出現峰值效應。所以請對新物質保持耐心！劑量絕對不應該增加一倍或三倍，因為這會大大增加發生糟糕旅行或焦慮、恐慌發作和精神病等副作用的可能性。
這大大降低了意外負面經驗的風險；重要的是要記住，每個人對每種物質的反應都不同，這取決於個人耐受性、大腦化學物質、體重、新陳代謝、胃內容物和個人敏感性等因素。另一個需要考慮的因素是物質純度，不同批次的產品可能會有所不同。
有關任何物質適當劑量的信息，應結合 PsychonautWiki、Erowid、Tripsit、Wikipedia、Bluelight 和 Google 進行研究。如果發現有關劑量的矛盾訊息，應始終從最低的開始，以盡量減少風險。"""
            )
            Text("過敏測試", style = titleStyle)
            SectionText(
                text = """有些人，特別是那些有健康問題或免疫系統過度反應的人，可能會對物質產生不良或過敏反應，例如身體或認知上的不適，或過度敏感。防止這種情況的最佳方法是對使用者收到的每批新物質進行過敏測試（即使來自可靠來源，因為有時更有效和更危險的化合物可能會無意中與廣告產品混合） 。
為了正確進行過敏測試，只需服用極少量的物質（常規劑量的 1/6），然後等待幾個小時到幾天。
進行過敏測試時，應注意任何不尋常的副作用，包括皮疹、蕁麻疹、呼吸不適、不舒服的快速心跳或皮膚灼熱感。根據症狀的嚴重程度，可能需要醫療服務。"""
            )
            Text("劑量測量", style = titleStyle)
            SectionText(text = """There are various ways in which users measure their dosages of psychoactive substances. The most accurate and safe method to measure one's drugs is to use a combination of a milligram scale and the volumetric liquid dosing method. This is a vastly far safer route than "eyeballing" one's dosages by approximating the weight of what they are ingesting simply by looking at it and making a rough (but inaccurate) guess.""")
            Text("目視觀察", style = titleStyle)
            SectionText(
                text = """在任何情況下都強烈建議不要進行目視觀察。目測是一種非常不準確的物質測量方法，它涉及觀察物質並粗略猜測重量。由於 10 毫克和 30 毫克在視覺上沒有太大區別，因此可能會導致攝取過多的物質。目測方法有多種形式，包括使用微型湯匙和方格紙方法。
在方格紙方法中，將已知量的物質均勻地舖在一張方格紙上，並且根據覆蓋了多少個方格紙方塊來確定劑量。這種方法是不準確的，因為即使是同一物質的不同批次，所測量的粉末重量的體積其密度也可能有很大差異。例如，兩堆相同大小的麥司卡林可能具有完全不同的密度，因此重量也不同。
使用者不應相信供應商所說的其產品重量一定的說法，因為供應商無意或故意提供錯誤數量的產品（無論是多於還是少於廣告）的情況並非聞所未聞，這可能會導致某些人服用過量用戶。

在極低劑量（低於10毫克）下具有活性且具有敏感劑量反應曲線的物質對眼球尤其危險。""".trimMargin()
            )
            Text("毫克秤", style = titleStyle)
            SectionText(
                text = """毫克刻度以下 ${'$'}1000 無法準確稱出低於至少50 毫克的劑量，並且在10-15 毫克以下的劑量非常不準確，為了獲得更準確的可讀性，請在添加10+ 毫克劑量之前將隨附的校準砝碼添加到秤中，無需去皮。對於更有效的藥物，強烈建議使用者使用容量液體給藥。
購買粉狀化學品時，強烈建議購買可靠且準確的數位毫克秤，以確保攝取安全且建議的劑量。一個簡單的 ${'$'}在此類設備上投資 20-30 美元可能會帶來安全、愉快的體驗和消極、危險的體驗。
為了獲得最準確的測量，秤只能在遠離振動、風和氣流的完全平坦的表面上使用。電池電量低也會影響電子秤的準確性，因此應偶爾更換電池。
透過各種網站可以在線上取得各種不同的比例尺。要選擇品質等級，用戶應在購買前閱讀評論並做出個人決定。使用者最好選擇可讀性為 0.001 g 的秤。當使用精度為 0.005 克（5 毫克）的天平時，重量將在任一方向上減少 5 毫克，這意味著如果測量 20 毫克的物質，結果將在 15-25 毫克之間。""".trimMargin()
            )
            Text("稱重技術", style = titleStyle)
            SectionText(
                text = """大多數毫克秤在較高範圍（5 - 15 克）時比較低範圍更準確。因此，最好在秤上附帶的校準砝碼的情況下稱量藥物。以下步驟概述了最準確測量的稱重方法：
1. 將秤放置在完全平坦的表面上，遠離風和振動
2. 校準秤
3. 將秤附帶的校正砝碼加到秤上，不要沾焦油
4. 添加空凝膠膠囊並記下重量，不結焦油
5. 將粉末加入凝膠膠囊中
6. 記下填充膠囊的重量
7. 從步驟 6 的最終重量減去步驟 4 的重量
8. 之後使用容量液體給藥，特別是對於強效藥物（10mg 以下）""".trimMargin()
            )
            Text("體積液體計量", style = titleStyle)
            SectionText(
                text = """對於強效藥物，最好使用體積液體劑量，因為大多數標準毫克秤無法準確稱出低於 10-15 毫克的劑量。
體積液體給藥是將已知量的化合物溶解在液體介質中的過程，以便更容易測量和準確給藥。為了減少危害，有必要製備某些化合物，這些化合物的效力太強，無法在液體溶液中用傳統的秤進行測量。""".trimMargin()
            )
            Button(
                onClick = navigateToVolumetricDosing,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            ) {
                Text(text = "Volumetric Liquid Dosing")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text("劑量分類", style = titleStyle)
            SectionText(
                text = """物質作用的範圍和強度取決於許多因素。這些包括給藥途徑、劑量、設定和環境以及個人和環境因素。
有效劑量可分為五類：閾值、輕、普通、強、重。""".trimMargin()
            )
            Button(
                onClick = navigateToDoseClassification,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            ) {
                Text(text = "Dosage Classification")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}