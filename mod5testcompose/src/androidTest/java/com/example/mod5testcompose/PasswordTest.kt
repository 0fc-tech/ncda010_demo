package com.example.mod5testcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordTest {
    @get:Rule
    val composeTest = createComposeRule()

    @Test
    fun testPasswordField(){
        //On donne à notre tester le composable à tester
        composeTest.setContent { PasswordField() }
        composeTest
            .onNodeWithTag(TEST_TAG_TEXTFIELD_PWD)
            .performTextInput("Hello World")
        composeTest
            .onNodeWithContentDescription(MONTRER_MOT_DE_PASSE)
            .performClick()
        composeTest
            .onNodeWithContentDescription(CACHER_MOT_DE_PASSE)
            .assertExists()
        composeTest.onNodeWithTag(TEST_TAG_TEXTFIELD_PWD)
            .assertIsDisplayed()
    }
}

