package com.example.lab_7

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {
        // 1. Verify that you can properly go from the HomeScreen to the DriversScreen
        composeTestRule
            .onNodeWithTag("driversbutton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertIsDisplayed()

        // 2. Verify that you can properly add at least one driver, and if that driver is properly displayed
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertIsDisplayed()

        // 3. Verify that you can properly clear the driver(s) from the list
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // 4. Verify that the back button takes you back to the HomeScreen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertIsDisplayed()
    }
}
