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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isaakhanimann.journal.ui.tabs.search.substance.BulletPoints
import com.isaakhanimann.journal.ui.tabs.search.substance.CollapsibleSection
import com.isaakhanimann.journal.ui.tabs.search.substance.SectionText
import com.isaakhanimann.journal.ui.tabs.search.substance.VerticalSpace
import com.isaakhanimann.journal.ui.theme.horizontalPadding

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SaferHallucinogensScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("更安全的致幻劑使用") },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            ElevatedCard(modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 3.dp)) {
                Text(
                    text = "以下資訊專門針對迷幻劑、解離劑和譫妄劑等致幻劑的使用和實驗而設計。",
                    modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 5.dp)
                )
                VerticalSpace()
            }
            CollapsibleSection(title = "Setting") {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                    SectionText(text = "選擇一個合適的地方來體驗致幻劑的效果非常重要，並且在決定體驗結果方面起著重要作用。對於沒有經驗的使用者來說，理想的地方是一個熟悉的、安全的室內環境，他們可以完全控制該環境，並且沒有可能對人的精神狀態產生負面影響的因素。為了為致幻劑準備適當的環境，建議採取以下步驟：")
                    BulletPoints(
                        points = listOf(
                            "確保體驗者在體驗期間（最好是體驗後的第二天）完全不承擔任何責任。這是因為，在致幻劑的影響下，即使是最簡單的任務也會變得異常困難，並且可能會帶來壓力。使用者應做好充分放鬆的準備，不要做家事或日常生活。這包括駕駛和操作重型機械。",
                            "避開不直接參與體驗的人。這包括可能睡在同一棟房子裡的親戚和朋友，他們根本不是非常值得信任、理解和了解致幻劑的影響。僅僅靠近不知情的人就會引發焦慮和偏執，並妨礙完全沉浸在體驗中。",
                            "避免陌生、喧鬧、混亂和/或公共環境。使用者應該選擇一個他們有相當程度控制的環境。這可以像能夠調整空調設定或自由進出衛生間一樣簡單。在整個體驗過程中，人們應該能夠隨心所欲地坐下、躺下和走動。所選的環境最好具有隱私、輕鬆的音樂、舒適的座椅以及隨時可用的食物和水。此類環境的例子包括家裡或朋友家中安全、舒適的房間。",
                            "避免任何可能產生「不良情緒」的來源。使用者不應讓自己受到不愉快或令人不安的刺激，例如恐怖電影或黑暗音樂。如果體驗中存在不好的氛圍，可以透過快速改變使用者所處的直接環境來避免這些不良氛圍。例如，如果一個人坐下來關燈，則站起來打開燈、改變音樂或移動到房子裡的另一個房間。"
                        ),
                        modifier = Modifier.padding(horizontal = horizontalPadding)
                    )
                    SectionText(text = "一旦使用者非常熟悉他們選擇的內容，他們作為個人是可能願意在不受控制的環境中絆倒，例如戶外、社交聚會、聚會、狂歡節等，這取決於他們。應該指出的是，在這些環境中絆倒倒會帶來相當大的人身和法律風險。")
                    VerticalSpace()
                }
            }
            CollapsibleSection(title = "Set (State of Mind)") {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {

                    SectionText(
                        text = """
                使用者的心態或心態在決定旅行結果方面起著重要作用。致幻劑會放大一個人當前的精神狀態、情緒和前景：積極的心態可能會變得更加積極，而消極的心態可能會變得更加消極。因此，在生活中極度緊張或消極的時期，通常應避免使用致幻劑。使用者應該充分意識到致幻劑，特別是致幻劑，能夠迫使一個人面對他們當時可能在心理上沒有準備好處理的內部問題。
                那些患有已有精神疾病的人（特別是患有精神分裂症等精神疾病的人）應該避免使用致幻劑，因為它們會強烈放大一個人潛在的精神和情緒狀態，並引發妄想和幻覺。那些希望在這種情況下服用致幻劑的人應尋求合格醫生的建議。
                絆倒時的一個常見建議是「放手」並讓物質的作用發揮作用。人們應該坐在隱喻的乘客座位上，放棄試圖控製或抑制體驗的任何部分。極為重要的是，使用者要放鬆並順其自然，因為任何阻力只會放大試圖避免的事情。
                此外，使用者必須明白，絆倒的體驗通常是難以理解的，這意味著人們應該接受無法理解或表達體驗期間所發生事情的全部範圍。使用者應該接受這樣一個事實：他們的思考過程雖然在某些方面可能更加清晰，但精細運動控制、對話技巧和情境意識將不可避免地受到損害。使用者應該經常提醒自己這些影響是正常的，最重要的是，是暫時的。
            """.trimIndent()
                    )
                    VerticalSpace()
                }
            }
            CollapsibleSection(title = "Bodily State") {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                    SectionText(
                        text = """
                使用者目前的身體狀況與嗑藥時的心情和心態同樣重要。如果一個人感到疲倦、生病或受傷，這些感覺將表現為相同條件的放大版本，當與可能的身體負荷結合時，可能很容易減損或破壞體驗。
                與其在壓力、疲勞、生病或受傷時嗑藥，不如等待更合適的機會。這將大大降低獲得負面或不滿意體驗的機會。
                """.trimIndent()
                    )
                    VerticalSpace()
                }
            }
            CollapsibleSection(title = "Trip Sitters") {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                    SectionText(
                        text = """
                當使用致幻劑時，強烈建議旅行保姆在場，特別是如果一個人對該物質缺乏經驗的話。旅行保母有責任透過保持冷靜和踏實的心態來幫助個人或團體。這可以透過簡單地監視絆倒者並在他們遇到任何焦慮或壓力時平靜地安撫他們來實現，同時也防止他們受到任何傷害。 「旅行保姆」和「保姆」這個名字之間有明顯的相關性：這是因為旅行保姆通常感覺就像照顧保姆，這是一種必須認真對待的責任。
                一個好的旅行保姆必須滿足許多要求。除了成為一個負責任的成年人之外，理想情況下，他們還應該保持清醒，並能夠透過個人經驗或研究知識來了解小組成員的情況。旅行保母應該明白，當一個人絆倒時，他們可能無法像平常那樣進行溝通或互動。此外，他們的平衡和空間判斷可能會受到損害，因此幫助他們執行諸如保持水分或在某個區域中導航等任務可以大大減少焦慮和困惑。旅行保姆可以參與對話，但也應該記住給旅行者空間來探索體驗，而不要受到太多外部影響。
                一旦使用者熟悉了某種物質，他們就可以選擇在沒有保姆的情況下是否感到足夠舒適。也建議在服用高劑量或以前從未服用過的劑量時使用旅行保姆。應該記住，絆倒時有朋友在身邊是避免潛在的心理、醫療或法律後果的最佳方法。
                """.trimIndent()
                    )
                    VerticalSpace()
                }
            }
            CollapsibleSection("Anchors") {
                Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                    SectionText(text = "在使用致幻劑的情況下，錨是一種活動或物理物體，可以在人的時間、空間、記憶和自我意識嚴重扭曲的情況下使使用者保持腳踏實地。如果劑量較高，可能會導致極度迷失方向和混亂。錨通常用來抵消這種情況，並保持人們對當前情況的概念，因為它是現實的。")
                    SectionText(text = "錨點的範例包括：")
                    BulletPoints(
                        points = listOf(
                            "熟悉而振奮人心的音樂。這方面的一個例子包括我們的社區良好氛圍門戶。然而，我們鼓勵用戶創建自己的播放列表，其中包含個人認為快樂和放鬆的音樂。",
                            "極度個人化且根深蒂固的影像或物件。",
                            "不斷重複有意義的單字或座右銘作為口頭禪。",
                            "將易於閱讀的提醒寫在一張大紙上，並在整個體驗過程中將其放在靠近視野的地方。常見的提醒包括物質的名稱及其劑量和短語，例如\"你迷上了LSD。\" 同樣的原理可以用於在手上或其他可見的身體部位寫提醒。",
                            "僅在絆倒過程中穿戴並因此與絆倒行為相關的衣物或配件。"
                        ),
                        modifier = Modifier.padding(horizontal = horizontalPadding)
                    )
                    VerticalSpace()
                }
            }
        }
        CollapsibleSection("Aborting Trips") {
            Column(modifier = Modifier.padding(horizontal = horizontalPadding)) {
                SectionText(
                    text = """
                致幻劑有可能讓人難以承受，並使使用者陷入偏執或可怕的情緒，特別是如果他們缺乏經驗或處於不適當的場景和環境中。
                如果一個人決定終止旅行，苯二氮平類藥物和其他鎮靜劑（例如一些抗精神病藥物）可以被視為類似於下坡或長途旅行的「彈出按鈕」。這些物質往往是預防恐慌、偏執和可能的創傷經驗的非常有效的工具。
                然而，有經驗的用戶通常建議如果可能的話嘗試等待旅行中的困難部分結束。具有挑戰性的時刻通常是暫時的，但可能會成為最好的學習體驗的催化劑。
            """.trimIndent()
                )
                VerticalSpace()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}